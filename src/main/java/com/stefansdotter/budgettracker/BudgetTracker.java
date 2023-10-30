package com.stefansdotter.budgettracker;

import com.stefansdotter.budgettracker.service.*;

import java.io.IOException;

public class BudgetTracker {
    public static void main(String[] args) throws IOException {
        UserStorage uStorage = new UserStorage();
        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();

        uStorage.readUserFile();
        iStorage.readIncomeFile();
        eStorage.readExpenseFile();

        UserMenuService userMenuService = new UserMenuService(uStorage);
        userMenuService.firstMenu();

        MainMenu mainMenu = new MainMenu(iStorage, eStorage);
        mainMenu.mainMenu();

        iStorage.saveIncomeFile();
        eStorage.saveExpenseFile();
        uStorage.saveUserFile();
    }
}