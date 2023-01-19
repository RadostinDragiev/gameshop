package com.example.gameshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    @NotNull
    @Email(message = "Incorrect email.")
    private String email;

    @Size(min = 6, message = "Pass length not valid")
    @Pattern(regexp = "[A-Za-z1-9]", message = "Password not valid")
    @NotNull
    private String password;

    @NotNull(message = "Full name must not be empty")
    private String fullName;
}
