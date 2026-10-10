package com.devbus.auction.controller;

import com.devbus.auction.dto.UserDTO;
import com.devbus.auction.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDTO> CreateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService
                        .createUser(userDTO));
    }

    @GetMapping("/list")
    public List<UserDTO> ListUser(){
        return this.userService.listAllUsers();
    }

    public void UpdateUser(){
    }

    public void DeleteUser(){
    }

}
