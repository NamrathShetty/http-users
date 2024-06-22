package com.example.http_users.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; // Add this import statement
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserHttpClient userHttpClient;

    // public UserController(UserHttpClient userHttpClient) {
    //     this.userHttpClient = userHttpClient;
    // }

    @GetMapping("")
    public List<User> findAll() {
        return userHttpClient.findAll();
    }
   
    @GetMapping("/{id}")
    public User findById(Integer id) {
        return userHttpClient.findById(id);
    }
}
