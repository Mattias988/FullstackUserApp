package com.userproject.fullstackapp.controller;


import com.userproject.fullstackapp.DTO.UserDTO;
import com.userproject.fullstackapp.Service.UserService;
import com.userproject.fullstackapp.model.User;
import com.userproject.fullstackapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //add user controller
    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    //add get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return userService.updateUser(userId, userDTO);
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId){
       return userService.deleteUser(userId);
    }

}
