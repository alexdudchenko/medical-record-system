package com.alex.dudchenko.auth.service.service;

import com.alex.dudchenko.auth.service.model.dto.RefreshRequest;
import com.alex.dudchenko.auth.service.model.dto.AuthRequest;
import com.alex.dudchenko.auth.service.model.dto.AuthResponse;
import org.springframework.data.util.Pair;

import javax.naming.AuthenticationException;

public interface AuthenticationService {

    Pair<String, String> authenticate(AuthRequest authRequest) throws AuthenticationException;

    String refresh(String refreshToken) throws AuthenticationException;
}
