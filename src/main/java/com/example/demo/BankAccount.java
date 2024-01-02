package com.example.demo;

import com.example.demo.Transaction;
import com.example.demo.services.exceptions.InsufficientBalanceException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;
    private String accountNumber;
    private double balance;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public void post(Transaction transaction) throws InsufficientBalanceException {
        transaction.setBankAccount(this);
        this.transactions.add(transaction);
        transaction.execute(this);
    }

}


