package com.example.authservice.service.impl;

import com.example.authservice.model.UserCredentials;
import com.example.authservice.model.dto.AuthRequest;
import com.example.authservice.model.dto.AuthResponse;
import com.example.authservice.model.dto.RefreshRequest;
import com.example.authservice.service.AuthenticationService;
import com.example.authservice.service.UserCredentialsService;
import com.example.authservice.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsService userCredentialsService;
    private final JwtUtil jwtUtil;


    @Override
    public AuthResponse authenticate(AuthRequest authRequest) throws AuthenticationException {
        UserCredentials credentials = userCredentialsService.getUserCredentials(authRequest.getEmail());

        boolean passwordMatched = passwordEncoder.matches(authRequest.getPassword(), credentials.getHashedPassword());

        if (!passwordMatched) {
            throw new AuthenticationException("Wrong username or password");
        }

        String accessToken = jwtUtil.generate(credentials, "ACCESS");
        String refreshToken = jwtUtil.generate(credentials, "REFRESH");
        return new AuthResponse(accessToken, refreshToken);
    }

    @Override
    public AuthResponse refresh(RefreshRequest refreshRequest) throws AuthenticationException {
        boolean isRefreshTokenExpired = jwtUtil.isExpired(refreshRequest.getRefreshToken());

        if (isRefreshTokenExpired) {
            throw new AuthenticationException("Wrong username or password");
        }

        String accessToken = jwtUtil.generate(refreshRequest.getRefreshToken(), "ACCESS");
        String refreshToken = jwtUtil.generate(refreshRequest.getRefreshToken(), "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }
}
