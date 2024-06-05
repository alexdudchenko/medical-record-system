package com.alex.dudchenko.medical.record.service.feature.records.service;

import com.alex.dudchenko.medical.record.service.feature.records.model.Vaccination;

import java.util.List;

public interface VaccinationService {

    Vaccination save(Vaccination vaccination);
    void deleteById(Long id);
    List<Vaccination> findAllByPatientId(Long patientId);
}
