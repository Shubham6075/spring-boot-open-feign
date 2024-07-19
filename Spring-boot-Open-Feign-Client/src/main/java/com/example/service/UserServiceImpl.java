package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id ,User user) {
        return userRepository.findById(user.getId())
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setAddress(user.getAddress());
                    existingUser.setMobileNumber(user.getMobileNumber());
                    // Add other fields if necessary
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new IllegalArgumentException("User with id " + user.getId() + " not found"));

    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            // Delete the user by ID
            userRepository.deleteById(id);
        } else {
            // Handle the case where the user is not found
            // You can throw an exception or log a message depending on your design
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
    }
}
