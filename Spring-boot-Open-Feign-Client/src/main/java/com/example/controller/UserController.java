package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")  // Endpoint URL: http://localhost:8080/api/v1/users/
public class UserController {

    @Autowired
    private UserService userService;

    // api for create users
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }  // Endpoint URL: http://localhost:8080/api/v1/users/createUser

    // api for get all
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }  // Endpoint URL: http://localhost:8080/api/v1/users/getAllUsers

    // api for get user by id
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }  // Endpoint URL: http://localhost:8080/api/v1/users/getUserById/{id}

    // api for update user by id
    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }  // Endpoint URL: http://localhost:8080/api/v1/users/updateUser/{id}

    // api for delete user by id
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        System.out.println("User deleted");
    }  // Endpoint URL: http://localhost:8080/api/v1/users/deleteUser/{id}

}
