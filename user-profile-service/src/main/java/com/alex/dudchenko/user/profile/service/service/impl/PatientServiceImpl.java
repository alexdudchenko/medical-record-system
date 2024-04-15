package com.alex.dudchenko.user.profile.service.service.impl;

import com.alex.dudchenko.user.profile.service.model.Patient;
import com.alex.dudchenko.user.profile.service.repository.PatientRepository;
import com.alex.dudchenko.user.profile.service.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findByUid(String uid) {
        return patientRepository.findByUid(uid).orElseThrow();
    }
}
