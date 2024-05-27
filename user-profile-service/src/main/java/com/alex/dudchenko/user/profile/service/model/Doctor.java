package com.alex.dudchenko.user.profile.service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Doctor {

    @Id
    @GeneratedValue(generator = "doctor_seq")
    @SequenceGenerator(name = "doctor_seq", sequenceName = "doctor_seq", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private Boolean verified;

    @ManyToMany
    @JoinTable(name="doctor_specialisation",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialisation_id"))
    private Set<Specialisation> specialisations;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorPlaceOfWork> placesOfWork;

    @Formula(value = "LOWER(CONCAT(first_name, ' ', last_name))")
    private String searchableDetails;

}
