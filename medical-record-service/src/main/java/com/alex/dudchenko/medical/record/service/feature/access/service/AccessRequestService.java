package com.alex.dudchenko.medical.record.service.feature.access.service;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRequest;
import com.alex.dudchenko.medical.record.service.feature.access.model.dto.AccessRequestDto;

import java.util.List;

public interface AccessRequestService {

    AccessRequest save(AccessRequestDto accessRequest);
    AccessRequest update(AccessRequest accessRequestDto);
    AccessRequest getAccessRequestById(Long id);
    void deleteAccessRequestById(Long id);
    List<AccessRequest> getAccessRequestsByStatusAndPatient(String status, Long patientId);
    List<AccessRequest> getAccessRequestsByStatusAndPatientAndDoctor(String status, Long patientId, Long doctorId);
}
