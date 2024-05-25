package com.alex.dudchenko.medical.record.service.feature.records.service;

import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecordEntry;

import java.util.List;

public interface MedicalRecordEntryService {

    MedicalRecordEntry createMedicalRecordEntry(MedicalRecordEntry medicalRecordEntry);
    MedicalRecordEntry findMedicalRecordEntryById(Long id);
    List<MedicalRecordEntry> findMedicalRecordEntryByMedicalRecordId(Long medicalRecordId);
    void deleteMedicalRecordEntryById(Long id);
    List<MedicalRecordEntry> findMedicalRecordEntriesByPatientId(Long patientId);

}