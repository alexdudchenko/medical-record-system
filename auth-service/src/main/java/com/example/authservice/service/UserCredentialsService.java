package com.example.authservice.service;

import com.example.authservice.model.UserCredentials;

public interface UserCredentialsService {

    UserCredentials getUserCredentials(String email);
    UserCredentials saveUserCredentials(UserCredentials userCredentials);
    void deleteUserCredentialsById(Long id);
}
