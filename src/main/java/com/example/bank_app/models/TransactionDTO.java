package com.example.bank_app.models;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        String type,
        BigDecimal amount,
        LocalDateTime timestamp
) {}