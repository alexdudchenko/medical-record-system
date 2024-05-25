package com.alex.dudchenko.auth.service.controller;

import com.alex.dudchenko.auth.service.model.UserCredentials;
import com.alex.dudchenko.auth.service.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/users")
@AllArgsConstructor
public class UserController {

    private final UserCredentialsService userCredentialsService;

    @PutMapping("/{id}")
    public void put(@RequestBody UserCredentials userCredentials) {
        userCredentialsService.updateUserCredentials(userCredentials);
    }

}
