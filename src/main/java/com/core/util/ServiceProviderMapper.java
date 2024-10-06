package com.core.util;

import com.core.dto.ServiceProviderDTO;
import com.core.entity.ServiceProvider;     
import com.core.entity.User;

public abstract class ServiceProviderMapper {
    
    public static ServiceProviderDTO toServiceProviderDTO(ServiceProvider serviceProvider) {
        return new ServiceProviderDTO(
            serviceProvider.getName(),
            serviceProvider.getDescription(),
            serviceProvider.getExperience(),
            serviceProvider.getImage(),
            serviceProvider.getId() 
        );
    }

    public static ServiceProvider toServiceProvider(ServiceProviderDTO serviceProviderDTO, User user) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(serviceProviderDTO.getName());
        serviceProvider.setDescription(serviceProviderDTO.getDescription());
        serviceProvider.setExperience(serviceProviderDTO.getExperience());
        serviceProvider.setImage(serviceProviderDTO.getImage());
        
        // Aqui você apenas associa o User sem tentar criar um novo
        serviceProvider.setId(user.getId());  // Não sobrescreva o ID
        serviceProvider.setEmail(user.getEmail());
        serviceProvider.setPassword(user.getPassword());
        serviceProvider.setAddress(user.getAddress());
    
        return serviceProvider;
    }
}