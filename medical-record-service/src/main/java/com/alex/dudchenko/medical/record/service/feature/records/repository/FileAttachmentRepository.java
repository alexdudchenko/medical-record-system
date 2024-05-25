package com.alex.dudchenko.medical.record.service.feature.records.repository;

import com.alex.dudchenko.medical.record.service.feature.records.model.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileAttachmentRepository extends JpaRepository<FileAttachment, Long> {

    List<FileAttachment> findFileAttachmentsByMedicalRecordEntryId(Long medicalRecordEntryId);
}
