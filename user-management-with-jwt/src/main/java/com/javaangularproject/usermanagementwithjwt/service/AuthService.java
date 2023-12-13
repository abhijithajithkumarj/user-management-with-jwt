package com.javaangularproject.usermanagementwithjwt.service;

import com.javaangularproject.usermanagementwithjwt.dto.SignupRequest;
import com.javaangularproject.usermanagementwithjwt.entity.Users;

public interface AuthService {
    Users createUser(SignupRequest signupRequest);
}
