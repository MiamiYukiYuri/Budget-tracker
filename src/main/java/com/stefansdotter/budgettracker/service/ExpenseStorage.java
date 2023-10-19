package com.stefansdotter.budgettracker.service;

import java.util.ArrayList;

public class ExpenseStorage {

    // Skapa ny ArrayList för alla expenses
    ArrayList<String> expenseList = new ArrayList<>();

    // lista alla utgifter i array list
    public void allExpenses() {
        for (String expense : expenseList) {
            System.out.println(expense);
        }
    }

    // lägg till utgift i array list
    public void addExpense(String expense) {
        expenseList.add(expense);
    }


    // ta bort utgift från array list
    public void deleteExpense(String expense) {
        expenseList.add(expense);
    }


    // ändra på en utgift
    // public void editExpense(String expense) {
    //     expenseList.set(expense);  }

}


// SAVE TO FILE


// READ FILE

