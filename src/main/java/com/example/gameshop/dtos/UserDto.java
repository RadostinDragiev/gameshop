package com.example.gameshop.dtos;

import com.example.gameshop.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String fullName;
    private String email;
    private String password;
    private Role role;
}
