package com.alex.dudchenko.medical.record.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(generator = "medical_record_seq")
    @SequenceGenerator(name = "medical_record_seq", sequenceName = "medical_record_seq", allocationSize = 1)
    private Long id;
    private Long patientId;
}
