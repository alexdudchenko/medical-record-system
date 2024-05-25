package com.alex.dudchenko.medical.record.service.feature.records.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Vaccination {

    @Id
    @GeneratedValue(generator = "vaccination_seq")
    @SequenceGenerator(name = "vaccination_seq", sequenceName = "vaccination_seq", allocationSize = 1)
    private Long id;

    private String vaccine;

    private Integer doseNumber;

    private String manufacturer;

    private String serialNumber;

    private LocalDate vaccinatedDate;

    private LocalDate expiryDate;

    private String dosage;

    private String injectionSite;

    private Long authorId;

    @ManyToOne
    private MedicalRecord medicalRecord;
}
