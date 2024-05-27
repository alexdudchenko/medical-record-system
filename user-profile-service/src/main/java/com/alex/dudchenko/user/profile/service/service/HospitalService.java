package com.alex.dudchenko.user.profile.service.service;

import com.alex.dudchenko.user.profile.service.model.Hospital;

import java.util.List;

public interface HospitalService {

    List<Hospital> getHospitals();
    Hospital saveHospital(Hospital hospital);
    void deleteHospitalById(Long id);
    Hospital getHospital(Long id);
}
