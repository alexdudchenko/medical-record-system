package com.alex.dudchenko.user.profile.service.service.impl;

import com.alex.dudchenko.user.profile.service.model.Patient;
import com.alex.dudchenko.user.profile.service.repository.PatientRepository;
import com.alex.dudchenko.user.profile.service.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        if (patient.getUid() == null) {
            String uid = UUID.randomUUID().toString().substring(0, 8);
            patient.setUid(uid);
        }
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
    public List<Patient> findPatientByEmail(String email) {
        return List.of(patientRepository.findByEmail(email).orElseThrow());
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByUid(String uid) {
        return List.of(patientRepository.findByUid(uid).orElseThrow());
    }

    @Override
    public List<Patient> findPatientsByPattern(String pattern) {
        return patientRepository.findPatientsBySearchableDetailsContains(pattern);
    }
}
