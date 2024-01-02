package com.example.demo.services.model.response;

import com.example.demo.controller.TransactionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionResponse {
    private TransactionStatus status;
}
