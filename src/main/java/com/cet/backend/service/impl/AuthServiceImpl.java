package com.cet.backend.service.impl;

import com.cet.backend.dto.RegisterRequest;
import com.cet.backend.entity.User;
import com.cet.backend.repository.UserRepository;
import com.cet.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword()) // Encrypt later using BCrypt
                .role("STUDENT")
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }
}