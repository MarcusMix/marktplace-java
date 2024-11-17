package com.core.controller;

import com.core.dto.ServiceOrderDTO;
import com.core.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping("/user/{userId}")
    public List<ServiceOrderDTO> getServiceOrdersByUserId(@PathVariable Long userId) {
        return serviceOrderService.getServiceOrdersByUserId(userId);
    }



    @GetMapping
    public List<ServiceOrderDTO> getAllServiceOrders() {
        return serviceOrderService.getAllServiceOrders();
    }

    @GetMapping("/{id}")
    public ServiceOrderDTO getServiceOrderById(@PathVariable Long id) {
        return serviceOrderService.getServiceOrderById(id);
    }

    @PostMapping
    public ResponseEntity<ServiceOrderDTO> createServiceOrder(@RequestBody ServiceOrderDTO serviceOrderDTO) {
        ServiceOrderDTO createdServiceOrder = serviceOrderService.createServiceOrder(serviceOrderDTO);
        return new ResponseEntity<>(createdServiceOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ServiceOrderDTO updateServiceOrder(@PathVariable Long id, @RequestBody ServiceOrderDTO serviceOrderDTO) {
        return serviceOrderService.updateServiceOrder(id, serviceOrderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceOrder(@PathVariable Long id) {
        serviceOrderService.deleteServiceOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}