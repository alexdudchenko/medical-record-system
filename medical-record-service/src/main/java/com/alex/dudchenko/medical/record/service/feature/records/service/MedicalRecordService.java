package com.alex.dudchenko.medical.record.service.feature.records.service;

import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecord;

public interface MedicalRecordService {

    MedicalRecord findMedicalRecordByPatientId(Long id);
    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);
    void deleteMedicalRecordById(Long id);
}
