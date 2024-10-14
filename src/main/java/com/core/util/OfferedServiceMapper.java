package com.core.util;

import com.core.dto.OfferedServiceDTO;
import com.core.dto.ServiceProviderDTO;
import com.core.entity.OfferedService;
import com.core.entity.ServiceProvider;

public abstract class OfferedServiceMapper {

    public static OfferedServiceDTO toOfferedServiceDTO(OfferedService offeredService) {
        return new OfferedServiceDTO(
                offeredService.getId(),
                offeredService.getName(),
                offeredService.getDescription(),
                offeredService.getPrice(),
                offeredService.getServiceProvider().getId());
    }

    public static OfferedService toOfferedService(OfferedServiceDTO offeredServiceDTO,
            ServiceProviderDTO serviceProviderDTO) {
        OfferedService offeredService = new OfferedService();
        offeredService.setName(offeredServiceDTO.getName());
        offeredService.setDescription(offeredServiceDTO.getDescription());
        offeredService.setPrice(offeredServiceDTO.getPrice());

        // Converter ServiceProviderDTO para ServiceProvider
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setId(serviceProviderDTO.getId());
        serviceProvider.setName(serviceProviderDTO.getName());
        serviceProvider.setDescription(serviceProviderDTO.getDescription());
        serviceProvider.setExperience(serviceProviderDTO.getExperience());

        serviceProvider.setImage(serviceProviderDTO.getImage());
        // ... outros atributos do ServiceProvider ...

        offeredService.setServiceProvider(serviceProvider);
        return offeredService;
    }
}