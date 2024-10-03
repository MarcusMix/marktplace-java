package com.core.util;

import com.core.dto.AddressDTO;
import com.core.dto.ServiceProviderDTO;
import com.core.dto.UserDTO;
import com.core.entity.User;

public abstract class UserMapper {
    
    public static UserDTO toUserDTO(User user) {

        AddressDTO addressDTO = null;
<<<<<<< HEAD
        // ServiceProviderDTO serviceProviderDTO = null;
=======
        ServiceProviderDTO serviceProviderDTO = null;
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330

        if(user.getAddress() != null) {
            addressDTO = AddressMapper.toAddressDTO(user.getAddress());
        }

        // if(user.getServiceProvider() != null) {
        //     serviceProviderDTO = ServiceProviderMapper.toServiceProviderDTO(user.getServiceProvider());
        // }

        return new UserDTO(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
<<<<<<< HEAD
            addressDTO
            // serviceProviderDTO
=======
            addressDTO,
            serviceProviderDTO
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330
        );
    }

    public static User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo!");
        }

        return new User(
            userDTO.getId(),
            userDTO.getEmail(),
            userDTO.getPassword(),
            AddressMapper.toAddress(userDTO.getAddressDTO())
            // ServiceProviderMapper.toServiceProvider(userDTO.getServiceProviderDTO())
        );
    }
}
