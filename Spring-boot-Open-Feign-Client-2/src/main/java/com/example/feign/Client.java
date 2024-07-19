package com.example.feign;
import com.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "Spring-boot-Open-Feign-Client",url = "http://localhost:8080")
public interface Client {

    @PostMapping("/api/v1/users/createUser")
    User createUser(@RequestBody User user);

    @GetMapping("/api/v1/users/getAllUsers")
    List<User> getAllUsers();

    @GetMapping("/api/v1/users/getUserById/{id}")
    User getUserById(@PathVariable Long id);

    @PutMapping("/api/v1/users/updateUser/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User userDetails);

    @DeleteMapping("/api/v1/users/deleteUser/{id}")
    void deleteUser(@PathVariable Long id);

}
