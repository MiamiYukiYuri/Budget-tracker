package com.stefansdotter.budgettracker.model;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

public class Expense extends Transaction {

    private EExpenseCategory eCategory;

    public String getName() {
        return name;
    }

    private String name;


    // konstruktor för att skapa ny expense
    // adderar enum och name till vår konstruktor
    public Expense(String name, String date, double amount, EExpenseCategory eCategory) {
        super(amount, date);
        this.name = name;
        this.eCategory = eCategory;
    }
}