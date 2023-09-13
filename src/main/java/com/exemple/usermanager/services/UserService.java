package com.exemple.usermanager.services;

import com.exemple.usermanager.entities.Role;
import com.exemple.usermanager.entities.User;

public interface UserService {

    User saveUser(User u);
    User findUserByUsername(String username);
    Role addRole(Role r);
    User addRoleToUser(String username, String roleName);

}
