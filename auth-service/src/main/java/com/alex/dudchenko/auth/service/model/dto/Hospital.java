package com.alex.dudchenko.auth.service.model.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Hospital {

    private Long id;
    private String name;
    private Address address;
}
