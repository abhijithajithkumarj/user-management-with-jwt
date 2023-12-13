package com.javaangularproject.usermanagementwithjwt.controller;


import com.javaangularproject.usermanagementwithjwt.dto.HelloResponse;
import com.javaangularproject.usermanagementwithjwt.entity.Users;
import com.javaangularproject.usermanagementwithjwt.service.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/hello")
    public HelloResponse hello(@AuthenticationPrincipal(expression = "username") String email){
        Users users = userService.getUserByEmail(email);
        return new HelloResponse("Hello " +users.getName());
    }

    @GetMapping("/profile")
    public ResponseEntity<Users> getAllUsers(@AuthenticationPrincipal(expression = "username") String email){
        Users users = userService.getUserByEmail(email);
        System.out.println(users);
        return ResponseEntity.ok(users);
    }
}
