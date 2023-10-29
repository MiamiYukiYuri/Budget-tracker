package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.Expense;
import com.stefansdotter.budgettracker.model.Income;

public class MyBudgetTracker {

    private ExpenseStorage eStorage;
    private IncomeStorage iStorage;


    public MyBudgetTracker (ExpenseStorage eStorage, IncomeStorage iStorage) {
       this.eStorage = eStorage;
       this.iStorage = iStorage;
    }


    // för varje iteration i loopen adderas varje current income amount till en amount of incomes
    private double incomeAmount() {
          double totalIncomeAmount = 0;
     for (Income income : iStorage.getAllIncomes()) {
         totalIncomeAmount += income.getAmount();
     }
      return totalIncomeAmount;
    }

    // för varje iteration i loopen adderas varje current expense amount till en total amount of expenses
    private double expenseAmount() {
        double totalExpenseAmount = 0;
        for (Expense expense : eStorage.getAllExpenses()) {
            totalExpenseAmount += expense.getAmount();
        }
        return totalExpenseAmount;
    }


    // Method for showing the balance after income - expenses
   public void budgetTracker() {
       double totalIncomeAmount = incomeAmount();
       double totalExpenseAmount = expenseAmount();

       System.out.println("Your total amount of expenses are: " + totalExpenseAmount);
       System.out.println("Your total amount of incomes are: " + totalIncomeAmount);
       System.out.println("");
       System.out.println("Your balance after all of your expenses has been paid is " + (totalIncomeAmount - totalExpenseAmount));
   }
}


