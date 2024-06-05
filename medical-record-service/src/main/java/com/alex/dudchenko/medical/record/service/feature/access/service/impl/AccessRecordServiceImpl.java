package com.alex.dudchenko.medical.record.service.feature.access.service.impl;

import com.alex.dudchenko.medical.record.service.feature.access.model.AccessRecord;
import com.alex.dudchenko.medical.record.service.feature.access.model.dto.AccessRecordDto;
import com.alex.dudchenko.medical.record.service.feature.access.repository.AccessRecordRepository;
import com.alex.dudchenko.medical.record.service.feature.access.service.AccessRecordService;
import com.alex.dudchenko.medical.record.service.feature.records.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AccessRecordServiceImpl implements AccessRecordService {

    private final AccessRecordRepository accessRecordRepository;
    private final MedicalRecordService medicalRecordService;

    @Override
    public AccessRecord getAccessRecordById(Long id) {
        return accessRecordRepository.findById(id).orElseThrow();
    }

    @Override
    public AccessRecord createAccessRecord(AccessRecordDto accessRecordDto) {
        AccessRecord accessRecord = new AccessRecord();

        accessRecord.setDoctorId(accessRecordDto.getDoctorId());
        accessRecord.setDateGranted(LocalDate.now());
        accessRecord.setMedicalRecord(medicalRecordService.findMedicalRecordByPatientId(accessRecordDto.getPatientId()));

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
