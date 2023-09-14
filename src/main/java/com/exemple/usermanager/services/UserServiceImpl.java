package com.exemple.usermanager.services;

import com.exemple.usermanager.entities.Role;
import com.exemple.usermanager.entities.User;
import com.exemple.usermanager.repos.RoleRepository;
import com.exemple.usermanager.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
//    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role r) {
        return roleRepository.save(r);
    }

    @Override
    public User addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);

        user.getRoles().add(role);
        //userRepository.save(user); @transactional va le faire automatiquement
        return user;
    }
}
