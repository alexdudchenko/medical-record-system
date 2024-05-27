package com.alex.dudchenko.auth.service.model.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class Doctor {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String verified;

    private Set<Specialisation> specialisations;
    private Set<DoctorPlaceOfWork> placesOfWork;

    private String searchableDetails;

}
