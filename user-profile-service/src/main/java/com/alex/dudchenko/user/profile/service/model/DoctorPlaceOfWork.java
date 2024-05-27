package com.alex.dudchenko.user.profile.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Boolean isDefault;

    @ManyToOne
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Doctor doctor;
}
