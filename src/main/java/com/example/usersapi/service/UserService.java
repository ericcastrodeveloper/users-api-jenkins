package com.example.usersapi.service;

import com.example.usersapi.domain.User;
import com.example.usersapi.dto.UserDTO;
import com.example.usersapi.mapper.UserMapper;
import com.example.usersapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.getReferenceById(id);
    }

    public User updateUser(UserDTO userDTO) {
        return repository.save(UserMapper.toEntity(userDTO));
    }

    public User saveUser(UserDTO userDTO) {
        return repository.save(UserMapper.toEntity(userDTO));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
