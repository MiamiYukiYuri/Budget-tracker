package com.stefansdotter.budgettracker.model;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

public class Income extends Transaction {

    public EIncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    private final EIncomeCategory incomeCategory;
    private final String name;

    // konstruktor för att skapa ny income
    // adderar enumet till vår konstruktor
    public Income(String name, String date, double amount, EIncomeCategory incomeCategories) {
        super(amount, date);
        this.name = name;
        this.incomeCategory = incomeCategories;
    }

    // getter för namn på inkomst att användas i metoden för save income to JSON
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeCategory=" + incomeCategory +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                "} " + super.toString();
    }
}
