package com.alex.dudchenko.auth.service.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
public class Address {

    private Long id;
    private String country;
    private String city;
    private String streetLine1;
    private String streetLine2;
    private String index;

}
