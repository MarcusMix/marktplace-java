package com.core.dto;

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
>>>>>>> ed3520c (feat: save service provider (with error 500))
}
