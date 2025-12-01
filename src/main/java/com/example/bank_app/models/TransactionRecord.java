package com.example.bank_app.models;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private BankAccount account;

    private String type;              // DEPOSIT or WITHDRAW
    private BigDecimal amount;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();


}
