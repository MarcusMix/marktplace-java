package com.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderDTO {
    private Long id;
    private String name;
    private String description;
    private String experience;
    private String image;
    private Long userId;
}
