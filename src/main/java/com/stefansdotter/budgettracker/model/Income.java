package com.stefansdotter.budgettracker.model;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

public class Income extends Transaction {

    private EIncomeCategory incomeCategories; // enumet

    // konstruktor för att skapa ny income
    // adderar enumet
    public Income(double amount, EIncomeCategory incomeCategories) {
        super(amount);
        this.incomeCategories = incomeCategories;
    }

    public void method() {
        System.out.println(date);
    }
}