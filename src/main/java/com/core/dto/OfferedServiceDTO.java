package com.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferedServiceDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long serviceProviderId;
    private String image;
}