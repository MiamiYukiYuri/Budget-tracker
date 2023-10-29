package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.util.Scanner;

public class IncomeMenuService {
    Scanner scanner = new Scanner(System.in);
    private final IncomeStorage iStorage;

    public IncomeMenuService(IncomeStorage iStorage) {
        this.iStorage = iStorage;
    }

    // METHOD MENU FOR ADDING, DELETING OR EDITING AN INCOME
    public void adeIncomeMenu() {
        System.out.println("Do you want to add, delete or edit an income?");
        System.out.println("[1] ADD");
        System.out.println("[2] DELETE");
        System.out.println("[3] EDIT");
        String userInput = scanner.nextLine();
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
                System.out.println("Invalid input, please try again");
                break;
        }
    }

    // METHOD MENU FOR ADDING AN INCOME
    public void menuAddIncome() {
        System.out.println("What category do you want to add an income to?");
        iStorage.incomeCategories();
        String userInput = scanner.nextLine();

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


    //  METHOD MENU FOR DELETING AN INCOME
    public void menuDeleteIncome() {
        System.out.println("What category do you want to delete an income from?");
        iStorage.incomeCategories();
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

    // METHOD MENU FOR EDITING AN INCOME
    public void menuEditIncome() {
        System.out.println("In what category is the income you want to edit?");
        iStorage.incomeCategories();
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("You've chosen the income category Salary");
                iStorage.editIncome(EIncomeCategory.SALARY);
                break;
            case "2":
                System.out.println("You've chosen the income category Benefits");
                iStorage.editIncome(EIncomeCategory.BENEFITS);
                break;
            case "3":
                System.out.println("You've chosen the income category Other");
                iStorage.editIncome(EIncomeCategory.OTHER);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }

    // METHOD MENU INCOMES
    public void incomeMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("");
            System.out.println("Choose an alternative ");
            System.out.println("[1] Show all of my incomes");
            System.out.println("[2] Add, delete or edit an income");
            System.out.println("[3] Return to main menu");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("These are all of your incomes");
                    System.out.println("");
                    iStorage.showAllIncomes();
                    break;
                case "2":
                    adeIncomeMenu();
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
}