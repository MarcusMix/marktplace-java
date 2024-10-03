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
<<<<<<< HEAD
    // private ServiceProviderDTO serviceProviderDTO;
=======
    private ServiceProviderDTO serviceProviderDTO;
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330
}
