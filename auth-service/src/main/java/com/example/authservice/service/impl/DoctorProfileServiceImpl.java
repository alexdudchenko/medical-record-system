package com.example.authservice.service.impl;

import com.example.authservice.model.dto.Doctor;
import com.example.authservice.service.DoctorProfileService;
import com.example.authservice.service.client.DoctorProfileClient;
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
