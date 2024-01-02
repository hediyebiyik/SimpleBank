package com.example.demo.controller;

import com.example.demo.BankAccount;
import com.example.demo.DepositTransaction;
import com.example.demo.WithdrawalTransaction;
import com.example.demo.services.AccountService;
import com.example.demo.services.exceptions.InsufficientBalanceException;
import com.example.demo.services.model.response.BalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public BankAccount getAccount(@PathVariable Long accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    @PostMapping("/credit/{accountNumber}")
    public BankAccount deposit(@PathVariable Long accountNumber, @RequestBody DepositTransaction depositTransaction) throws InsufficientBalanceException {
        return accountService.deposit(accountNumber, depositTransaction);
    }

    @PostMapping("/debit/{accountNumber}")
    public BankAccount withdraw(@PathVariable Long accountNumber, @RequestBody WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        return accountService.withdraw(accountNumber, withdrawalTransaction);
    }

    @GetMapping("/balance/{accountNumber}")
    public BalanceResponse getBalance(@PathVariable Long accountNumber) {
        return accountService.getBalance(accountNumber);
    }
}
