package com.core.util;

import com.core.dto.AddressDTO;
import com.core.dto.ServiceProviderDTO;
import com.core.dto.UserDTO;
import com.core.entity.User;

public abstract class UserMapper {
    
    public static UserDTO toUserDTO(User user) {

        AddressDTO addressDTO = null;
        ServiceProviderDTO serviceProviderDTO = null;

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
            addressDTO,
            serviceProviderDTO
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