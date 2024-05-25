package com.alex.dudchenko.auth.service.service;

import com.alex.dudchenko.auth.service.model.dto.Patient;

public interface PatientProfileService {

    Patient savePatient(Patient patient);
    void deletePatient(Long patientProfileId);
}
