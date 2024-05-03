package com.alex.dudchenko.access.management.service.service.impl;

import com.alex.dudchenko.access.management.service.model.AccessRequest;
import com.alex.dudchenko.access.management.service.repository.AccessRecordRepository;
import com.alex.dudchenko.access.management.service.repository.AccessRequestRepository;
import com.alex.dudchenko.access.management.service.service.AccessRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
