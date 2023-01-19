package com.example.gameshop.services;

import com.example.gameshop.entities.User;

public interface UserService {
    User registerUser(User user);

    User loginUser(String username, String password);
}
