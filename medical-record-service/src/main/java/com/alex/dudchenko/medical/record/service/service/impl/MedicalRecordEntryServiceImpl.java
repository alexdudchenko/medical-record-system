package com.alex.dudchenko.medical.record.service.service.impl;

import com.alex.dudchenko.medical.record.service.model.MedicalRecordEntry;
import com.alex.dudchenko.medical.record.service.repository.MedicalRecordEntryRepository;
import com.alex.dudchenko.medical.record.service.service.MedicalRecordEntryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicalRecordEntryServiceImpl implements MedicalRecordEntryService {

    private final MedicalRecordEntryRepository medicalRecordEntryRepository;

    @Override
    public MedicalRecordEntry createMedicalRecordEntry(MedicalRecordEntry medicalRecordEntry) {
        return medicalRecordEntryRepository.save(medicalRecordEntry);
    }

    @Override
    public MedicalRecordEntry findMedicalRecordEntryById(Long id) {
        return medicalRecordEntryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<MedicalRecordEntry> findMedicalRecordEntryByMedicalRecordId(Long medicalRecordId) {
        return medicalRecordEntryRepository.findByMedicalRecordId(medicalRecordId);
    }

    @Override
    public void deleteMedicalRecordEntryById(Long id) {
        medicalRecordEntryRepository.deleteById(id);
    }

    @Override
    public List<MedicalRecordEntry> findMedicalRecordEntriesByPatientId(Long patientId) {
        return medicalRecordEntryRepository.findByMedicalRecordPatientId(patientId);
    }
}
