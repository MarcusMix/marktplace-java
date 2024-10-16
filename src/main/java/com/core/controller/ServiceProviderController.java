package com.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.dto.ServiceProviderDTO;
import com.core.service.ServiceProviderService;

@RestController
@RequestMapping("/service-provider")
public class ServiceProviderController {
    

    @Autowired
    private ServiceProviderService service;

    @PostMapping
    public ResponseEntity<ServiceProviderDTO> saveServiceProvider(@RequestBody ServiceProviderDTO serviceProviderDTO) {
        // Chama o serviço para salvar o ServiceProvider
        ServiceProviderDTO savedServiceProvider = service.saveServiceProvider(serviceProviderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServiceProvider);
    }

    // Endpoint para buscar um ServiceProvider pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> getServiceProviderById(@PathVariable Long id) {
        ServiceProviderDTO serviceProvider = service.getServiceProviderById(id);
        return ResponseEntity.ok(serviceProvider);
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderDTO>> getAllServiceProviders() {
        List<ServiceProviderDTO> serviceProviders = service.getAllServiceProviders();
        return ResponseEntity.ok(serviceProviders);
    }
}