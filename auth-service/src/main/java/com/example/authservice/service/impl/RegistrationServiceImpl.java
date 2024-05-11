package com.example.authservice.service.impl;

import com.example.authservice.model.Role;
import com.example.authservice.model.UserCredentials;
import com.example.authservice.model.dto.Doctor;
import com.example.authservice.model.dto.DoctorRegistrationData;
import com.example.authservice.model.dto.Patient;
import com.example.authservice.model.dto.PatientRegistrationData;
import com.example.authservice.service.DoctorProfileService;
import com.example.authservice.service.PatientProfileService;
import com.example.authservice.service.RegistrationService;
import com.example.authservice.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final DoctorProfileService doctorProfileService;
    private final PatientProfileService patientProfileService;
    private final UserCredentialsService userCredentialsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerDoctor(DoctorRegistrationData data) {
        Doctor doctorProfile = Doctor.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .email(data.getEmail())
                .verified(data.getVerified())
                .birthDate(data.getBirthDate())
                .build();

        Doctor savedDoctor = doctorProfileService.saveDoctor(doctorProfile);

        UserCredentials credentials = UserCredentials.builder()
                .email(data.getEmail())
                .role(Role.DOCTOR.name())
                .hashedPassword(passwordEncoder.encode(data.getPassword()))
                .profileId(savedDoctor.getId())
                .build();

        userCredentialsService.saveUserCredentials(credentials);
    }

    @Override
    public void registerPatient(PatientRegistrationData data) {
        Patient patientProfile = Patient.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .email(data.getEmail())
                .birthDate(data.getBirthDate())
                .build();

        Patient savedPatient = patientProfileService.savePatient(patientProfile);

        UserCredentials credentials = UserCredentials.builder()
                .email(data.getEmail())
                .role(Role.PATIENT.name())
                .hashedPassword(passwordEncoder.encode(data.getPassword()))
                .profileId(savedPatient.getId())
                .build();

        userCredentialsService.saveUserCredentials(credentials);
    }
}
