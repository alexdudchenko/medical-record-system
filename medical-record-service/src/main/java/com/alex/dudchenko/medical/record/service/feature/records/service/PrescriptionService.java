package com.alex.dudchenko.medical.record.service.feature.records.service;

import com.alex.dudchenko.medical.record.service.feature.records.model.Prescription;

import java.util.List;

public interface PrescriptionService {

    Prescription save(Prescription prescription);
    void deleteById(Long id);
    List<Prescription> findAllByPatientId(Long patientId);
}
