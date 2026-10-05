package com.devbus.auction.controller;

import com.devbus.auction.dto.UserDTO;
import com.devbus.auction.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void CreateUser(){
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
