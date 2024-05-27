package com.alex.dudchenko.user.profile.service.controller;

import com.alex.dudchenko.user.profile.service.model.Doctor;
import com.alex.dudchenko.user.profile.service.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @GetMapping(params = "verified")
    public List<Doctor> getUnverifiedDoctors() {
        return doctorService.findUnverifiedDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.findDoctorById(id);
    }

    @GetMapping(params = "email")
    public List<Doctor> getDoctorByEmail(@RequestParam String email) {
        return doctorService.findDoctorByEmail(email);
    }

    @GetMapping(params = "pattern")
    public List<Doctor> getDoctorsByPattern(@RequestParam String pattern) {
        return doctorService.findDoctorsByPattern(pattern);
    }

    @GetMapping(params = "ids")
    public List<Doctor> getDoctorsByIds(@RequestParam String ids) {
        List<Long> idsList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();

        return doctorService.findDoctorsByIds(idsList);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
