package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    
} 
