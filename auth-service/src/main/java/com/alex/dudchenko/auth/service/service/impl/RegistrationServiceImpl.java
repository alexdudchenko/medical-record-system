package com.alex.dudchenko.auth.service.service.impl;

import com.alex.dudchenko.auth.service.model.Role;
import com.alex.dudchenko.auth.service.model.UserCredentials;
import com.alex.dudchenko.auth.service.model.dto.*;
import com.alex.dudchenko.auth.service.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final DoctorProfileService doctorProfileService;
    private final PatientProfileService patientProfileService;
    private final UserCredentialsService userCredentialsService;
    private final MedicalRecordService medicalRecordService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerDoctor(DoctorRegistrationData data) {
        Doctor doctorProfile = Doctor.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .email(data.getEmail())
                .verified(data.getVerified())
                .birthDate(data.getBirthDate())
                .specialisations(data.getSpecialisations())
                .placesOfWork(data.getPlacesOfWork())
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

        MedicalRecordDto medicalRecordDto = new MedicalRecordDto();
        medicalRecordDto.setPatientId(savedPatient.getId());
        medicalRecordService.save(medicalRecordDto);

        UserCredentials credentials = UserCredentials.builder()
                .email(data.getEmail())
                .role(Role.PATIENT.name())
                .hashedPassword(passwordEncoder.encode(data.getPassword()))
                .profileId(savedPatient.getId())
                .build();
        userCredentialsService.saveUserCredentials(credentials);
    }
}
