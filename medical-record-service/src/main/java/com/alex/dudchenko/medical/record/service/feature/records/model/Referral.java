package com.alex.dudchenko.medical.record.service.feature.records.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Referral {

    @Id
    @GeneratedValue(generator = "referral_seq")
    @SequenceGenerator(name = "referral_seq", sequenceName = "referral_seq", allocationSize = 1)
    private Long id;

    private String uid;

    private Long doctorId;

    private String specialist;

    private LocalDate creationDate;

    private LocalDate expirationDate;

    @ManyToOne
    private MedicalRecord medicalRecord;
}
