package com.alex.dudchenko.auth.service.service.impl;

import com.alex.dudchenko.auth.service.model.UserCredentials;
import com.alex.dudchenko.auth.service.service.AuthenticationService;
import com.alex.dudchenko.auth.service.service.UserCredentialsService;
import com.alex.dudchenko.auth.service.util.JwtUtils;
import com.alex.dudchenko.auth.service.model.dto.AuthRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsService userCredentialsService;
    private final JwtUtils jwtUtils;


    @Override
    public Pair<String, String> authenticate(AuthRequest authRequest) throws AuthenticationException {
        UserCredentials credentials = userCredentialsService.getUserCredentials(authRequest.getEmail());

        boolean passwordMatched = passwordEncoder.matches(authRequest.getPassword(), credentials.getHashedPassword());

        if (!passwordMatched) {
            throw new AuthenticationException("Wrong username or password");
        }

        String accessToken = jwtUtils.generate(credentials, "ACCESS");
        String refreshToken = jwtUtils.generate(credentials, "REFRESH");
        return Pair.of(accessToken, refreshToken);
    }

    @Override
    public String refresh(String refreshToken) throws AuthenticationException {
        boolean isRefreshTokenExpired = jwtUtils.isExpired(refreshToken);

        if (isRefreshTokenExpired) {
            throw new AuthenticationException("Refresh token expired");
        }

        return jwtUtils.generate(refreshToken, "ACCESS");
    }
}
