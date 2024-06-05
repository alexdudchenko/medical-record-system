package com.alex.dudchenko.medical.record.service.feature.records.controller;

import com.alex.dudchenko.medical.record.service.feature.records.model.Prescription;
import com.alex.dudchenko.medical.record.service.feature.records.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping(params = "patientId")
    public List<Prescription> getAllPrescriptions(@RequestParam("patientId") Long patientId) {
        return prescriptionService.findAllByPatientId(patientId);
    }

    @PostMapping
    public Prescription savePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.save(prescription);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable Long id) {
        prescriptionService.deleteById(id);
    }
}
