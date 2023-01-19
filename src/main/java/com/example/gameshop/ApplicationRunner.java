package com.example.gameshop;

import com.example.gameshop.dtos.UserLoginDto;
import com.example.gameshop.dtos.UserRegisterDto;
import com.example.gameshop.services.UserService;
import com.example.gameshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final ValidationUtil validationUtil;
    private final UserService userService;

    @Autowired
    public ApplicationRunner(BufferedReader bufferedReader, ValidationUtil validationUtil, UserService userService) {
        this.bufferedReader = bufferedReader;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        String input = this.bufferedReader.readLine();

        while (!input.equals("END")) {
            String[] elements = input.split("\\|");
            switch (elements[0]) {
                case "RegisterUser":
                    if (!elements[2].equals(elements[3])) {
                        System.out.println("Passwords don't match");
                        break;
                    }

                    UserRegisterDto userRegisterDto = new UserRegisterDto(elements[1], elements[2], elements[4]);

                    if (this.validationUtil.isValid(userRegisterDto)) {
                        this.userService.registerUser(userRegisterDto);
                        System.out.printf("%s was registered%n", userRegisterDto.getFullName());
                    } else {
                        this.validationUtil
                                .getViolations(userRegisterDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "LoginUser":
                    UserLoginDto userLoginDto = new UserLoginDto(elements[1], elements[2]);

                    if (this.validationUtil.isValid(userLoginDto)) {
                        this.userService.loginUser(userLoginDto);
                    } else {
                        this.validationUtil.getViolations(userLoginDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "Logout":
                    this.userService.logout();
                    break;

            }

            input = this.bufferedReader.readLine();
        }
    }
}
