package com.exemple.usermanager.services;

import com.exemple.usermanager.entities.Role;
import com.exemple.usermanager.entities.User;
import com.exemple.usermanager.repos.RoleRepository;
import com.exemple.usermanager.repos.UserRepository;

public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RoleRepository roleRepository;
    @Override
    public User saveUser(User u) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public Role addRole(Role r) {
        return null;
    }

    @Override
    public User addRoleToUser(String username, String roleName) {
        return null;
    }
}
