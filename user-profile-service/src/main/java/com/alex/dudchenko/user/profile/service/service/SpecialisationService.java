package com.alex.dudchenko.user.profile.service.service;

import com.alex.dudchenko.user.profile.service.model.Specialisation;

import java.util.List;

public interface SpecialisationService {

    List<Specialisation> getAllSpecialisations();
    Specialisation saveSpecialisation(Specialisation specialisation);
    void deleteSpecialisationById(Long id);
}
