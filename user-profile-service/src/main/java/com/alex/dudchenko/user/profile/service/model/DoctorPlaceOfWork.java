package com.alex.dudchenko.user.profile.service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DoctorPlaceOfWork {

    @Id
    @GeneratedValue(generator = "doctor_place_of_work_seq")
    @SequenceGenerator(name = "doctor_place_of_work_seq", sequenceName = "doctor_place_of_work_seq", allocationSize = 1)
    private Long id;

    private String officeNumber;

    private String position;

    @ManyToOne
    private Hospital hospital;

    @ManyToOne
    private Doctor doctor;
}
