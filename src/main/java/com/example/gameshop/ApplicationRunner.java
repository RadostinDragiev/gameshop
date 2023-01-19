package com.example.gameshop;

import com.example.gameshop.dtos.UserRegisterDto;
import com.example.gameshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final UserService userService;

    @Autowired
    public ApplicationRunner(BufferedReader bufferedReader, UserService userService) {
        this.bufferedReader = bufferedReader;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        String input = this.bufferedReader.readLine();

        UserRegisterDto user = new UserRegisterDto();
        while (!input.equals("END")) {
            String[] elements = input.split("\\|");
            switch (elements[0]) {
                case "RegisterUser":
                    break;
                case "LoginUser":
                    break;
                case "Logout":
                    break;

            }

            input = this.bufferedReader.readLine();
        }
    }
}
