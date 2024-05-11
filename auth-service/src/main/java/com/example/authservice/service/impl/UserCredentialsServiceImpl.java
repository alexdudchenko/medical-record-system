package com.example.authservice.service.impl;

import com.example.authservice.model.UserCredentials;
import com.example.authservice.repository.UserCredentialsRepository;
import com.example.authservice.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsRepository repository;

    @Override
    public UserCredentials getUserCredentials(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    @Override
    public UserCredentials saveUserCredentials(UserCredentials userCredentials) {
        return repository.save(userCredentials);
    }

    @Override
    public void deleteUserCredentialsById(Long id) {
        repository.deleteById(id);
    }
}
