package com.alex.dudchenko.medical.record.service.feature.records.repository;

import com.alex.dudchenko.medical.record.service.feature.records.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findAllByMedicalRecordPatientId(Long patientId);
}
