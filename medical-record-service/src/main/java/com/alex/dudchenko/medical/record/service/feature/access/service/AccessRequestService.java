package com.alex.dudchenko.medical.record.service.feature.access.service;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRequest;

import java.util.List;

public interface AccessRequestService {

    AccessRequest save(AccessRequest accessRequest);
    AccessRequest getAccessRequestById(Long id);
    void deleteAccessRequestById(Long id);
    List<AccessRequest> getAccessRequestsByStatusAndPatient(String status, Long patientId);
    List<AccessRequest> getAccessRequestsByStatusAndPatientAndDoctor(String status, Long patientId, Long doctorId);
}
