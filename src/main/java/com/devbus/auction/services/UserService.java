package com.devbus.auction.services;

import com.devbus.auction.dto.UserDTO;
import com.devbus.auction.entity.User;
import com.devbus.auction.mapper.UserMapper;
import com.devbus.auction.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> listAllUsers() {
        List<User> users = userRepository.findAll();

        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToDTO).toList();
    }
}
