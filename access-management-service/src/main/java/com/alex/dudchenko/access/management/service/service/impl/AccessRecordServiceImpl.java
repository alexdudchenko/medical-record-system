package com.alex.dudchenko.access.management.service.service.impl;

import com.alex.dudchenko.access.management.service.model.AccessRecord;
import com.alex.dudchenko.access.management.service.repository.AccessRecordRepository;
import com.alex.dudchenko.access.management.service.service.AccessRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return accessRecordRepository.save(accessRecord);
    }

    @Override
    public void deleteAccessRecordById(Long id) {
        accessRecordRepository.deleteById(id);
    }
}
