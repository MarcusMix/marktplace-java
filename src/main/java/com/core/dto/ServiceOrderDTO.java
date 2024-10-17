package com.core.dto;

import com.core.entity.ServiceOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrderDTO {

    private Long id;
    private Long userId;
    private Long serviceProviderId;
    private Long offeredServiceId;
    private ServiceOrderStatus status;
    private Integer rating;

    // ... outros atributos que você julgar necessários
}