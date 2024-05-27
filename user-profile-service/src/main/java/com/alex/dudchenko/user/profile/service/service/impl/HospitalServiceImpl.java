package com.alex.dudchenko.user.profile.service.service.impl;

import com.alex.dudchenko.user.profile.service.model.Hospital;
import com.alex.dudchenko.user.profile.service.repository.HospitalRepository;
import com.alex.dudchenko.user.profile.service.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;


    @Override
    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospitalById(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public Hospital getHospital(Long id) {
        return hospitalRepository.findById(id).orElseThrow();
    }
}
