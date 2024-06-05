package com.alex.dudchenko.medical.record.service.feature.access.service;


import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRecord;
import com.alex.dudchenko.medical.record.service.feature.access.model.dto.AccessRecordDto;

import java.util.List;

public interface AccessRecordService {

    AccessRecord getAccessRecordById(Long id);
    AccessRecord createAccessRecord(AccessRecordDto accessRecord);
    void deleteAccessRecordById(Long id);
    List<AccessRecord> getAccessRecordsByPatientAndDoctor(Long patientId, Long doctorId);
    List<AccessRecord> getAccessRecordsByPatient(Long patientId);
}
