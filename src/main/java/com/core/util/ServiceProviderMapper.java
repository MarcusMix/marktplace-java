package com.core.util;

import com.core.dto.ServiceProviderDTO;
import com.core.entity.ServiceProvider;

public abstract class ServiceProviderMapper {
    
    public static ServiceProviderDTO toServiceProviderDTO(ServiceProvider serviceProvider) {

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
    }
}
