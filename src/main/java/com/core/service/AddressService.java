package com.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.dto.AddressDTO;
import com.core.entity.Address;
import com.core.repository.AddressRepository;
import com.core.util.AddressMapper;

@Service
public class AddressService {
    

    @Autowired
    AddressRepository repository;

    public AddressDTO save(AddressDTO addressDTO) {
        Address address = AddressMapper.toAddress(addressDTO);

        Address addressSalvo = repository.save(address);

        AddressDTO addressDTOSalvo = AddressMapper.toAddressDTO(addressSalvo);

        return addressDTOSalvo;
    }
    
}
