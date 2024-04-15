package com.alex.dudchenko.user.profile.service.service;

import com.alex.dudchenko.user.profile.service.model.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);
    void deletePatient(Long id);
    Patient findPatientById(Long id);
    Patient findPatientByEmail(String email);
    List<Patient> findAllPatients();
    Patient findByUid(String uid);
}
