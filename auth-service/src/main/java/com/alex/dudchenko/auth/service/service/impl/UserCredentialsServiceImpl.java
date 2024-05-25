package com.alex.dudchenko.auth.service.service.impl;

import com.alex.dudchenko.auth.service.model.Role;
import com.alex.dudchenko.auth.service.model.UserCredentials;
import com.alex.dudchenko.auth.service.repository.UserCredentialsRepository;
import com.alex.dudchenko.auth.service.service.DoctorProfileService;
import com.alex.dudchenko.auth.service.service.PatientProfileService;
import com.alex.dudchenko.auth.service.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsRepository repository;
    private final DoctorProfileService doctorProfileService;
    private final PatientProfileService patientProfileService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCredentials getUserCredentials(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    @Override
    public UserCredentials saveUserCredentials(UserCredentials userCredentials) {
        return repository.save(userCredentials);
    }

    public UserCredentials updateUserCredentials(UserCredentials userCredentials) {
        UserCredentials toUpdate = repository.findByEmail(userCredentials.getEmail()).get();
        toUpdate.setHashedPassword(passwordEncoder.encode(userCredentials.getHashedPassword()));
        return repository.save(toUpdate);
    }

    @Override
    public void deleteUserCredentialsById(Long id) {
        UserCredentials credentials = repository.findById(id).orElseThrow();
        if (Role.DOCTOR.name().equals(credentials.getRole())) {
            doctorProfileService.deleteDoctor(credentials.getProfileId());
        } else if (Role.PATIENT.name().equals(credentials.getRole())) {
            patientProfileService.deletePatient(credentials.getProfileId());
        }
        repository.deleteById(id);
    }
}
