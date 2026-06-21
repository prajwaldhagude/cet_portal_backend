package com.cet.backend.service.impl;

import com.cet.backend.dto.LoginRequest;
import com.cet.backend.dto.LoginResponse;
import com.cet.backend.dto.RegisterRequest;
import com.cet.backend.entity.User;
import com.cet.backend.repository.UserRepository;
import com.cet.backend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(RegisterRequest request) {

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .role("STUDENT")
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return new LoginResponse(
                "Login Successful",
                user.getEmail(),
                user.getRole()
        );
    }
}