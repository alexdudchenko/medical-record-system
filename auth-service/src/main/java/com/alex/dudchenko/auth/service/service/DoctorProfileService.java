package com.alex.dudchenko.auth.service.service;

import com.alex.dudchenko.auth.service.model.dto.Doctor;

public interface DoctorProfileService {

    Doctor saveDoctor(Doctor doctor);
    void deleteDoctor(Long doctorProfileId);
}
