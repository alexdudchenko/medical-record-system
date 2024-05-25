package com.alex.dudchenko.medical.record.service.feature.records.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Prescription {

    @Id
    @GeneratedValue(generator = "prescription_seq")
    @SequenceGenerator(name = "prescription_seq", sequenceName = "prescription_seq", allocationSize = 1)
    private Long id;

    private String uid;

    private String medicine;

    private Integer packages;

    private String dosage;

    private String duration;

    private String frequency;

    private String specialInstructions;

    @ManyToOne
    private MedicalRecord medicalRecord;

}
