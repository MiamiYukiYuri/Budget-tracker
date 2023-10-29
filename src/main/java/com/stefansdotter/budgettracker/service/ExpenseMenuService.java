package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.util.Scanner;

public class ExpenseMenuService {

    private ExpenseStorage expenseStorage;
    Scanner scanner = new Scanner(System.in);

    public ExpenseMenuService(ExpenseStorage expenseStorage) {
        this.expenseStorage = expenseStorage;
    }

    // METHOD MENU FOR ADDING, DELETING OR EDITING AN ITEM
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

    public void showAllExpenses() {
        expenseStorage.showAllExpenses();
    }

    // METHOD MENU FOR EXPENSES
    public void expenseMenu() {
        expenseStorage.readExpenseFile();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("");
            System.out.println("Choose an alternative ");
            System.out.println("[1] Show all of my expenses");
            System.out.println("[2] Add, delete or edit an expense");
            System.out.println("[3] Return to main menu");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    expenseStorage.showAllExpenses();
                    break;
                case "2":
                    adeExpenseMenu();
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        }
    }


    // METHOD MENU FOR ADDING AN EXPENSE
    public void menuAddExpense() {
        System.out.println("What category do you want to add an expense to?");
        expenseStorage.expenseCategoryArray();
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

    // METHOD MENU FOR DELETING AN EXPENSE
    public void menuDeleteExpense() {
        System.out.println("What category do you want to delete an expense from?");
        expenseStorage.expenseCategoryArray();
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the category Rent");
                expenseStorage.removeExpense(EExpenseCategory.RENT);
                break;
            case "2":
                System.out.println("You've chosen the category Food");
                expenseStorage.removeExpense(EExpenseCategory.FOOD);
                break;
            case "3":
                System.out.println("You've chosen the category Insurance");
                expenseStorage.removeExpense(EExpenseCategory.INSURANCE);
                break;
            case "4":
                System.out.println("You've chosen the category Pets");
                expenseStorage.removeExpense(EExpenseCategory.PETS);
                break;
            case "5":
                System.out.println("You've chosen the category Other");
                expenseStorage.removeExpense(EExpenseCategory.OTHER);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }

    // METHOD MENU FOR EDITING AN EXPENSE
    public void menuEditExpense() {
        System.out.println("In what category is the expense you want to edit?");
        expenseStorage.expenseCategoryArray();
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the category Rent");
                expenseStorage.editExpense(EExpenseCategory.RENT);
                break;
            case "2":
                System.out.println("You've chosen the category Food");
                expenseStorage.editExpense(EExpenseCategory.FOOD);
                break;
            case "3":
                System.out.println("You've chosen the category Insurance");
                expenseStorage.editExpense(EExpenseCategory.INSURANCE);
                break;
            case "4":
                System.out.println("You've chosen the category Pets");
                expenseStorage.editExpense(EExpenseCategory.PETS);
                break;
            case "5":
                System.out.println("You've chosen the category Other");
                expenseStorage.editExpense(EExpenseCategory.OTHER);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }
}