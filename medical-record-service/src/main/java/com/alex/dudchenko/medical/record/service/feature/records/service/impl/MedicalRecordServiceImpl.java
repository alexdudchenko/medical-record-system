package com.alex.dudchenko.medical.record.service.feature.records.service.impl;

import com.alex.dudchenko.medical.record.service.feature.records.repository.MedicalRecordRepository;
import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecord;
import com.alex.dudchenko.medical.record.service.feature.records.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecord findMedicalRecordByPatientId(Long id) {
        return medicalRecordRepository.findByPatientId(id).orElseThrow();
    }

    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void deleteMedicalRecordById(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}
