package com.alex.dudchenko.medical.record.service.repository;

import com.alex.dudchenko.medical.record.service.model.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileAttachmentRepository extends JpaRepository<FileAttachment, Long> {

    List<FileAttachment> findFileAttachmentsByMedicalRecordEntryId(Long medicalRecordEntryId);
}
