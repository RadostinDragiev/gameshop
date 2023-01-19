package com.example.gameshop.services;

import com.example.gameshop.dtos.UserLoginDto;
import com.example.gameshop.dtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
