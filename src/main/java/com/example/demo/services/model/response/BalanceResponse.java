
package com.example.demo.services.model.response;

import com.example.demo.controller.TransactionStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BalanceResponse extends TransactionResponse {
    private double balance;
}
