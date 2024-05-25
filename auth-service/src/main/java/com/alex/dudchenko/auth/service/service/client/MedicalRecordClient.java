package com.alex.dudchenko.auth.service.service.client;

import com.alex.dudchenko.auth.service.model.dto.MedicalRecordDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface MedicalRecordClient {

    @PostExchange("/records")
    MedicalRecordDto createMedicalRecord(@RequestBody MedicalRecordDto medicalRecord);
}
