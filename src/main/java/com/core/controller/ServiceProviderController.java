package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ServiceProviderDTO> save(@RequestBody ServiceProviderDTO serviceProviderDTO) {
        ServiceProviderDTO serviceProviderDTOSalvo = service.save(serviceProviderDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProviderDTOSalvo);
    }
}