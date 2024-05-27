package com.alex.dudchenko.auth.service.model.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class Specialisation {

    private Long id;
    private String name;
    private Set<Doctor> doctors;
}
