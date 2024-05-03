package com.alex.dudchenko.medical.record.service.service;

import com.alex.dudchenko.medical.record.service.model.FileAttachment;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileAttachmentService {

    Pair<String, Resource> findFileAttachmentById(Long id);
    List<FileAttachment> findFileAttachmentsByMedicalRecordEntryId(Long medicalRecordEntryId);
    FileAttachment saveFileAttachment(MultipartFile multipartFile, Long medicalRecordEntryId);
    void deleteFileAttachmentById(Long id);
}
