package com.alex.dudchenko.auth.service.service.impl;

import com.alex.dudchenko.auth.service.model.dto.Doctor;
import com.alex.dudchenko.auth.service.service.DoctorProfileService;
import com.alex.dudchenko.auth.service.service.client.DoctorProfileClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorProfileServiceImpl implements DoctorProfileService {

    private final DoctorProfileClient client;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return client.saveDoctor(doctor);
    }

    @Override
    public void deleteDoctor(Long doctorProfileId) {
        client.deleteDoctor(doctorProfileId);
    }
}
