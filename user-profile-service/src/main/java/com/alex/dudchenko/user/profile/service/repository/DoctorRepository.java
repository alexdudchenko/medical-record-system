package com.alex.dudchenko.user.profile.service.repository;

import com.alex.dudchenko.user.profile.service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByEmail(String email);
    List<Doctor> findDoctorByVerified(Boolean isVerified);
    List<Doctor> findDoctorsBySearchableDetailsContains(String pattern);
}
