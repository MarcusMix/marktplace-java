package com.core.util;

import com.core.dto.UserDTO;
import com.core.entity.User;

public abstract class UserMapper {
    
    public static UserDTO toUserDTO(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo!");
        }

        UserDTO userDTO = new UserDTO(
            user.getId();
            user.getEmail(),
            user.getPassword(),
            //user.getAddress(),
            //user.getServiceProvider()
        )

        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo!");
        }

        return new User(
            userDTO.getId(),
            userDTO.getEmail(),
            userDTO.getPassword()
        );
    }
}
