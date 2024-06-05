package com.alex.dudchenko.medical.record.service.feature.records.controller;

import com.alex.dudchenko.medical.record.service.feature.records.model.Vaccination;
import com.alex.dudchenko.medical.record.service.feature.records.service.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vaccinations")
public class VaccinationController {

    private final VaccinationService vaccinationService;

    @GetMapping(params = "patientId")
    public List<Vaccination> getVaccinations(@RequestParam("patientId") Long patientId) {
        return vaccinationService.findAllByPatientId(patientId);
    }

    @PostMapping
    public Vaccination createVaccination(@RequestBody Vaccination vaccination) {
        return vaccinationService.save(vaccination);
    }

    @DeleteMapping("/{id}")
    public void deleteVaccination(@PathVariable Long id) {
        vaccinationService.deleteById(id);
    }
}
