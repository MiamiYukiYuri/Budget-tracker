package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.util.Scanner;

public class IncomeMenuService {
    Scanner scanner = new Scanner(System.in);
    IncomeStorage iStorage = new IncomeStorage();
    ExpenseStorage eStorage = new ExpenseStorage();

    // INTRO MENU
    public void introMenu() {
        System.out.println("");
        System.out.println("Please choose from the alternatives below");
        System.out.println("[1] My incomes");
        System.out.println("[2] My expenses");
        System.out.println("[3] Show my transactions");
        System.out.println("[4] My BudgetTracker");
        System.out.println("[5] Exit program");

        String userInput = scanner.nextLine(); // fortsätta in i en switch?
    }

    // MENU METHOD FOR ADDING, DELETING OR EDITING AN ITEM
    public void adeMenu() {
        String userInput = scanner.nextLine();
        System.out.println("Do you want to add, edit or delete an item?");
        System.out.println("[1] ADD");
        System.out.println("[2] DELETE");
        System.out.println("[3] EDIT");

        switch (userInput) {
            case "1":
                System.out.println("[1] ADD");
                break;
            case "2":
                System.out.println("[2] DELETE");
                break;
            case "3":
                System.out.println("[3] EDIT");
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }

    // MENU METHOD FOR ADDING AN INCOME
    public void menuAddIncome() {
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("What category do you want to add an income to?");
                iStorage.incomeArray();
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        System.out.println("You've chosen the category Salary");
                        iStorage.addIncome(EIncomeCategory.SALARY);
                        break;
                    case "2":
                        System.out.println("You've chosen the income category Benefits");
                        iStorage.addIncome(EIncomeCategory.BENEFITS);
                        break;
                    case "3":
                        System.out.println("You've chosen the income category Other");
                        iStorage.addIncome(EIncomeCategory.OTHER);
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                        break;
                }
        }
    }

    //  METHOD FOR DELETING AN INCOME
    public void menuDeleteIncome() {
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the income category Salary");
                iStorage.removeIncome(EIncomeCategory.SALARY);
                break;
            case "2":
                System.out.println("You've chosen the income category Benefits");
                iStorage.removeIncome(EIncomeCategory.BENEFITS);
                break;
            case "3":
                System.out.println("You've chosen the income category Other");
                iStorage.removeIncome(EIncomeCategory.OTHER);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }


    // METHOD FOR EDITING AN INCOME
    public void menuEditIncome() {
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the income category Salary");
                // metod för att ändra på en inkomst
                break;
            case "2":
                System.out.println("You've chosen the income category Benefits");
                // metod för att ändra på en inkomst
                break;
            case "3":
                System.out.println("You've chosen the income category Other");
                // metod för att ändra på en inkomst
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }


    // INCOME MENU
    public void incomeMenu() {

        boolean isRunning = true;
        IncomeStorage iStorage = new IncomeStorage();
        int incomeIndex = 1;

        while (isRunning) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("Choose an alternative ");
                    System.out.println("[1] Show all of my incomes");
                    System.out.println("[2] Add, delete or edit an income");
                    System.out.println("[3] Return to main menu");
                    userInput = scanner.nextLine();
                    switch (userInput) {
                        case "1":
                            iStorage.showAllIncomes();
                            break;
                        case "2":
                            adeMenu();
                            switch (userInput) {
                                case "1":
                                    menuAddIncome();
                                    break;
                                case "2":
                                    menuDeleteIncome();
                                    break;
                                case "3":
                                    menuEditIncome();
                                    break;
                                default:
                                    break;
                            }
                        case "3":
                            isRunning = false;
                            introMenu();
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        }
    }
}