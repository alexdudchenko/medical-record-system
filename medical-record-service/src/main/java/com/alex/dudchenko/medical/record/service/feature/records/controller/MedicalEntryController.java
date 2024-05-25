package com.alex.dudchenko.medical.record.service.feature.records.controller;

import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecordEntry;
import com.alex.dudchenko.medical.record.service.feature.records.service.MedicalRecordEntryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
@AllArgsConstructor
public class MedicalEntryController {

    private final MedicalRecordEntryService medicalRecordEntryService;

    @GetMapping(params = "medicalRecordId")
    public ResponseEntity<List<MedicalRecordEntry>> getMedicalRecordEntries(@RequestParam Long medicalRecordId) {
        return ResponseEntity.ok(medicalRecordEntryService.findMedicalRecordEntryByMedicalRecordId(medicalRecordId));
    }

    @GetMapping(params = "patientId")
    public ResponseEntity<List<MedicalRecordEntry>> getMedicalRecordEntriesByPatientId(@RequestParam Long patientId) {
        return ResponseEntity.ok(medicalRecordEntryService.findMedicalRecordEntriesByPatientId(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordEntry> getMedicalRecordEntry(@PathVariable Long id) {
        return ResponseEntity.ok(medicalRecordEntryService.findMedicalRecordEntryById(id));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordEntry> saveMedicalRecordEntry(@RequestBody MedicalRecordEntry medicalRecordEntry) {
        MedicalRecordEntry entry = medicalRecordEntryService.createMedicalRecordEntry(medicalRecordEntry);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entry);
    }
}