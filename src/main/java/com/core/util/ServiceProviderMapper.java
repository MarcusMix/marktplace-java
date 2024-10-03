package com.core.util;

import com.core.dto.ServiceProviderDTO;
<<<<<<< HEAD
import com.core.entity.Address;
import com.core.entity.ServiceProvider;
import com.core.entity.User;
=======
import com.core.entity.ServiceProvider;
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330

public abstract class ServiceProviderMapper {
    
    public static ServiceProviderDTO toServiceProviderDTO(ServiceProvider serviceProvider) {
<<<<<<< HEAD
        return new ServiceProviderDTO(
            serviceProvider.getName(),
            serviceProvider.getDescription(),
            serviceProvider.getExperience(),
            serviceProvider.getImage(),
            serviceProvider.getId()  // Aqui retorna o ID do usuário
        );
    }

    public static ServiceProvider toServiceProvider(ServiceProviderDTO serviceProviderDTO, User user) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(serviceProviderDTO.getName());
        serviceProvider.setDescription(serviceProviderDTO.getDescription());
        serviceProvider.setExperience(serviceProviderDTO.getExperience());
        serviceProvider.setImage(serviceProviderDTO.getImage());
        
        // Aqui você apenas associa o User sem tentar criar um novo
        serviceProvider.setId(user.getId());
        serviceProvider.setEmail(user.getEmail());
        serviceProvider.setPassword(user.getPassword());
        serviceProvider.setAddress(user.getAddress());

        return serviceProvider;
=======

        return new ServiceProviderDTO(
            // serviceProvider.getId(),
            serviceProvider.getName(),
            serviceProvider.getDescription(),
            serviceProvider.getExperience(),
            serviceProvider.getImage()
        );
    }

    public static ServiceProvider toServiceProvider(ServiceProviderDTO serviceProviderDTO) {
        return new ServiceProvider(
            // serviceProviderDTO.getId(),
            serviceProviderDTO.getName(),
            serviceProviderDTO.getDescription(),
            serviceProviderDTO.getExperience(),
            serviceProviderDTO.getImage()
        );
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330
    }
}
