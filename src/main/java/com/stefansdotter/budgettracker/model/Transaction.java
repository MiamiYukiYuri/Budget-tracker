package com.stefansdotter.budgettracker.model;

public abstract class Transaction {

    protected double amount;
    protected String date;

    protected Transaction(double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                '}';

    }
}