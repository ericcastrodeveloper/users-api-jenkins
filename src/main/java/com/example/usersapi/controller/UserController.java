package com.example.usersapi.controller;

import com.example.usersapi.dto.UserDTO;
import com.example.usersapi.mapper.UserMapper;
import com.example.usersapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(UserMapper.toDTOList(service.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@RequestParam Long id){
        return ResponseEntity.ok(UserMapper.toDTO(service.getUserById(id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(UserMapper.toDTO(service.saveUser(userDTO)));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser( @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(UserMapper.toDTO(service.updateUser(userDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam Long id){
        service.deleteUser(id);
    }
}
