package com.exemple.usermanager;

import com.exemple.usermanager.entities.User;
import com.exemple.usermanager.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserManagerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserService userService;

}
