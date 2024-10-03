package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.entity.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
}
