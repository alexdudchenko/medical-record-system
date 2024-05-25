package com.alex.dudchenko.user.profile.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    private Long id;
    private String country;
    private String city;
    private String streetLine1;
    private String streetLine2;
    private String index;

}
