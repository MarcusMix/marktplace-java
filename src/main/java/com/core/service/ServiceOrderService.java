package com.core.service;

import com.core.entity.ServiceOrder;
import com.core.dto.ServiceOrderDTO;
import com.core.repository.ServiceOrderRepository;
import com.core.util.ServiceOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceOrderMapper serviceOrderMapper;

    public List<ServiceOrderDTO> getAllServiceOrders() {
        List<ServiceOrder> serviceOrders = serviceOrderRepository.findAll();
        return serviceOrders.stream()
                .map(serviceOrderMapper::toServiceOrderDTO)
                .collect(Collectors.toList());
    }

    public ServiceOrderDTO getServiceOrderById(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));
        return serviceOrderMapper.toServiceOrderDTO(serviceOrder);
    }

    public ServiceOrderDTO createServiceOrder(ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder serviceOrder = serviceOrderMapper.toServiceOrder(serviceOrderDTO);
        serviceOrder = serviceOrderRepository.save(serviceOrder);
        return serviceOrderMapper.toServiceOrderDTO(serviceOrder);
    }

    public ServiceOrderDTO updateServiceOrder(Long id, ServiceOrderDTO serviceOrderDTO) {
        if (!serviceOrderRepository.existsById(id)) {
            throw new RuntimeException("Ordem de serviço não encontrada");
        }
        serviceOrderDTO.setId(id);
        ServiceOrder serviceOrder = serviceOrderMapper.toServiceOrder(serviceOrderDTO);
        serviceOrder = serviceOrderRepository.save(serviceOrder);
        return serviceOrderMapper.toServiceOrderDTO(serviceOrder);
    }

    public void deleteServiceOrder(Long id) {
        serviceOrderRepository.deleteById(id);
    }

    // ... outros métodos, como aceitar a ordem de serviço, finalizar a ordem de
    // serviço, etc.
}