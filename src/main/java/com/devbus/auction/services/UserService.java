package com.devbus.auction.services;

import com.devbus.auction.dto.UserDTO;
import com.devbus.auction.entity.User;
import com.devbus.auction.mapper.UserMapper;
import com.devbus.auction.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findEntityById(UUID id) {
        return userRepository.findById(id);
    }

    public List<UserDTO> listAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToDTO).toList();
    }

    public UserDTO createUser(UserDTO userDTO){
        User user = UserMapper.mapToEntity(userDTO);
        User savedUser = this.userRepository.save(user);
        return UserMapper.mapToDTO(savedUser);
    }

    public Optional<UserDTO> getUserById(UUID id){
        return userRepository.findById(id).map(UserMapper::mapToDTO);
    }
}
