package com.devbus.auction.dto;

import com.devbus.auction.entity.Address;

public record UserDTO(String name, String email, AddressDTO address) {}
