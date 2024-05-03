package com.alex.dudchenko.medical.record.service.controller;

import com.alex.dudchenko.medical.record.service.model.FileAttachment;
import com.alex.dudchenko.medical.record.service.service.FileAttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
public class FileAttachmentController {

    private final FileAttachmentService fileAttachmentService;

    @GetMapping("/entries/{medicalRecordEntryId}/fileAttachments/{id}")
    public ResponseEntity<Resource> getFileAttachment(@PathVariable Long id) {
        Pair<String, Resource> attachmentDetails = fileAttachmentService.findFileAttachmentById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + attachmentDetails.getFirst() + "\"")
                .body(attachmentDetails.getSecond());
    }

    @GetMapping("/entries/{medicalRecordEntryId}/fileAttachments")
    public List<FileAttachment> getFileAttachments(@PathVariable Long medicalRecordEntryId) {
        return fileAttachmentService.findFileAttachmentsByMedicalRecordEntryId(medicalRecordEntryId);
    }

    @PostMapping("/entries/{medicalRecordEntryId}/fileAttachments")
    public FileAttachment createFileAttachment(@RequestBody MultipartFile file, @PathVariable Long medicalRecordEntryId) {
        return fileAttachmentService.saveFileAttachment(file, medicalRecordEntryId);
    }

}
