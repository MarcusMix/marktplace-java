package com.core.dto;

import com.core.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private AddressDTO addressDTO;
    private ServiceProviderDTO serviceProviderDTO;
}
