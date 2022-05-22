package com.example.usersapi.mapper;

import com.example.usersapi.domain.User;
import com.example.usersapi.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<UserDTO> toDTOList(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> {
        userDTOList.add(toDTO(user));
        });
        return userDTOList;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setCpf(user.getCpf());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setCpf(user.getCpf());
        return user;
    }
}
