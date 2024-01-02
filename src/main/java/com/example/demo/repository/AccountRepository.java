package com.example.demo.repository;

import com.example.demo.BankAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<BankAccount, Long> {

    @Query("SELECT ba FROM BankAccount ba WHERE ba.accountNumber = :accountNumber")
    BankAccount getAccountByAccountNumber(@Param("accountNumber") Long accountNumber);
}
