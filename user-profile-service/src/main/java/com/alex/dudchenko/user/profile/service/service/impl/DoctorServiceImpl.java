package com.alex.dudchenko.user.profile.service.service.impl;

import com.alex.dudchenko.user.profile.service.model.Doctor;
import com.alex.dudchenko.user.profile.service.repository.DoctorRepository;
import com.alex.dudchenko.user.profile.service.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email).orElseThrow();
    }
}
