package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.dto.ServiceProviderDTO;
import com.core.entity.ServiceProvider;
import com.core.entity.User;
import com.core.repository.ServiceProviderRepository;
import com.core.repository.UserRepository;
import com.core.util.ServiceProviderMapper;

@Service
public class ServiceProviderService {
    
    @Autowired
    private ServiceProviderRepository repository;

    @Autowired
    private UserRepository userRepository;

    public ServiceProviderDTO save(ServiceProviderDTO serviceProviderDTO) {

        User user = userRepository.findById(serviceProviderDTO.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));

        ServiceProvider serviceProvider = ServiceProviderMapper.toServiceProvider(serviceProviderDTO, user);

        ServiceProvider serviceProviderSalvo = repository.save(serviceProvider);

        return ServiceProviderMapper.toServiceProviderDTO(serviceProviderSalvo);
    }
}
