package com.cet.backend.service;

import com.cet.backend.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);
}