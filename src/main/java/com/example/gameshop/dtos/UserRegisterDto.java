package com.example.gameshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    @NotNull
    @Email(message = "Incorrect email.")
    private String email;

    @Pattern(regexp = "^[A-Za-z1-9]{6,}$", message = "Password not valid")
    @NotNull
    private String password;

    @NotNull(message = "Full name must not be empty")
    private String fullName;
}
