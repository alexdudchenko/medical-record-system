package com.alex.dudchenko.auth.service.service.impl;

import com.alex.dudchenko.auth.service.service.client.PatientProfileClient;
import com.alex.dudchenko.auth.service.model.dto.Patient;
import com.alex.dudchenko.auth.service.service.PatientProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileClient client;

    @Override
    public Patient savePatient(Patient patient) {
        return client.savePatient(patient);
    }

    @Override
    public void deletePatient(Long patientProfileId) {
        client.deletePatient(patientProfileId);
    }
}
