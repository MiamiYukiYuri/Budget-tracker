package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.Expense;
import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseStorage {
    Scanner scanner = new Scanner(System.in);

    // MAP OF EXPENSES
    private Map<String, Expense> expenseMap;
    private String fileName = "src/main/expense.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // SAVE TO JSON
    public void saveExpenseFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(expenseMap, fw);
        fw.close();
        System.out.println("Your changes to expenses has been saved");
    }


    // READ JSON
    public void readExpenseFile() {
        Type type = new TypeToken<Map<String, Expense>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            expenseMap = gson.fromJson(reader, type);
            System.out.println("Expense list retrieved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // FOR LOOP TO LIST ALL EXPENSE CATEGORIES
    public void expenseCategoryArray() {
        int expenseIndex = 1;
        for (EExpenseCategory expenseCategory : EExpenseCategory.values()) {
            System.out.println(expenseIndex + " " + expenseCategory);
            expenseIndex++;
        }
    }

    // SHOWS EXPENSES BY THEIR CATEGORY
    public void showExpenseByCategory(EExpenseCategory category) {
        for (Expense expense : expenseMap.values()) {
            if (expense.getExpenseCategory() == category) {
                System.out.println(expense);
            }
        }
    }


    // FOR LOOP TO LIST ALL EXPENSES
    public void showAllExpenses() {
        for (Expense expense : expenseMap.values()) {
            System.out.println(expense);
        }
    }

    // SHOWS ALL EXPENSES
    public List<Expense> getAllExpenses() {
     List<Expense> allExpenses = new ArrayList<>();
     for (Expense expense : expenseMap.values()) {
         allExpenses.add(expense);
     }
     return allExpenses;
    }



    // ADD EXPENSE
    // while loop och try/catch för att fånga felaktig input för double
    public void addExpense(EExpenseCategory category) {
        double amount;

        scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the expense you want to add: ");
        String name = scanner.nextLine();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the amount of " + name);

            try {
                amount = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number");
            }
        }

        Expense expense = new Expense(name, LocalDate.now().toString(), amount, category);
        expenseMap.put(name, expense);
        System.out.println("The expense " + name + " has been successfully added!");
    }

    // REMOVE EXPENSE
    public void removeExpense(EExpenseCategory category) {
        String name;

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("What expense do you want to remove?");
            showExpenseByCategory(category);
            name = scanner.nextLine();

            if (expenseMap.containsKey(name)) {
                break;
            } else {
                System.out.println("Could not find the expense " + name + " , please try again");
                System.out.println("");
            }
        }

        expenseMap.remove(name);
        System.out.println("The expense " + name + " has been successfully deleted!");
    }


    // EDIT EXPENSE
    public void editExpense(EExpenseCategory category) {
        String name;

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("What expense do you want to edit?");
            showExpenseByCategory(category);
            name = scanner.nextLine();

            if (expenseMap.containsKey(name)) {
                break;
            } else {
                System.out.println("Could not find the expense " + name + " , please try again");
                System.out.println("");
            }
        }

        Expense oldExpense = expenseMap.get(name);
        System.out.println("What would you like to edit?");
        System.out.println("[1] Name");
        System.out.println("[2] Amount");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Please enter the new name");
                String newName = scanner.nextLine();
                Expense expense = new Expense(newName, oldExpense.getDate(), oldExpense.getAmount(), oldExpense.getExpenseCategory());
                expenseMap.remove(name);
                expenseMap.put(newName, expense);
                break;
            case "2":
                System.out.println("Please enter the new amount");
                double newAmount = scanner.nextDouble();
                Expense replaceExpense = new Expense(name, oldExpense.getDate(), newAmount, oldExpense.getExpenseCategory());      // byter ut amount till NewAmount = user input
                expenseMap.replace(name, replaceExpense);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
        System.out.println("The expense " + name + " has been successfully edited!");
    }
}