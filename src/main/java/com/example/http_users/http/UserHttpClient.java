package com.example.http_users.http;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

/**
 * UserHttpClient
 */
public interface UserHttpClient { 

   @GetExchange("/users")
    List<User> findAll();
    
    @GetExchange("/users/{id}")
    User findById(@PathVariable Integer id);
}