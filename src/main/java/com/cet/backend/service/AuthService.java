package com.cet.backend.service;

import com.cet.backend.dto.LoginRequest;
import com.cet.backend.dto.LoginResponse;
import com.cet.backend.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}