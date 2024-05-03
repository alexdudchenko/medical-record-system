package com.alex.dudchenko.medical.record.service.model;

import lombok.AllArgsConstructor;

import java.io.File;

@AllArgsConstructor
public class MedicalRecordEntryDto {

    private final MedicalRecordEntry medicalRecordEntry;
    private final File file;
}
