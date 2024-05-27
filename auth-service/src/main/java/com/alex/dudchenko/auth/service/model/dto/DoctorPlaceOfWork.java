package com.alex.dudchenko.auth.service.model.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class DoctorPlaceOfWork {

    private Long id;
    private String officeNumber;
    private Boolean isDefault;
    private String position;
    private Hospital hospital;
    private Doctor doctor;
}
