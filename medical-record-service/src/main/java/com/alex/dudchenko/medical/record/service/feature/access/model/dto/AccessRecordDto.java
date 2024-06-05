package com.alex.dudchenko.medical.record.service.feature.access.model.dto;

import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AccessRecordDto {

    private Long id;

    private Long patientId;

    private Long doctorId;
}
