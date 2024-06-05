package com.alex.dudchenko.medical.record.service.feature.records.repository;

import com.alex.dudchenko.medical.record.service.feature.records.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    List<Vaccination> findAllByMedicalRecordPatientId(Long patientId);
}
