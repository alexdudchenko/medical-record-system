package com.example.authservice.service;

import com.example.authservice.model.dto.Patient;

public interface PatientProfileService {

    Patient savePatient(Patient patient);
    void deletePatient(Long patientProfileId);
}
