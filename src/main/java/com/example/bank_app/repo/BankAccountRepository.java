package com.example.bank_app.repo;

import com.example.bank_app.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
    BankAccount findByUserId(Long userId);
}
