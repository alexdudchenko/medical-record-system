package com.alex.dudchenko.medical.record.service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FileAttachment {

    @Id
    @GeneratedValue(generator = "file_attachment_seq")
    @SequenceGenerator(name = "file_attachment_seq", sequenceName = "file_attachment_seq", allocationSize = 1)
    private Long id;
    private String filePath;
    private String fileName;
    @ManyToOne
    private MedicalRecordEntry medicalRecordEntry;
}
