package com.alex.dudchenko.access.management.service.repository;

import com.alex.dudchenko.access.management.service.model.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {

}
