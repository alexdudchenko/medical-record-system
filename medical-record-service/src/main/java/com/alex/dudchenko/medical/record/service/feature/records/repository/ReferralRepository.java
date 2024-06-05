package com.alex.dudchenko.medical.record.service.feature.records.repository;

import com.alex.dudchenko.medical.record.service.feature.records.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReferralRepository extends JpaRepository<Referral, Long> {

    List<Referral> findAllByMedicalRecordPatientId(Long patientId);
}
