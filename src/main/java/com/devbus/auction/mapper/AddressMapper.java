package com.devbus.auction.mapper;

import com.devbus.auction.dto.AddressDTO;
import com.devbus.auction.entity.Address;

public class AddressMapper {

    private AddressMapper() {}

    public static AddressDTO toDto(Address address) {
        if(address == null) {
            return null;
        }

        return  new AddressDTO(address.getId(),
                address.getCity(),
                address.getStreet(),
                address.getState(),
                address.getZip(),
                address.getAddressNumber(),
                address.getAddressComplement()
                );
    }
}
