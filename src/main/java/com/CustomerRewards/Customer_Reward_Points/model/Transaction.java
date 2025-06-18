package com.CustomerRewards.Customer_Reward_Points.model;

import java.time.LocalDate;

/**
 * Represents a customer's Transaction.
 */

public class Transaction {
    private String customerId;
    private double amount;
    private LocalDate date;

    public Transaction(String customerId, double amount, LocalDate date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
