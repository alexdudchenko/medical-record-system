package com.alex.dudchenko.user.profile.service.controller;

import com.alex.dudchenko.user.profile.service.model.Specialisation;
import com.alex.dudchenko.user.profile.service.service.SpecialisationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/specialisations")
public class SpecialisationController {

    private final SpecialisationService specialisationService;

    @GetMapping
    public List<Specialisation> getAll() {
        return specialisationService.getAllSpecialisations();
    }

    @PostMapping
    public Specialisation create(@RequestBody Specialisation specialisation) {
        return specialisationService.saveSpecialisation(specialisation);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        specialisationService.deleteSpecialisationById(id);
    }
}
