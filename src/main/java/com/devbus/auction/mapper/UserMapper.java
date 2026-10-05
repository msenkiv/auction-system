package com.devbus.auction.mapper;

import com.devbus.auction.dto.UserDTO;
import com.devbus.auction.entity.User;

public final class UserMapper {
    private UserMapper(){}

    public static UserDTO mapToDTO(User user){
        return new UserDTO(user.getName(), user.getEmail(), AddressMapper.toDto(user.getAddress()));
    }
}
