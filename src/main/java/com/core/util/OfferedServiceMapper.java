package com.core.util;

import java.util.Base64;

import com.core.dto.OfferedServiceDTO;
import com.core.dto.ServiceProviderDTO;
import com.core.entity.OfferedService;
import com.core.entity.ServiceProvider;
import com.core.repository.ServiceProviderRepository;

public abstract class OfferedServiceMapper {

    public static OfferedServiceDTO toOfferedServiceDTO(OfferedService offeredService) {
        String base64Image = Base64.getEncoder().encodeToString(offeredService.getImage()); // Converter para base64
        return new OfferedServiceDTO(
                offeredService.getId(),
                offeredService.getName(),
                offeredService.getDescription(),
                offeredService.getPrice(),
                offeredService.getServiceProvider().getId(),
                base64Image);
    }

    public static OfferedService toOfferedService(OfferedServiceDTO offeredServiceDTO,
            ServiceProviderDTO serviceProviderDTO,
            ServiceProviderRepository serviceProviderRepository) {
        OfferedService offeredService = new OfferedService();
        offeredService.setId(offeredServiceDTO.getId()); // Definir o ID do OfferedService
        offeredService.setName(offeredServiceDTO.getName());
        offeredService.setDescription(offeredServiceDTO.getDescription());
        offeredService.setPrice(offeredServiceDTO.getPrice());

        // Obter o ServiceProvider existente do banco de dados
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderDTO.getId())
                .orElseThrow(() -> new RuntimeException("ServiceProvider não encontrado"));

        offeredService.setServiceProvider(serviceProvider);

        byte[] imageBytes = Base64.getDecoder().decode(offeredServiceDTO.getImage()); // Converter de base64
        offeredService.setImage(imageBytes); // Definir a imagem no OfferedService
        return offeredService;
    }
}