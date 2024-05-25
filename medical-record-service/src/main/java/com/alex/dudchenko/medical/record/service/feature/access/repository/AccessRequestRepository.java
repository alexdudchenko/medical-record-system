package com.alex.dudchenko.medical.record.service.feature.access.repository;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {

    List<AccessRequest> findAccessRequestByStatusAndMedicalRecordPatientId(String status, Long patientId);
    List<AccessRequest> findAccessRequestByStatusAndMedicalRecordPatientIdAndDoctorId(String status, Long patientId, Long doctorId);
}
