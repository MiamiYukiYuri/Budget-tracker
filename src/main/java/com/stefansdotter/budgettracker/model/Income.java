package com.stefansdotter.budgettracker.model;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

public class Income extends Transaction {
    private EIncomeCategory incomeCategory; // enumet

    private String name;


    // konstruktor för att skapa ny income
    // adderar enumet till vår konstruktor
    public Income(String name, double amount, EIncomeCategory incomeCategories) {
        super(amount);
        this.name = name;
        this.incomeCategory = incomeCategories;
        }
    }
