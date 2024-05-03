package com.alex.dudchenko.access.management.service.service;

import com.alex.dudchenko.access.management.service.model.AccessRecord;

public interface AccessRecordService {

    AccessRecord getAccessRecordById(Long id);
    AccessRecord createAccessRecord(AccessRecord accessRecord);
    void deleteAccessRecordById(Long id);
}
