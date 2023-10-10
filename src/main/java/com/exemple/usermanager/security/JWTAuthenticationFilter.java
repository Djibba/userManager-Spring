package com.exemple.usermanager.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.exemple.usermanager.entities.User;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.json.JsonParseException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        User user = null;

        try {
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JsonParseException e) {
            e.printStackTrace();
        }

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();

        List<String> roles = new ArrayList<>();
        user.getAuthorities().forEach(authority -> {
            roles.add(authority.getAuthority());
        });

        String jwt = JWT.create().
                withSubject(user.getUsername()).
                        withArrayClaim("roles", roles.toArray(new String[roles.size()])).
                                withExpiresAt(new Date(System.currentTimeMillis() + 10*24*60*60*1000)).
                                        sign(Algorithm.HMAC256("djibbagueye@gmail.com"));

        response.addHeader("Authorization", "Bearer " + jwt);
        chain.doFilter(request, response);
    }
}
