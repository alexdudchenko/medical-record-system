package com.alex.dudchenko.user.profile.service.service.impl;

import com.alex.dudchenko.user.profile.service.model.Specialisation;
import com.alex.dudchenko.user.profile.service.repository.SpecialisationRepository;
import com.alex.dudchenko.user.profile.service.service.SpecialisationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecialisationServiceImpl implements SpecialisationService {

    private final SpecialisationRepository specialisationRepository;


    @Override
    public List<Specialisation> getAllSpecialisations() {
        return specialisationRepository.findAll();
    }

    @Override
    public Specialisation saveSpecialisation(Specialisation specialisation) {
        return specialisationRepository.save(specialisation);
    }

    @Override
    public void deleteSpecialisationById(Long id) {
        specialisationRepository.deleteById(id);
    }
}
