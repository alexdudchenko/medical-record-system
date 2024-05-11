package com.example.authservice.service.impl;

import com.example.authservice.model.dto.Patient;
import com.example.authservice.service.PatientProfileService;
import com.example.authservice.service.client.PatientProfileClient;
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
