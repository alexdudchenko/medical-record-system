package com.alex.dudchenko.user.profile.service.service;

import com.alex.dudchenko.user.profile.service.model.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);
    void deleteDoctor(Long id);
    List<Doctor> findAllDoctors();
    Doctor findDoctorById(Long id);
    Doctor findDoctorByEmail(String email);
}
