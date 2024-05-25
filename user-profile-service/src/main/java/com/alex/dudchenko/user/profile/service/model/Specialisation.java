package com.alex.dudchenko.user.profile.service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Specialisation {

    @Id
    @GeneratedValue(generator = "specialisation_seq")
    @SequenceGenerator(name = "specialisation_seq", sequenceName = "specialisation_seq", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "specialisations")
    private Set<Doctor> doctors;
}
