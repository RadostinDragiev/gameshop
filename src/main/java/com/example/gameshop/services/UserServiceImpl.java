package com.example.gameshop.services;

import com.example.gameshop.entities.User;
import com.example.gameshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        return this.userRepository.findUserByEmailAndPassword(username, password);
    }
}
