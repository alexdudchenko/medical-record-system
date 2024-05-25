package com.alex.dudchenko.auth.service.service;

import com.alex.dudchenko.auth.service.model.dto.DoctorRegistrationData;
import com.alex.dudchenko.auth.service.model.dto.PatientRegistrationData;

public interface RegistrationService {

    void registerDoctor(DoctorRegistrationData data);
    void registerPatient(PatientRegistrationData data);
}
