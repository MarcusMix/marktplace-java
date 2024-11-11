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
                address.getStreet(),
                address.getNumber(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState());

        return addressDTO;

    }

    public static Address toAddress(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new IllegalArgumentException("AddressDTO não pode ser null");
        }

        return new Address(
                addressDTO.getId(),
                addressDTO.getStreet(),
                addressDTO.getNumber(),
                addressDTO.getNeighborhood(),
                addressDTO.getCity(),
                addressDTO.getState());
    }

}
