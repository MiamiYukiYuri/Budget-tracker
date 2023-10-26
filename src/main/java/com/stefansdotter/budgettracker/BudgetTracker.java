package com.stefansdotter.budgettracker;

import com.stefansdotter.budgettracker.service.ExpenseStorage;
import com.stefansdotter.budgettracker.service.IncomeStorage;
import com.stefansdotter.budgettracker.service.MainMenu;

import java.io.IOException;

public class BudgetTracker {

    public static void main(String[] args) throws IOException {

        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();

        iStorage.readIncomeFile();
        eStorage.readExpenseFile();

        MainMenu mainMenu = new MainMenu(iStorage, eStorage);
        mainMenu.mainMenu();

        iStorage.saveIncomeFile();
        eStorage.saveExpenseFile();
    }
}