package com.alex.dudchenko.auth.service.service.client;

import com.alex.dudchenko.auth.service.model.dto.Doctor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface DoctorProfileClient {

    @PostExchange("/doctors")
    Doctor saveDoctor(@RequestBody Doctor doctor);

    @DeleteExchange("/doctors/{id}")
    void deleteDoctor(@PathVariable Long id);

}
