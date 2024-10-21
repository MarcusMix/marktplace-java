package com.core.service;

import com.core.dto.OfferedServiceDTO;
import com.core.dto.ServiceProviderDTO;
import com.core.entity.OfferedService;
import com.core.repository.OfferedServiceRepository;
import com.core.repository.ServiceProviderRepository;
import com.core.util.OfferedServiceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferedServiceService {

    @Autowired
    private OfferedServiceRepository offeredServiceRepository;

    @Autowired
    private ServiceProviderService serviceProviderService;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public List<OfferedServiceDTO> findAll() {
        return offeredServiceRepository.findAll().stream()
                .map(OfferedServiceMapper::toOfferedServiceDTO)
                .collect(Collectors.toList());
    }

    public OfferedServiceDTO findById(Long id) {
        return offeredServiceRepository.findById(id)
                .map(OfferedServiceMapper::toOfferedServiceDTO)
                .orElse(null);
    }

    public OfferedServiceDTO create(OfferedServiceDTO offeredServiceDTO) {
        ServiceProviderDTO serviceProviderDTO = serviceProviderService
                .getServiceProviderById(offeredServiceDTO.getServiceProviderId());
        if (serviceProviderDTO == null) {
            return null; // Ou lançar uma exceção
        }

        OfferedService offeredService = OfferedServiceMapper.toOfferedService(
                offeredServiceDTO, serviceProviderDTO, serviceProviderRepository); // Passar o repositório

        return OfferedServiceMapper.toOfferedServiceDTO(offeredServiceRepository.save(offeredService));
    }

    public OfferedServiceDTO update(Long id, OfferedServiceDTO offeredServiceDTO) {
        if (!offeredServiceRepository.existsById(id)) {
            return null; // Ou lançar uma exceção
        }
        ServiceProviderDTO serviceProviderDTO = serviceProviderService
                .getServiceProviderById(offeredServiceDTO.getServiceProviderId());
        if (serviceProviderDTO == null) {
            return null; // Ou lançar uma exceção
        }
        offeredServiceDTO.setId(id);
        OfferedService offeredService = OfferedServiceMapper.toOfferedService(
                offeredServiceDTO, serviceProviderDTO, serviceProviderRepository); // Passar o repositório

        return OfferedServiceMapper.toOfferedServiceDTO(offeredServiceRepository.save(offeredService));
    }

    public void delete(Long id) {
        offeredServiceRepository.deleteById(id);
    }
}