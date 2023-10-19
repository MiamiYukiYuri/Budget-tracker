package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.util.ArrayList;

public class ExpenseStorage {

    // Skapa ny ArrayList för alla expenses
    ArrayList<String> expenseList = new ArrayList<>();

    private EExpenseCategory expenseCategory;
    private int expenseIndex = 1;




    public void expenseMenu() {

        for (EExpenseCategory expenseCategory : EExpenseCategory.values()) {
            System.out.println(expenseIndex + " " + expenseCategory);
        }
    }













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

