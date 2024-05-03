package com.alex.dudchenko.access.management.service.model;

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
public class AccessRecord {

    @Id
    @GeneratedValue(generator = "access_record_seq")
    @SequenceGenerator(name = "access_record_seq", sequenceName = "access_record_seq", allocationSize = 1)
    private Long id;
    private LocalDate dateGranted;
    private Long patientId;
    private Long doctorId;

}
