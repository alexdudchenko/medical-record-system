package com.alex.dudchenko.user.profile.service.model;

import com.alex.dudchenko.user.profile.service.config.AesEncryptor;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;

@Data
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

    private String gender;

    private String personalPhoneNumber;

    private String workPhoneNumber;

    private String company;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Formula(value = "LOWER(CONCAT(first_name, ' ', last_name, ' ', uid))")
    private String searchableDetails;
}
