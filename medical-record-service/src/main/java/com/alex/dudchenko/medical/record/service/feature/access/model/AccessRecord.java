package com.alex.dudchenko.medical.record.service.feature.access.model;

import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AccessRecord {

    @Id
    @GeneratedValue(generator = "access_record_seq")
    @SequenceGenerator(name = "access_record_seq", sequenceName = "access_record_seq", allocationSize = 1)
    private Long id;

    private LocalDate dateGranted;

    @ManyToOne
    private MedicalRecord medicalRecord;

    private Long doctorId;
}
