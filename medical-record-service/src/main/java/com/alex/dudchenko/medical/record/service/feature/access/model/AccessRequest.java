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
public class AccessRequest {

    @Id
    @GeneratedValue(generator = "access_request_seq")
    @SequenceGenerator(name = "access_request_seq", sequenceName = "access_request_seq", allocationSize = 1)
    private Long id;

    private String status;

    private LocalDate dateRequested;

    @ManyToOne
    private MedicalRecord medicalRecord;

    private Long doctorId;
}
