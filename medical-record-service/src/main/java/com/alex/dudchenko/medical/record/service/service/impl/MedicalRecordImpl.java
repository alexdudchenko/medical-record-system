package com.alex.dudchenko.medical.record.service.service.impl;

import com.alex.dudchenko.medical.record.service.model.MedicalRecord;
import com.alex.dudchenko.medical.record.service.repository.MedicalRecordRepository;
import com.alex.dudchenko.medical.record.service.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalRecordImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecord findMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id).orElseThrow();
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
