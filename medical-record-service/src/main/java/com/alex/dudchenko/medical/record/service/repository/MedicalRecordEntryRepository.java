package com.alex.dudchenko.medical.record.service.repository;

import com.alex.dudchenko.medical.record.service.model.MedicalRecord;
import com.alex.dudchenko.medical.record.service.model.MedicalRecordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordEntryRepository extends JpaRepository<MedicalRecordEntry, Long> {

    List<MedicalRecordEntry> findByMedicalRecordId(Long medicalRecordId);
    List<MedicalRecordEntry> findByMedicalRecordPatientId(Long patientId);
}
