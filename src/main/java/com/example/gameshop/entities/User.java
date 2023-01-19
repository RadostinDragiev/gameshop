package com.example.gameshop.entities;

import com.example.gameshop.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @NotNull
    @Column(unique = true)
    private String email;

    @Size(min = 6, max = 50)
    @Pattern(regexp = "[A-Za-z1-9]")
    @NotNull
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated
    private Role role;

    @ManyToMany
    @JoinTable
    private List<Game> games;
}
