package com.example.authservice.service;

import com.example.authservice.model.dto.DoctorRegistrationData;
import com.example.authservice.model.dto.PatientRegistrationData;

public interface RegistrationService {

    void registerDoctor(DoctorRegistrationData data);
    void registerPatient(PatientRegistrationData data);
}
