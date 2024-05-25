package com.alex.dudchenko.medical.record.service.feature.access.repository;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRecordRepository extends JpaRepository<AccessRecord, Long> {

    List<AccessRecord> findByMedicalRecordPatientIdAndDoctorId(Long patientId, Long doctorId);
    List<AccessRecord> findByMedicalRecordPatientId(Long patientId);
}
