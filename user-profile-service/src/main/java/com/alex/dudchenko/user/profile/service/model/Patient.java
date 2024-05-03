package com.alex.dudchenko.user.profile.service.model;

import com.alex.dudchenko.user.profile.service.config.AesEncryptor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String uid;

    @Convert(converter = AesEncryptor.class)
    private LocalDate birthDate;
}
