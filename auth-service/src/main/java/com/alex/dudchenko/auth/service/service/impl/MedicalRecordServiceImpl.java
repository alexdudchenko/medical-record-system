package com.alex.dudchenko.auth.service.service.impl;

import com.alex.dudchenko.auth.service.model.dto.MedicalRecordDto;
import com.alex.dudchenko.auth.service.service.MedicalRecordService;
import com.alex.dudchenko.auth.service.service.client.MedicalRecordClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordClient client;

    @Override
    public MedicalRecordDto save(MedicalRecordDto medicalRecordDto) {
        return client.createMedicalRecord(medicalRecordDto);
    }
}
