package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.dto.UserDTO;
import com.core.entity.User;
import com.core.repository.UserRepository;
import com.core.util.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO save(UserDTO userDTO) {
        User user = UserMapper.toUser(userDTO);

        User userSalvo = repository.save(user);

        UserDTO userDTOSalvo = UserMapper.toUserDTO(userSalvo);

        return userDTOSalvo;
    }
    
}
