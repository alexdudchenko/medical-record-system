package com.alex.dudchenko.medical.record.service.feature.records.service;

import com.alex.dudchenko.medical.record.service.feature.records.model.Referral;

import java.util.List;

public interface ReferralService {

    Referral saveReferral(Referral referral);
    List<Referral> getReferralsByPatientId(Long patientId);
    void deleteById(Long id);
}
