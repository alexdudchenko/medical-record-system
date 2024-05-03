package com.alex.dudchenko.access.management.service.repository;

import com.alex.dudchenko.access.management.service.model.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRecordRepository extends JpaRepository<AccessRecord, Long> {
}
