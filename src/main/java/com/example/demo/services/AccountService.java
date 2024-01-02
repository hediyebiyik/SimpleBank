package com.example.demo.services;

import com.example.demo.BankAccount;
import com.example.demo.DepositTransaction;
import com.example.demo.WithdrawalTransaction;
import com.example.demo.controller.TransactionStatus;
import com.example.demo.repository.AccountRepository;
import com.example.demo.services.exceptions.InsufficientBalanceException;
import com.example.demo.services.model.response.BalanceResponse;
import com.example.demo.services.model.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BankAccount deposit(final Long accountNumber, final DepositTransaction depositTransaction) throws InsufficientBalanceException {
        final BankAccount account = accountRepository.getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.post(depositTransaction);
            return accountRepository.save(account);
        }
        return null;
    }

    public BankAccount withdraw(final Long accountNumber, final WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        final BankAccount account = accountRepository.getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.post(withdrawalTransaction);
            return accountRepository.save(account);
        }

        return null;
    }

    public BalanceResponse getBalance(final Long accountNumber) {
        final BankAccount account = accountRepository.getAccountByAccountNumber(accountNumber);

        final BalanceResponse response = new BalanceResponse();
        response.setStatus(TransactionStatus.OK);
        response.setBalance(account != null ? account.getBalance() : 0.0);

        return response;
    }

    public BankAccount getAccountByNumber(final Long accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }
}
