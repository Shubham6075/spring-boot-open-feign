package com.example.controller;

import com.example.entity.User;
import com.example.feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")  // Endpoint URL http://localhost:9090/api/v1/client
public class ClientController {

    @Autowired
    private Client client;

    @PostMapping("/createUser") // Endpoint URL : http://localhost:9090/api/v1/client/createUser
    public User createUser(@RequestBody User user) {
        return client.createUser(user);
    }

    @GetMapping("/getAllUsers") // Endpoint URL : http://localhost:9090/api/v1/client/getAllUsers
    public List<User> getAllUsers() {
        return client.getAllUsers();
    }

    @GetMapping("/getUserById/{id}") // Endpoint URL : http://localhost:9090/api/v1/client/getUserById/{id}
    public User getUserById(@PathVariable Long id) {
        return client.getUserById(id);
    }

    @PutMapping("/updateUser/{id}") // Endpoint URL : http://localhost:9090/api/v1/client/updateUser/{id}
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return client.updateUser(id, userDetails);
    }

    @DeleteMapping("/deleteUser/{id}") // Endpoint URL : http://localhost:9090/api/v1/client/deleteUser/{id}
    public void deleteUser(@PathVariable Long id) {
        client.deleteUser(id);
        System.out.println("User deleted via Feign client");
    }
}
