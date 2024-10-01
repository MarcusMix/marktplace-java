package com.core.util;

import com.core.dto.AddressDTO;
import com.core.entity.Address;

public abstract class AddressMapper {
    
    public static AddressDTO toAddressDTO(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Endereço não pode ser nulo!");
        }

        AddressDTO addressDTO = new AddressDTO(
            address.getId(),
            address.getCity(),
            address.getNumber(),
            address.getNeighborhood(),
            address.getState(),
            address.getStreet()
        );

        return addressDTO;

    }

    public static Address toAddress(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new IllegalArgumentException("AddressDTO não pode ser null");
        }

        return new Address(
            addressDTO.getId(),
            addressDTO.getCity(),
            addressDTO.getNumber(),
            addressDTO.getNeighborhood(),
            addressDTO.getState(),
            addressDTO.getStreet()
        );
    }


}
