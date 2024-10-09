package com.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.core.dto.UserDTO;
import com.core.repository.AddressRepository;
import com.core.service.AddressService;
import com.core.util.InputValidation;

public class UserTest {
    public UserTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void verificaUser() {
        UserDTO userPadrao = new UserDTO();
        userPadrao.setEmail("marcus.lindo@gmail.com");
        userPadrao.setPassword("123456789");
        userPadrao.setAddressDTO(null);

        UserDTO userTeste = new UserDTO();
        userTeste.setEmail("teste@gmail");
        userTeste.setPassword("123456789");
        userTeste.setAddressDTO(null);

        // verifica email
        assertTrue(InputValidation.isValidEmail(userPadrao.getEmail()), " O E-mail deve estar no padrão email@email.com");

        // verifica email errado
        assertFalse(InputValidation.isValidEmail(userTeste.getEmail()), "O E-mail deve ser incorreto.");

    }
    
}
