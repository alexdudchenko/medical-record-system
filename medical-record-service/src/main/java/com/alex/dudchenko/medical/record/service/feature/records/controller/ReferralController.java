package com.alex.dudchenko.medical.record.service.feature.records.controller;

import com.alex.dudchenko.medical.record.service.feature.records.model.Referral;
import com.alex.dudchenko.medical.record.service.feature.records.service.ReferralService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/referrals")
public class ReferralController {

    private final ReferralService referralService;

    @GetMapping(params = "patientId")
    public List<Referral> getReferrals(@RequestParam Long patientId) {
        return referralService.getReferralsByPatientId(patientId);
    }

    @PostMapping
    public Referral saveReferral(@RequestBody Referral referral) {
        return referralService.saveReferral(referral);
    }

    @DeleteMapping("/{id}")
    public void deleteReferral(@PathVariable Long id) {
        referralService.deleteById(id);
    }
}
