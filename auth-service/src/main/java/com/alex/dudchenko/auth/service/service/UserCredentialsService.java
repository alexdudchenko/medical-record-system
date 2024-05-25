package com.alex.dudchenko.auth.service.service;

import com.alex.dudchenko.auth.service.model.UserCredentials;

public interface UserCredentialsService {

    UserCredentials getUserCredentials(String email);
    UserCredentials saveUserCredentials(UserCredentials userCredentials);
    UserCredentials updateUserCredentials(UserCredentials userCredentials);
    void deleteUserCredentialsById(Long id);
}
