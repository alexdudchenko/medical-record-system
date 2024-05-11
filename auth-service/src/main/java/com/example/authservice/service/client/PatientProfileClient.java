package com.example.authservice.service.client;

import com.example.authservice.model.dto.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface PatientProfileClient {

    @PostExchange("/patients")
    Patient savePatient(@RequestBody Patient patient);

    @DeleteExchange("/patients/{id}")
    void deletePatient(@PathVariable Long id);

}
