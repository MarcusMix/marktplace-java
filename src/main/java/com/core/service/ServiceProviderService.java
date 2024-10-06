package com.core.service;

import java.util.Optional;

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
        // Buscar o User já existente pelo ID
        User existingUser = userRepository.findById(serviceProviderDTO.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
    
        // Criar o ServiceProvider e configurar os campos herdados do User
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setId(existingUser.getId());  // Reutilizando o ID do usuário existente
        serviceProvider.setEmail(existingUser.getEmail());
        serviceProvider.setPassword(existingUser.getPassword());
        serviceProvider.setAddress(existingUser.getAddress());
    
        // Adicionar os campos específicos do ServiceProvider
        serviceProvider.setName(serviceProviderDTO.getName());
        serviceProvider.setDescription(serviceProviderDTO.getDescription());
        serviceProvider.setExperience(serviceProviderDTO.getExperience());
        serviceProvider.setImage(serviceProviderDTO.getImage());
    
        // Salvar o ServiceProvider
        ServiceProvider savedServiceProvider = repository.save(serviceProvider);
    
        return ServiceProviderMapper.toServiceProviderDTO(savedServiceProvider);
    }
    
      
}