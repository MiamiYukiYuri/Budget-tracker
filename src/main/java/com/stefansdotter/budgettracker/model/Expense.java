package com.stefansdotter.budgettracker.model;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

public class Expense extends Transaction {

    private EExpenseCategory eCategory;

    private String name;

    public String getName() {
        return name;
    }

    public EExpenseCategory getExpenseCategory() {
        return eCategory;
    }


    // konstruktor för att skapa ny expense
    // adderar enum och name till vår konstruktor
    public Expense(String name, String date, double amount, EExpenseCategory eCategory) {
        super(amount, date);
        this.name = name;
        this.eCategory = eCategory;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "eCategory=" + eCategory +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                "} " + super.toString();
    }
}