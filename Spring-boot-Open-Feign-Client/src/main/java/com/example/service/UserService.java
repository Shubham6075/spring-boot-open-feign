package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    User getUserById(Long id);

    User updateUser(Long id ,User user);

    void deleteUser(Long id);
}
