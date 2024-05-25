package com.alex.dudchenko.medical.record.service.feature.access.service.impl;

import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRequest;
import com.alex.dudchenko.medical.record.service.feature.access.repository.AccessRecordRepository;
import com.alex.dudchenko.medical.record.service.feature.access.repository.AccessRequestRepository;
import com.alex.dudchenko.medical.record.service.feature.access.service.AccessRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccessRequestServiceImpl implements AccessRequestService {

    private final AccessRecordRepository accessRecordRepository;
    private AccessRequestRepository accessRequestRepository;

    @Override
    public AccessRequest save(AccessRequest accessRequest) {
        return accessRequestRepository.save(accessRequest);
    }

    @Override
    public AccessRequest getAccessRequestById(Long id) {
        return accessRequestRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteAccessRequestById(Long id) {
        accessRecordRepository.deleteById(id);
    }

    @Override
    public List<AccessRequest> getAccessRequestsByStatusAndPatient(String status, Long patientId) {
        return accessRequestRepository.findAccessRequestByStatusAndMedicalRecordPatientId(status, patientId);
    }

    @Override
    public List<AccessRequest> getAccessRequestsByStatusAndPatientAndDoctor(String status, Long patientId, Long doctorId) {
        return accessRequestRepository.findAccessRequestByStatusAndMedicalRecordPatientIdAndDoctorId(status, patientId, doctorId);
    }
}
