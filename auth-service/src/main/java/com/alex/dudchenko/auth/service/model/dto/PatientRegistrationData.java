package com.alex.dudchenko.auth.service.model.dto;

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
    private String gender;
    private String personalPhoneNumber;
    private String workPhoneNumber;
    private String company;
    private Address address;
}
