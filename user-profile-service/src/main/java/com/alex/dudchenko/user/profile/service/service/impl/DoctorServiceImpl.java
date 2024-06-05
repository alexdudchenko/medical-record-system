package com.alex.dudchenko.user.profile.service.service.impl;

import com.alex.dudchenko.user.profile.service.model.Doctor;
import com.alex.dudchenko.user.profile.service.model.DoctorPlaceOfWork;
import com.alex.dudchenko.user.profile.service.repository.DoctorPlaceOfWorkRepository;
import com.alex.dudchenko.user.profile.service.repository.DoctorRepository;
import com.alex.dudchenko.user.profile.service.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorPlaceOfWorkRepository doctorPlaceOfWorkRepository;

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
    public List<Doctor> findDoctorByEmail(String email) {
        return List.of(doctorRepository.findByEmail(email).orElseThrow());
    }

    @Override
    public List<Doctor> findDoctorsByPattern(String pattern) {
        return doctorRepository.findDoctorsBySearchableDetailsContains(pattern);
    }

    @Override
    public List<Doctor> findUnverifiedDoctors() {
        return doctorRepository.findDoctorByVerified(Boolean.FALSE);
    }

    @Override
    public List<Doctor> findDoctorsByIds(List<Long> ids) {
        return doctorRepository.findAllById(ids);
    }
}
