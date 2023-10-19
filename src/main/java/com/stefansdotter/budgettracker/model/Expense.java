package com.stefansdotter.budgettracker.model;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

public class Expense extends Transaction {

    boolean isRunning = true;

    // hämtar attributen från superklassen Transaction
    // date läggs till automatiskt och behöver inte fyllas i manuellt
    public Expense(double amount) {
        super(amount);
    }

    private EExpenseCategory expenseCategory;
}