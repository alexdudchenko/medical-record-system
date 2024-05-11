package com.example.authservice.service;

import com.example.authservice.model.dto.Doctor;

public interface DoctorProfileService {

    Doctor saveDoctor(Doctor doctor);
    void deleteDoctor(Long doctorProfileId);
}
