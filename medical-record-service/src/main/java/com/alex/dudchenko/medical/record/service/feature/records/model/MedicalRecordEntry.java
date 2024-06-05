package com.alex.dudchenko.medical.record.service.feature.records.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MedicalRecordEntry {

    @Id
    @GeneratedValue(generator = "medical_record_entry_seq")
    @SequenceGenerator(name = "medical_record_entry_seq", sequenceName = "medical_record_entry_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private String diagnosis;
    private String treatmentPlan;
    @ManyToOne
    private MedicalRecord medicalRecord;
}
