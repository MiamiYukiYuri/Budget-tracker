package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.util.Scanner;

public class ExpenseMenuService {

    private EExpenseCategory expenseCategory;
    ExpenseStorage expenseStorage = new ExpenseStorage();
    IncomeMenuService menuImport = new IncomeMenuService();
    Scanner scanner = new Scanner(System.in);


    // MENU METHOD FOR ADDING, DELETING OR EDITING AN ITEM
    public void adeExpenseMenu() {
        String userInput = scanner.nextLine();
        System.out.println("Do you want to add, delete or edit an item?");
        System.out.println("[1] ADD");
        System.out.println("[2] DELETE");
        System.out.println("[3] EDIT");

        switch (userInput) {
            case "1":
                System.out.println("[1] ADD");
                menuAddExpense();
                break;
            case "2":
                System.out.println("[2] DELETE");
                menuDeleteExpense();
                break;
            case "3":
                System.out.println("[3] EDIT");
                menuEditExpense();
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }


    // EXPENSE MENU
    public void expenseMenu() {

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        while (isRunning) {
            ;
            switch (userInput) {
                case "1":
                    System.out.println("Choose an alternative ");
                    System.out.println("[1] Show all of my expenses");
                    System.out.println("[2] Add, delete or edit an expense category");
                    System.out.println("[3] Return to main menu");
                    userInput = scanner.nextLine();
                    switch (userInput) {
                        case "1":
                            // visa alla utgifter
                            break;
                        case "2":
                            adeExpenseMenu();    // OBS! ej klar
                            break;
                        case "3":
                            isRunning = false;
                            menuImport.introMenu();
                            break;
                        default:
                            System.out.println("Invalid input, please try again");
                            break;
                            }
            }
        }
    }


    // ADD EXPENSE
    public void menuAddExpense() {
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("What category do you want to add an income to?");
                // loopa enum
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        System.out.println("You've chosen the category Rent");
                        break;
                    case "2":
                        System.out.println("You've chosen the income category Food");
                        //eStorage.addExpense(EExpenseCategory.FOOD);
                        break;
                    case "3":
                        System.out.println("You've chosen the income category Insurance");
                        //
                        break;
                    case "4":
                        System.out.println("You've chosen the income category Pets");
                        //
                        break;
                    case "5":
                        System.out.println("You've chosen the income category Other");
                        //
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                        break;
                        }
        }
    }


    //  METHOD FOR DELETING AN EXPENSE
    public void menuDeleteExpense() {
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the income category Rent");
                // välja expense, bäst hur=?

                break;
            case "2":
                System.out.println("You've chosen the income category Food");
                break;
            case "3":
                System.out.println("You've chosen the income category Insurance");
                break;
            case "4":
                System.out.println("You've chosen the income category Pets");
                break;
            case "5":
                System.out.println("You've chosen the income category Other");
                break;
        }
    }


    public void menuEditExpense() {
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the income category Rent");
                // välja expense, bäst hur?

                break;
            case "2":
                System.out.println("You've chosen the income category Food");
                break;
            case "3":
                System.out.println("You've chosen the income category Insurance");
                break;
            case "4":
                System.out.println("You've chosen the income category Pets");
                break;
            case "5":
                System.out.println("You've chosen the income category Other");
                break;
        }
    }
}