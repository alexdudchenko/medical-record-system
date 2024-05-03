package com.alex.dudchenko.medical.record.service.repository;

import com.alex.dudchenko.medical.record.service.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
