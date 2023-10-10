package com.exemple.usermanager;

import com.exemple.usermanager.entities.User;
import com.exemple.usermanager.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserManagerApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }

//    @PostConstruct
//     public void init(){
//
//        // ajout des roles
//        userService.addRoleToUser("admin", "ADMIN");
//        userService.addRoleToUser("user", "USER");
//
//        //ajout des users
//        userService.saveUser(new User(null, "admin", "1234", true, null));
//        userService.saveUser(new User(null, "djibba", "1234", true, null));
//        userService.saveUser(new User(null, "abdallah", "1234", true, null));
//
//        // ajout des roles au user
//        userService.addRoleToUser("admin", "ADMIN");
//        userService.addRoleToUser("admin", "USER");
//        userService.addRoleToUser("djibba", "USER");
//        userService.addRoleToUser("abdallah", "USER");
//    }

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}
