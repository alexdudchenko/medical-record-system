package com.alex.dudchenko.medical.record.service.service;

import com.alex.dudchenko.medical.record.service.model.MedicalRecord;

public interface MedicalRecordService {

    MedicalRecord findMedicalRecordById(Long id);
    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);
    void deleteMedicalRecordById(Long id);
}
