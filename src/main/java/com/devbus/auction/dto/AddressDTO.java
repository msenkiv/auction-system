package com.devbus.auction.dto;

import java.util.UUID;

public record AddressDTO(
        UUID id,
        String city,
        String street,
        String state,
        String zip,
        String addressNumber,
        String addressComplement
) {
}