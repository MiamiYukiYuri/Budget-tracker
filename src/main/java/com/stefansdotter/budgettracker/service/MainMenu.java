package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class MainMenu {
     private IncomeStorage iStorage;
     private ExpenseStorage eStorage;
    public MainMenu (IncomeStorage iStorage, ExpenseStorage eStorage) {
        this.iStorage = iStorage;
        this.eStorage = eStorage;
    }
    Scanner scanner = new Scanner(System.in);
    public void mainMenu() {

        IncomeMenuService incomeMenuS = new IncomeMenuService(iStorage);
        ExpenseMenuService expenseMenuS = new ExpenseMenuService(eStorage);

        boolean isRunning = true;

        String welcomeMessage = """
               ____________________________                         
              | Welcome to your Budget App |\\        
              |____________________________| |     
               \\____________________________\\|
               """;

        System.out.println(welcomeMessage);

        while (isRunning) {
            System.out.println("");

            String menuChoice = """   
             ______________________________
            |  [1] My incomes              |\\
            |  [2] My expenses             | |
            |  [3] Show my transactions    | |
            |  [4] My BudgetTracker        | |
            |  [5] Exit program            | |
            |______________________________| |
             \\______________________________\\|""";

            System.out.println("Please choose from the alternatives below:");
            System.out.println(menuChoice);
            String userInput = scanner.nextLine();

            switch(userInput) {
                case "1":
                    incomeMenuS.incomeMenu();
                    break;
                case "2":
                    expenseMenuS.expenseMenu();
                    break;
                case "3":
                    System.out.println("This shows all of your transactions");
                    incomeMenuS.showAllIncomes();
                    expenseMenuS.showAllExpenses();
                    break;
                case "4":
                    // method menu for "my budget tracker"
                    break;
                case "5":
                    System.out.println("Have a nice day!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        }
    }
}