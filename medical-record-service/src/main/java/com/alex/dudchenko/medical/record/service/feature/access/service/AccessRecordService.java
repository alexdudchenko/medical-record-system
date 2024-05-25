package com.alex.dudchenko.medical.record.service.feature.access.service;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRecord;

import java.util.List;

public interface AccessRecordService {

    AccessRecord getAccessRecordById(Long id);
    AccessRecord createAccessRecord(AccessRecord accessRecord);
    void deleteAccessRecordById(Long id);
    List<AccessRecord> getAccessRecordsByPatientAndDoctor(Long patientId, Long doctorId);
    List<AccessRecord> getAccessRecordsByPatient(Long patientId);
}
