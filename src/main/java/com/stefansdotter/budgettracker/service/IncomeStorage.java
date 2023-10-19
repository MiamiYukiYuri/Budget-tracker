package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.Income;

import java.util.ArrayList;

public class IncomeStorage {

    // ny ArrayList för inkomster
    ArrayList<Income> incomeList = new ArrayList<>();

    // LIST ALL INCOMES, skriver ut alla inkomster
   /* public void allIncome() {
        for(String income : incomeList) {
            System.out.println(income);
        }
    }             */

    // ADDERA INKOMST
    public void addIncome(Income income) {
        incomeList.add(income);
    }

    // REMOVE INCOME
    public void removeIncome(Income income) {
        incomeList.remove(income);
    }

    // EDIT INCOME
    //public void editIncome(String income) {
    //  incomeList.set(income);
}


// SAVE TO FILE


// READ FILE


// Den här klassen ska ansvara för att spara till fil, läsa in fil, lista alla inkomster,
//lägga till, uppdatera eller ta bort en inkomst.