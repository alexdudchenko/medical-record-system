package com.alex.dudchenko.auth.service.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class DoctorRegistrationData {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    private String verified;
    private Set<Specialisation> specialisations;
    private Set<DoctorPlaceOfWork> placesOfWork;
}
