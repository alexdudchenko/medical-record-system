package com.alex.dudchenko.auth.service.controller;

import com.alex.dudchenko.auth.service.service.AuthenticationService;
import com.alex.dudchenko.auth.service.model.dto.AuthRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest, HttpServletResponse response) throws AuthenticationException {
        Pair<String, String> tokens = authenticationService.authenticate(authRequest);

        Cookie cookie = new Cookie("refresh-token", tokens.getSecond());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(24*60*60);

        response.addCookie(cookie);
        return ResponseEntity.ok(tokens.getFirst());
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@CookieValue("refresh-token") String refreshToken) throws AuthenticationException {
        return ResponseEntity.ok(authenticationService.refresh(refreshToken));
    }
}
