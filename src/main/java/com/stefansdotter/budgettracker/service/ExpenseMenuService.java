package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.util.Scanner;

public class ExpenseMenuService {

    private EExpenseCategory eExpenseCategory;
    ExpenseStorage expenseStorage = new ExpenseStorage();
    MainMenu mainMenu = new MainMenu();
    IncomeMenuService menuImport = new IncomeMenuService();
    Scanner scanner = new Scanner(System.in);


    // MENU METHOD FOR ADDING, DELETING OR EDITING AN ITEM
    public void adeExpenseMenu() {
        System.out.println("Do you want to add, delete or edit an expense?");
        System.out.println("[1] ADD");
        System.out.println("[2] DELETE");
        System.out.println("[3] EDIT");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                menuAddExpense();
                break;
            case "2":
                menuDeleteExpense();
                break;
            case "3":
                menuEditExpense();
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }

    // LOOPS ENUM CATEGORIES
    public void expenseArray() {
        int expenseIndex = 1;
        for (EExpenseCategory expenseCategory : EExpenseCategory.values()) {
            System.out.println(expenseIndex + " " + expenseCategory);
            expenseIndex++;
        }
    }


    // LISTS ALL EXPENSES    - kan inte hämta expenseList, private i ExpenseStorage men funkar med income??
    /*
    public void showAllExpenses() {
        for (Expense expense : expenseList.values()) {
            System.out.println(expense);
        }
    }

     */


    // EXPENSE MENU
    public void expenseMenu() {
        String userInput = scanner.nextLine();
        expenseStorage.readExpenseFile();
        boolean isRunning = true;

        while (isRunning) {
                    System.out.println("Choose an alternative ");
                    System.out.println("[1] Show all of my expenses");
                    System.out.println("[2] Add, delete or edit an expense");
                    System.out.println("[3] Return to main menu");
                    userInput = scanner.nextLine();
                    switch (userInput) {
                        case "1":
                            expenseStorage.showAllExpenses();
                            break;
                        case "2":
                            adeExpenseMenu();    // OBS! ej klar
                            break;
                        case "3":
                            isRunning = false; // OBS! ej klar
                            break;
                        default:
                            System.out.println("Invalid input, please try again");
                            break;
                    }
            }
        }



    // MENU FOR ADDING AN EXPENSE
    public void menuAddExpense() {
        System.out.println("What category do you want to add an expense to?");
        expenseArray();
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the category Rent");
                expenseStorage.addExpense(EExpenseCategory.RENT);
                break;
            case "2":
                System.out.println("You've chosen the category Food");
                expenseStorage.addExpense(EExpenseCategory.FOOD);
                break;
            case "3":
                System.out.println("You've chosen the category Insurance");
                expenseStorage.addExpense(EExpenseCategory.INSURANCE);
                break;
            case "4":
                System.out.println("You've chosen the category Pets");
                expenseStorage.addExpense(EExpenseCategory.PETS);
                break;
            case "5":
                System.out.println("You've chosen the category Other");
                expenseStorage.addExpense(EExpenseCategory.OTHER);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }


    //  METHOD FOR DELETING AN EXPENSE
    public void menuDeleteExpense() {
    }


    // METHOD FOR EDITING AN EXPENSE
    public void menuEditExpense() {
    }
}