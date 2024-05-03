package com.alex.dudchenko.medical.record.service.controller;

import com.alex.dudchenko.medical.record.service.model.MedicalRecord;
import com.alex.dudchenko.medical.record.service.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/records")
@AllArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return new ResponseEntity<>(medicalRecordService.saveMedicalRecord(medicalRecord), HttpStatus.CREATED);
    }
}
