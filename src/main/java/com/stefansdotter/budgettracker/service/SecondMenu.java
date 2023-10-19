package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;
import com.stefansdotter.budgettracker.model.Income;
import com.stefansdotter.budgettracker.model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class SecondMenu {
    public static void main(String[] args) {

        boolean isRunning = true;
        IncomeStorage incomeStorage = new IncomeStorage();
        ArrayList<Transaction> allTransactions = new ArrayList<>(); // för att kunna visa alla transaktioner
        ArrayList<IncomeStorage> allIncomes = new ArrayList<>(); // för att visa alla inkomster
        int incomeIndex = 1;
        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println(incomeIndex + " " + incomeCategory);
            incomeIndex++;
        }


        while (isRunning) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("Choose an alternative ");
                    System.out.println("[1] Show all of my incomes");
                    System.out.println("[2] Add, delete or change an income category");
                    userInput = input.nextLine();
                    switch (userInput) {
                        case "1":
                            incomeStorage.allIncome(); // loopar alla inkomster, behöver ej sout. kalla på klassen först sedan metoden i klassen
                            break;

                        case "2":
                            System.out.println("Choose an alternative ");
                            System.out.println("[1] Add income item");
                            System.out.println("[2] Edit an income item");
                            System.out.println("[3] Delete income item");
                            userInput = input.nextLine();
                            switch (userInput) {
                                case "1":
                                    System.out.println("Here you can add an income item");
                                    userInput = input.nextLine();
                                    incomeStorage.addIncome(new Income(Double.parseDouble(userInput), EIncomeCategory.SALARY)); // Double.parseDouble gör om userInput till double
                                    // två värden, amount och category
                                    //  initierat IncomeStorage och gett variabelnamn incomeStorage. addIncome(userInput) innebär att användarens input är det som läggs till i array listen
                                    break;
                                case "2":
                                    System.out.println("Here you can edit an income item");
                                    // metod för att ändra en inkomst
                                    break;
                                case "3":
                                    System.out.println("Here you can delete an income item");
                                    userInput = input.nextLine();
                                    incomeStorage.removeIncome(userInput);    // vorfor fonka ej?
                                    break;
                                default:
                                    System.out.println("Invalid input, please try again");
                                    break;
                            }
                            break;
                    }

                case "2":
                    System.out.println("Choose an alternative ");
                    System.out.println("[1] Show all of my expenses");
                    System.out.println("[2] Add, change or delete an expense category");
                    userInput = input.nextLine();
                    switch (userInput) {
                        case "1":
                            System.out.println("This shows all of your expenses");
                            // enum IncomeCategory
                            break;
                        case "2":
                            System.out.println("Choose an alternative ");
                            System.out.println("Add expense category");
                            System.out.println("Edit an expense category");
                            System.out.println("Delete an expense category");
                            userInput = input.nextLine();
                            switch (userInput) {
                                case "1":
                                    System.out.println("Add expense category");
                                    // add to ArrayList?
                                    break;
                                case "2":
                                    System.out.println("Edit an expense category");
                                    break;
                                case "3":
                                    System.out.println("Delete an expense category");
                                    break;
                                default:
                                    System.out.println("Invalid input, please try again");
                                    break;
                            }
                            break;
                    }
                    break;

                case "3":
                    System.out.println("Choose an alternative");
                    System.out.println("[1] Show all my transactions");
                    System.out.println("[2] Show only income transactions");
                    System.out.println("[3] Show only expense transactions");
                    userInput = input.nextLine();
                    switch (userInput) {
                        case "1":
                            System.out.println(allTransactions);
                            // show all transactions
                            break;
                        case "2":
                            System.out.println("This is your income transactions");
                            // show only income transactions
                            break;
                        case "3":
                            System.out.println("This is your expense transactions");
                            // show only expense transactions
                            break;
                        default:
                            System.out.println("Invalid input, please try again");
                            break;
                    }
                    break;

                case "4":
                    System.out.println("My BudgetTracker");
                    // visa budget, income - expenses
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
    }
}