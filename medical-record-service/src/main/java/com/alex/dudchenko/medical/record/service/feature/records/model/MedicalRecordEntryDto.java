package com.alex.dudchenko.medical.record.service.feature.records.model;

import lombok.AllArgsConstructor;

import java.io.File;

@AllArgsConstructor
public class MedicalRecordEntryDto {

    private final MedicalRecordEntry medicalRecordEntry;
    private final File file;
}
