package com.alex.dudchenko.medical.record.service.feature.records.service.impl;

import com.alex.dudchenko.medical.record.service.feature.records.model.Referral;
import com.alex.dudchenko.medical.record.service.feature.records.repository.ReferralRepository;
import com.alex.dudchenko.medical.record.service.feature.records.service.ReferralService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReferralServiceImpl implements ReferralService {

    private final ReferralRepository referralRepository;

    @Override
    public Referral saveReferral(Referral referral) {
        referral.setCreationDate(LocalDate.now());
        referral.setUid(UUID.randomUUID().toString());
        return referralRepository.save(referral);
    }

    @Override
    public List<Referral> getReferralsByPatientId(Long patientId) {
        return referralRepository.findAllByMedicalRecordPatientId(patientId);
    }

    @Override
    public void deleteById(Long id) {
        referralRepository.deleteById(id);
    }
}
