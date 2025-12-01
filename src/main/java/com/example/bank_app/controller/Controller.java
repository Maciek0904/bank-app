package com.example.bank_app.controller;

import com.example.bank_app.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bank_app.service.UserService;
import com.example.bank_app.service.BankAccountService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;
    private final BankAccountService bankAccountService;

    @PostMapping("/register")
    public void register(@RequestBody User user){
        userService.registerUser(user);
    }
    @GetMapping("/balance/{userId}")
    public BigDecimal getBalance(@PathVariable Long userId){
        return bankAccountService.getBalance(userId);
    }
    @PostMapping("/deposit/{userId}")
    public void deposit(@PathVariable Long userId,
                        @RequestBody BigDecimal amount){
        bankAccountService.deposit(userId, amount);
    }

    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<String> withdraw(@PathVariable Long userId,
                                           @RequestBody BigDecimal amount){
       boolean success = bankAccountService.withdraw(userId,amount);

       if(!success){
           return ResponseEntity.badRequest().body("Insufficient funds");

       }
        return ResponseEntity.ok("Withdrawal Successful");
    }
}
