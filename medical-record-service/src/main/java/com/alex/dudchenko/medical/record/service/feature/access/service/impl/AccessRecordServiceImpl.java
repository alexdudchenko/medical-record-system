package com.alex.dudchenko.medical.record.service.feature.access.service.impl;

import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRecord;
import com.alex.dudchenko.medical.record.service.feature.access.repository.AccessRecordRepository;
import com.alex.dudchenko.medical.record.service.feature.access.service.AccessRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AccessRecordServiceImpl implements AccessRecordService {

    private final AccessRecordRepository accessRecordRepository;

    @Override
    public AccessRecord getAccessRecordById(Long id) {
        return accessRecordRepository.findById(id).orElseThrow();
    }

    @Override
    public AccessRecord createAccessRecord(AccessRecord accessRecord) {
        if (accessRecord.getDateGranted() == null) {
            accessRecord.setDateGranted(LocalDate.now());
        }
        return accessRecordRepository.save(accessRecord);
    }

    @Override
    public void deleteAccessRecordById(Long id) {
        accessRecordRepository.deleteById(id);
    }

    @Override
    public List<AccessRecord> getAccessRecordsByPatientAndDoctor(Long patientId, Long doctorId) {
        return accessRecordRepository.findByMedicalRecordPatientIdAndDoctorId(patientId, doctorId);
    }

    @Override
    public List<AccessRecord> getAccessRecordsByPatient(Long patientId) {
        return accessRecordRepository.findByMedicalRecordPatientId(patientId);
    }
}
