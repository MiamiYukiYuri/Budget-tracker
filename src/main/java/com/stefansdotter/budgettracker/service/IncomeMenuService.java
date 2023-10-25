package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.util.Scanner;

public class IncomeMenuService {
    Scanner scanner = new Scanner(System.in);
    IncomeStorage iStorage = new IncomeStorage();

    // MENU FOR ADDNIG, DELETING OR EDITING AN INCOME
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

    // MENU METHOD FOR ADDING AN INCOME
    public void menuAddIncome() {
        System.out.println("What category do you want to add an income to?");
        iStorage.incomeArray();
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



    //  METHOD FOR DELETING AN INCOME
    public void menuDeleteIncome() {
        System.out.println("What category do you want to delete an income from?");
        iStorage.incomeArray();
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
        System.out.println("In what category is the income you want to edit?");
        iStorage.incomeArray();
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
        iStorage.readIncomeFile();

        while (isRunning) {
            System.out.println("Choose an alternative ");
            System.out.println("[1] Show all of my incomes");
            System.out.println("[2] Add, delete or edit an income");
            System.out.println("[3] Return to main menu");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    iStorage.showAllIncomes();
                    break;
                case "2":
                    adeIncomeMenu();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
        }
    }
}