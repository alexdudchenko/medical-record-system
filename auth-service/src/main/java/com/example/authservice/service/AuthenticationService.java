package com.example.authservice.service;

import com.example.authservice.model.dto.AuthRequest;
import com.example.authservice.model.dto.AuthResponse;
import com.example.authservice.model.dto.RefreshRequest;

import javax.naming.AuthenticationException;

public interface AuthenticationService {

    AuthResponse authenticate(AuthRequest authRequest) throws AuthenticationException;

    AuthResponse refresh(RefreshRequest refreshRequest) throws AuthenticationException;
}
