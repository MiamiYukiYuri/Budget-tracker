package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class SecondMenu {
    public static void main(String[] args) {

        boolean isRunning = true;
        ExpenseStorage expenseStorage = new ExpenseStorage();
        IncomeMenuService incomeMenuService = new IncomeMenuService();
        Scanner scanner = new Scanner(System.in);

        //public void expenseMenu() {
            while (isRunning) {
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        System.out.println("Choose an alternative ");
                        System.out.println("[1] Show all of my expenses");
                        System.out.println("[2] Add, delete or edit an expense category");
                        userInput = scanner.nextLine();
                        switch (userInput) {
                            case "1":
                                System.out.println("This shows all of your expenses");
                                expenseStorage.allExpenses();
                                break;
                            case "2":
                                incomeMenuService.adeMenu();
                                switch (userInput) {
                                    case "1":
                                        // add method
                                        break;
                                    case "2":
                                        // delete method
                                    case "3":
                                        // edit method
                                    default:
                                        System.out.println("Invalid input, please try again");
                                        break;
                                }
                                break;
                        }
                }
            }
        }
    }
