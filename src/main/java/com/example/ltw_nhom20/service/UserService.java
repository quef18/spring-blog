package com.example.ltw_nhom20.service;

import com.example.ltw_nhom20.entity.User;
import com.example.ltw_nhom20.entity.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    User addNewUser(User user);

    Optional<User> findByUsername(String username);

    List<User> getUsers();

    User findById(Integer id);

    User toUser(UserDto userDto);
}
