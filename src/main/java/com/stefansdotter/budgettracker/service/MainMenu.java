package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class MainMenu {

    Scanner scanner = new Scanner(System.in);
    public void mainMenu() {

        boolean isRunning = true;
        while (isRunning) {

            IncomeMenuService incomeMenuS = new IncomeMenuService();
            ExpenseMenuService expenseMenuS = new ExpenseMenuService();


            System.out.println("");
            System.out.println("Welcome to your Budget App!");
            System.out.println("Please choose from the alternatives below");
            System.out.println("");
            System.out.println("[1] My incomes");
            System.out.println("[2] My expenses");
            System.out.println("[3] Show my transactions");
            System.out.println("[4] My BudgetTracker");
            System.out.println("[5] Exit program");
            String userInput = scanner.nextLine();

            switch(userInput) {
                case "1":
                    incomeMenuS.incomeMenu();
                    break;
                case "2":
                    expenseMenuS.expenseMenu();
                    break;
                case "3":
                    // method menu for "show all transactions"
                    break;
                case "4":
                    // method menu for "my budget tracker"
                    break;
                case "5":
                    isRunning = false;
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        }
    }
}
