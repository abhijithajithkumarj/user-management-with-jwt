package com.javaangularproject.usermanagementwithjwt.service.Impl;


import com.javaangularproject.usermanagementwithjwt.dto.SignupRequest;
import com.javaangularproject.usermanagementwithjwt.entity.Role;
import com.javaangularproject.usermanagementwithjwt.entity.Users;
import com.javaangularproject.usermanagementwithjwt.repository.RoleRepository;
import com.javaangularproject.usermanagementwithjwt.repository.UserRepository;
import com.javaangularproject.usermanagementwithjwt.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public Users createUser(SignupRequest signupRequest) {
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return null;
        }
        Optional<Role> userRoleOptional = roleRepository.findRoleByName("ROLE_USER");
        Role userRole = userRoleOptional.orElseGet(()->{
            Role newRole = new Role();
            newRole.setRoleName("ROLE_USER");
            return roleRepository.save(newRole);
        });
        Users users = new Users();
        BeanUtils.copyProperties(signupRequest, users);
        String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
        users.setPassword(hashedPassword);
        users.setRole(userRole);
        Users createdUser = userRepository.save(users);
        users.setId(createdUser.getId());
        return users;

    }
}
