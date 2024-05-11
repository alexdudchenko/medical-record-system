package com.example.authservice.controller;

import com.example.authservice.model.dto.DoctorRegistrationData;
import com.example.authservice.model.dto.PatientRegistrationData;
import com.example.authservice.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/doctors")
    public ResponseEntity<String> registerDoctor(@RequestBody DoctorRegistrationData data) {
        registrationService.registerDoctor(data);
        return ResponseEntity.ok("Doctor registered successfully");
    }

    @PostMapping("/patients")
    public ResponseEntity<String> registerPatient(@RequestBody PatientRegistrationData data) {
        registrationService.registerPatient(data);
        return ResponseEntity.ok("Patient registered successfully");
    }
}
