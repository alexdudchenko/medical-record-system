package com.alex.dudchenko.medical.record.service.service.impl;

import com.alex.dudchenko.medical.record.service.model.FileAttachment;
import com.alex.dudchenko.medical.record.service.repository.FileAttachmentRepository;
import com.alex.dudchenko.medical.record.service.service.FileAttachmentService;
import com.alex.dudchenko.medical.record.service.service.MedicalRecordEntryService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FileAttachmentServiceImpl implements FileAttachmentService {

    private static final String uploadDir = "uploads/";
    private final FileAttachmentRepository fileAttachmentRepository;
    private final MedicalRecordEntryService medicalRecordEntryService;


    @SneakyThrows
    @Override
    public Pair<String, Resource> findFileAttachmentById(Long id) {
        FileAttachment attachment = fileAttachmentRepository.findById(id).orElseThrow();
        return Pair.of(attachment.getFileName(),
                new ByteArrayResource(Files.readAllBytes(Path.of(attachment.getFilePath()))));
    }

    @SneakyThrows
    @Override
    public List<FileAttachment> findFileAttachmentsByMedicalRecordEntryId(Long medicalRecordEntryId) {
        return fileAttachmentRepository.findFileAttachmentsByMedicalRecordEntryId(medicalRecordEntryId);
    }

    @Override
    @SneakyThrows
    public FileAttachment saveFileAttachment(MultipartFile multipartFile, Long medicalRecordEntryId) {
        FileAttachment attachment = new FileAttachment();
        attachment.setFileName(multipartFile.getOriginalFilename());
        attachment.setFilePath(UUID.randomUUID().toString());
        attachment.setMedicalRecordEntry(medicalRecordEntryService.findMedicalRecordEntryById(medicalRecordEntryId));

        FileAttachment savedFileAttachment = fileAttachmentRepository.save(attachment);

        Path path = Paths.get(uploadDir);
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }
        Path filePath = Paths.get(uploadDir + savedFileAttachment.getFilePath());
        Files.copy(multipartFile.getInputStream(), filePath);

        return savedFileAttachment;
    }

    @Override
    public void deleteFileAttachmentById(Long id) {
        fileAttachmentRepository.deleteById(id);
    }
}
