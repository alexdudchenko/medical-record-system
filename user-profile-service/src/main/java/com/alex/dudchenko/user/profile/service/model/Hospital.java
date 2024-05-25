package com.alex.dudchenko.user.profile.service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Hospital {

    @Id
    @GeneratedValue(generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
