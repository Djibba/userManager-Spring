package com.exemple.usermanager;

import com.exemple.usermanager.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagerApplication {

    @Autowired
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }

    @PostConstruct
    public void init_users(){
        System.out.println("Application started ...");

        // ajout des roles
    }

}
