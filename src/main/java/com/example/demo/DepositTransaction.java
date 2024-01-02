package com.example.demo;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class DepositTransaction extends Transaction {
    @Override
    public void execute(BankAccount account) {
        account.setBalance(account.getBalance() + this.getAmount());
    }
}
