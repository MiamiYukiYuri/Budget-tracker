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


    // för varje iteration i loopen adderas summan av varje enskild inkomst till en sammanlagd summa av inkomster
    private double totalIncomeAmount() {
          double totalIncomeAmount = 0;
     for (Income income : iStorage.getAllIncomes()) {
         totalIncomeAmount += income.getAmount();
     }
      return totalIncomeAmount;
    }

    // för varje iteration i loopen adderas summan av varje enskild utgift till en sammanlagd summa av utgifter
    private double totalExpenseAmount() {
        double totalExpenseAmount = 0;
        for (Expense expense : eStorage.getAllExpenses()) {
            totalExpenseAmount += expense.getAmount();
        }
        return totalExpenseAmount;
    }


    // metod som visar totala summan för utgifter och inkomster
    // räknar ut vad som blir kvar efter att den totala summan för utgifter subtraherats från den totala summan av inkomster
    // använder Math.round för att runda av beloppen pga snyggare så (:
   public void myBudgetTracker() {
       double totalIncomeAmount = totalIncomeAmount();
       double totalExpenseAmount = totalExpenseAmount();

       System.out.println("The total amount of your expenses are " + Math.round(totalExpenseAmount) + " SEK.");
       System.out.println("The total amount of your incomes are " + Math.round(totalIncomeAmount) + " SEK.");
       System.out.println("");
       System.out.println("Your balance after all of your expenses has been paid is " + Math.round(totalIncomeAmount - totalExpenseAmount) + " SEK.");
   }
}