package com.example.bank_app.service;

import com.example.bank_app.models.BankAccount;
import com.example.bank_app.models.TransactionRecord;
import com.example.bank_app.models.User;
import com.example.bank_app.repo.BankAccountRepository;
import com.example.bank_app.repo.TransactionRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository accountRepo;
    private final TransactionRecordRepository txRepo;

    public BankAccount createAccountForUser(User user){
        BankAccount account = BankAccount.builder()
                .user(user)
                .balance(BigDecimal.ZERO)
                .build();

        return accountRepo.save(account);
    }


    public BigDecimal getBalance(Long userId){
        BankAccount acc = accountRepo.findByUserId(userId);
        return acc.getBalance();
    }

    public void deposit(Long userId, BigDecimal amount){
        BankAccount acc = accountRepo.findByUserId(userId);

        acc.setBalance(acc.getBalance().add(amount));
        accountRepo.save(acc);

        // Next Step -- Save transaction
        TransactionRecord tx = TransactionRecord.builder()
                .account(acc)
                .type("DEPOSIT")
                .amount(amount)
                .build();
        txRepo.save(tx);

    }

    public boolean withdraw(Long userId,BigDecimal amount){
        BankAccount acc = accountRepo.findByUserId(userId);
        if(acc.getBalance().compareTo(amount) < 0){
            return false;
        }

        acc.setBalance(acc.getBalance().subtract(amount));
        accountRepo.save(acc);

        // Next Step -- Save transaction
        TransactionRecord tx = TransactionRecord.builder()
                .account(acc)
                .type("WITHDRAW")
                .amount(amount)
                .build();
        txRepo.save(tx);

        return true;
    }



}
