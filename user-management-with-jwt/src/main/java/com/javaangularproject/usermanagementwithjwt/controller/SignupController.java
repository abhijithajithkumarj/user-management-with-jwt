package com.javaangularproject.usermanagementwithjwt.controller;

import com.javaangularproject.usermanagementwithjwt.dto.SignupRequest;
import com.javaangularproject.usermanagementwithjwt.entity.Users;
import com.javaangularproject.usermanagementwithjwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        Users user = authService.createUser(signupRequest);
        if (user != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }
    }


}
