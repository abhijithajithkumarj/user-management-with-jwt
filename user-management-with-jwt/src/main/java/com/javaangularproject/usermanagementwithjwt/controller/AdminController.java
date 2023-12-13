package com.javaangularproject.usermanagementwithjwt.controller;


import com.javaangularproject.usermanagementwithjwt.dto.HelloResponse;
import com.javaangularproject.usermanagementwithjwt.entity.Users;
import com.javaangularproject.usermanagementwithjwt.service.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/hi")
    public HelloResponse adminMsg(){
        return new HelloResponse("Welcome back admin");
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        System.out.println("deleting"+userId);
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }


}