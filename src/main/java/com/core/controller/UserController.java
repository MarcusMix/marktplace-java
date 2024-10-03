package com.core.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.dto.UserDTO;
import com.core.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        UserDTO userDTOSalvo = UserService.save(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTOSalvo);
    }
<<<<<<< HEAD

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usersDTO = UserService.findAll();
        
        return ResponseEntity.ok(usersDTO);
    }
=======
>>>>>>> 01a340a2634ce3cd5f4f891a18e72efd3c89d330
    
}
