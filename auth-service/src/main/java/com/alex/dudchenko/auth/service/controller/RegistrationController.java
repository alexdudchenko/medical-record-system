package com.alex.dudchenko.auth.service.controller;

import com.alex.dudchenko.auth.service.model.dto.DoctorRegistrationData;
import com.alex.dudchenko.auth.service.model.dto.PatientRegistrationData;
import com.alex.dudchenko.auth.service.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/doctors/registration")
    public ResponseEntity<String> registerDoctor(@RequestBody DoctorRegistrationData data) {
        registrationService.registerDoctor(data);
        return ResponseEntity.ok("Doctor registered successfully");
    }

    @PostMapping("/patients/registration")
    public ResponseEntity<String> registerPatient(@RequestBody PatientRegistrationData data) {
        registrationService.registerPatient(data);
        return ResponseEntity.ok("Patient registered successfully");
    }
}
