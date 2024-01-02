package com.example.demo;

import com.example.demo.services.exceptions.InsufficientBalanceException;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class WithdrawalTransaction extends Transaction {
    @Override
    public void execute(BankAccount account) throws InsufficientBalanceException {

        if (account.getBalance() <  this.getAmount()) {
            throw new InsufficientBalanceException();
        }

        account.setBalance(account.getBalance() - this.getAmount());
    }
}
