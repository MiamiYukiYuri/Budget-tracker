package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class MainMenu {
    private IncomeStorage iStorage;
    private ExpenseStorage eStorage;

    public MainMenu(IncomeStorage iStorage, ExpenseStorage eStorage) {
        this.iStorage = iStorage;
        this.eStorage = eStorage;
    }

    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {

        IncomeMenuService incomeMenuS = new IncomeMenuService(iStorage);
        ExpenseMenuService expenseMenuS = new ExpenseMenuService(eStorage);
        MyBudgetTracker myBudgetTracker = new MyBudgetTracker(eStorage, iStorage);
        boolean isRunning = true;

        String welcomeMessage = """
                 
                 ______________________________                        
                | Welcome to the BudgetTracker |\\        
                |______________________________| |     
                 \\______________________________\\|
                 """;

        String goodbyeMessage = """
                 ______________________________                        
                |       Have a nice day!       |\\        
                |______________________________| |     
                 \\______________________________\\|
                 """;

        String menuChoice = """        
                 Please choose from the alternatives below  
                 ______________________________
                |  [1] My incomes              |\\
                |  [2] My expenses             | |
                |  [3] My transactions         | |
                |  [4] My BudgetTracker        | |
                |  [5] Exit program            | |
                |______________________________| |
                 \\______________________________\\|
                 """;
        System.out.println(welcomeMessage);

        while (isRunning) {
            System.out.println("");

            System.out.println(menuChoice);
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    incomeMenuS.incomeMenu();
                    break;
                case "2":
                    expenseMenuS.expenseMenu();
                    break;
                case "3":
                    System.out.println("These are all of your transactions");
                    System.out.println("");
                    iStorage.showAllIncomes();
                    eStorage.showAllExpenses();
                    break;
                case "4":
                    myBudgetTracker.budgetTracker();
                    break;
                case "5":
                    System.out.println(goodbyeMessage);
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        }
    }
}