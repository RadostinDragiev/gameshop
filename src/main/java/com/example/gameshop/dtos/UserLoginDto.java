package com.example.gameshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {
    @NotNull
    @Email(message = "Incorrect username / password")
    private String email;

    @Pattern(regexp = "^[A-Za-z1-9]{6,}$", message = "Incorrect username / password")
    @NotNull
    private String password;
}
