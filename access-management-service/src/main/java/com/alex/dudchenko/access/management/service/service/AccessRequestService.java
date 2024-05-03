package com.alex.dudchenko.access.management.service.service;

import com.alex.dudchenko.access.management.service.model.AccessRequest;

public interface AccessRequestService {

    AccessRequest save(AccessRequest accessRequest);
    AccessRequest getAccessRequestById(Long id);
    void deleteAccessRequestById(Long id);
}
