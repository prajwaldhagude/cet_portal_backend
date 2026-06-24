package com.cet.backend.controller;

import com.cet.backend.dto.LoginRequest;
import com.cet.backend.dto.LoginResponse;
import com.cet.backend.dto.RegisterRequest;
import com.cet.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

 @PostMapping("/login")
public ResponseEntity<LoginResponse> login(
        @RequestBody LoginRequest request) {

    LoginResponse response = authService.login(request);

    return ResponseEntity.ok(response);
}
}