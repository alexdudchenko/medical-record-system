package com.alex.dudchenko.user.profile.service.controller;

import com.alex.dudchenko.user.profile.service.model.Patient;
import com.alex.dudchenko.user.profile.service.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findPatientById(id);
    }

    @GetMapping
    public Patient getPatientByUid(@RequestParam String uid) {
        return patientService.findByUid(uid);
    }

    @GetMapping
    public Patient getPatientByEmail(@RequestParam String email) {
        return patientService.findPatientByEmail(email);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
