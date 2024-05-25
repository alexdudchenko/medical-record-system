package com.alex.dudchenko.medical.record.service.feature.records.controller;

import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecord;
import com.alex.dudchenko.medical.record.service.feature.records.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@AllArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return new ResponseEntity<>(medicalRecordService.saveMedicalRecord(medicalRecord), HttpStatus.CREATED);
    }

    @GetMapping(params = "patientId")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(@RequestParam("patientId") Long patientId) {
        return ResponseEntity.ok(List.of(medicalRecordService.findMedicalRecordByPatientId(patientId)));
    }
}
