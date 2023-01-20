package com.example.gameshop.services;

import com.example.gameshop.dtos.UserDto;
import com.example.gameshop.dtos.UserLoginDto;
import com.example.gameshop.dtos.UserRegisterDto;
import com.example.gameshop.entities.User;
import com.example.gameshop.enums.Role;
import com.example.gameshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper.map(userRegisterDto, User.class);
        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.BASIC);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        User user = this.userRepository.findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (user == null) {
            System.out.println("Incorrect username / password");
        } else {
            this.userDto = this.modelMapper.map(user, UserDto.class);
            System.out.printf("Successfully logged in %s%n", this.userDto.getFullName());
        }
    }

    @Override
    public void logout() {
        if (this.userDto != null) {
            String name = this.userDto.getFullName();
            this.userDto = null;
            System.out.printf("User %s successfully logged out%n", name);
        } else {
            System.out.println("Cannot log out. No user was logged in.");
        }
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return !this.userDto.getRole().equals(Role.ADMIN);
    }
}
