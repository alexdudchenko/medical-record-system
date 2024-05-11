package com.example.authservice.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRegistrationData {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String uid;
    private String birthDate;
}
