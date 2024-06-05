package com.alex.dudchenko.medical.record.service.feature.access.service.impl;

import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRequest;
import com.alex.dudchenko.medical.record.service.feature.access.model.dto.AccessRequestDto;
import com.alex.dudchenko.medical.record.service.feature.access.repository.AccessRecordRepository;
import com.alex.dudchenko.medical.record.service.feature.access.repository.AccessRequestRepository;
import com.alex.dudchenko.medical.record.service.feature.access.service.AccessRequestService;
import com.alex.dudchenko.medical.record.service.feature.records.model.MedicalRecord;
import com.alex.dudchenko.medical.record.service.feature.records.repository.MedicalRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AccessRequestServiceImpl implements AccessRequestService {

    private final AccessRecordRepository accessRecordRepository;
    private AccessRequestRepository accessRequestRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public AccessRequest save(AccessRequestDto accessRequest) {
        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientId(accessRequest.getPatientId()).orElseThrow();

        AccessRequest newRequest = new AccessRequest();
        newRequest.setDateRequested(LocalDate.now());
        newRequest.setStatus(accessRequest.getStatus());
        newRequest.setDoctorId(accessRequest.getDoctorId());
        newRequest.setMedicalRecord(medicalRecord);

        return accessRequestRepository.save(newRequest);
    }

    @Override
    public AccessRequest update(AccessRequest accessRequest) {
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
