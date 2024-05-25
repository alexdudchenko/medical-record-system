package com.alex.dudchenko.user.profile.service.repository;

import com.alex.dudchenko.user.profile.service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
