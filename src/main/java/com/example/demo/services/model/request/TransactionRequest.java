package com.example.demo.services.model.request;


public class TransactionRequest extends BaseServiceRequest {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
