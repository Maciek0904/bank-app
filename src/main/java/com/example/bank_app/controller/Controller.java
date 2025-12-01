package com.example.bank_app.controller;

import com.example.bank_app.models.User;
import com.example.bank_app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bank_app.service.UserService;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody User user){
        userService.registerUser(user);
    }
}
