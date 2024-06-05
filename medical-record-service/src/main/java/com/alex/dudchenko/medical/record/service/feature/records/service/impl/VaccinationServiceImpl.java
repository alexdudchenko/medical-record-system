package com.alex.dudchenko.medical.record.service.feature.records.service.impl;

import com.alex.dudchenko.medical.record.service.feature.records.model.Vaccination;
import com.alex.dudchenko.medical.record.service.feature.records.repository.VaccinationRepository;
import com.alex.dudchenko.medical.record.service.feature.records.service.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VaccinationServiceImpl implements VaccinationService {

    private final VaccinationRepository vaccinationRepository;

    @Override
    public Vaccination save(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }

    @Override
    public void deleteById(Long id) {
        vaccinationRepository.deleteById(id);
    }

    @Override
    public List<Vaccination> findAllByPatientId(Long patientId) {
        return vaccinationRepository.findAllByMedicalRecordPatientId(patientId);
    }
}
