package com.alex.dudchenko.medical.record.service.feature.records.service.impl;

import com.alex.dudchenko.medical.record.service.feature.records.model.Prescription;
import com.alex.dudchenko.medical.record.service.feature.records.repository.PrescriptionRepository;
import com.alex.dudchenko.medical.record.service.feature.records.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription save(Prescription prescription) {
        prescription.setCreationDate(LocalDate.now());
        prescription.setUid(UUID.randomUUID().toString());
        return prescriptionRepository.save(prescription);
    }

    @Override
    public void deleteById(Long id) {
        prescriptionRepository.deleteById(id);
    }

    @Override
    public List<Prescription> findAllByPatientId(Long patientId) {
        return prescriptionRepository.findAllByMedicalRecordPatientId(patientId);
    }
}
