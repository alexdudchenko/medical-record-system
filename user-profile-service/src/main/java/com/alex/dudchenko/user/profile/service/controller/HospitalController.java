package com.alex.dudchenko.user.profile.service.controller;

import com.alex.dudchenko.user.profile.service.model.Hospital;
import com.alex.dudchenko.user.profile.service.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    public List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }

    @PutMapping("/{id}")
    public Hospital editHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospitalById(id);
    }
}
