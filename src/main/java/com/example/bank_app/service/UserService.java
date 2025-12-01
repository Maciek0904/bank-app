package com.example.bank_app.service;

import com.example.bank_app.models.User;
import com.example.bank_app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BankAccountService bankAccountService;
    public void registerUser(User user){
        userRepository.save(user);
        bankAccountService.createAccountForUser(user);

    }
}
