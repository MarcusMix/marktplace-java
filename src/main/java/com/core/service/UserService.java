package com.core.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.dto.UserDTO;
import com.core.entity.User;
import com.core.repository.UserRepository;
import com.core.util.InputValidation;
import com.core.util.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO save(UserDTO userDTO) {

        if (!InputValidation.isNotEmpty(userDTO.getEmail())) {
            throw new IllegalArgumentException("O e-mail não pode estar nulo!");
        }

        if (!InputValidation.isNotEmpty(userDTO.getPassword())) {
            throw new IllegalArgumentException("A senha não pode estar nula!");
        }

        if (!InputValidation.isValidLength(userDTO.getPassword(), 8)) {
            throw new IllegalArgumentException("A senha não pode ter menos que 8 caracteres!");
        }
       
        if (repository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Este e-mail já está cadastrado");
        }

        User user = UserMapper.toUser(userDTO);

        User userSalvo = repository.save(user);

        UserDTO userDTOSalvo = UserMapper.toUserDTO(userSalvo);

        return userDTOSalvo;
    }

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();

        List<UserDTO> usersDTO = users.stream()
        .map(UserMapper::toUserDTO)
        .collect(Collectors.toList());

        if (usersDTO.isEmpty()) {
            throw new NoSuchElementException("Nenhum usuário encontrado.");
        }

        return usersDTO;
    }

}
