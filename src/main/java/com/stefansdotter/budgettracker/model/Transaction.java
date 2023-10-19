package com.stefansdotter.budgettracker.model;

import java.time.LocalDateTime;

public abstract class Transaction {
    protected final double amount;
    protected LocalDateTime date;

    protected Transaction(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();   // LocalDataTime är en klass som skapar dagens datum och tid automatiskt
    }


    // to-String metod
    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }
}