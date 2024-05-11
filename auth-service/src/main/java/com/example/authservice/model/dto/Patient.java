package com.example.authservice.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Patient {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String uid;
    private String birthDate;
    private String searchableDetails;
}
