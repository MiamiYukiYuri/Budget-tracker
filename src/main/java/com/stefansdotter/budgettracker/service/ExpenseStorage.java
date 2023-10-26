package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.Expense;
import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class ExpenseStorage {
    Scanner scanner = new Scanner(System.in);
    private int eIndex = 1;


    // MAP OF EXPENSES
    private Map<String, Expense> expenseList;
    private String fileName = "src/main/expense.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // SAVE TO JSON
    public void saveExpenseFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(expenseList, fw);
        fw.close();
        System.out.println("Your changes has been saved");
    }


    // READ JSON
    public void readExpenseFile() {
        Type type = new TypeToken<Map<String, Expense>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            expenseList = gson.fromJson(reader, type);
            System.out.println("Expenses retrieved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // FOR LOOP TO LIST ALL EXPENSE CATEGORIES
    public void expenseArray() {
        int expenseIndex = 1;
        for (EExpenseCategory expenseCategory : EExpenseCategory.values()) {
            System.out.println(expenseIndex + " " + expenseCategory);
            eIndex++;
        }
    }

    // FOR LOOP TO LIST ALL EXPENSES
    public void showAllExpenses() {
        for (Expense expense : expenseList.values()) {
            System.out.println(expense);
        }
    }

    // ADDS EXPENSE TO MAP/ARRAY LIST
    public void addExpenseToArray(Expense expense) {
        expenseList.put(expense.getName(), expense);
        System.out.println("Expense saved!");
    }

    // ADD EXPENSE
    public void addExpense(EExpenseCategory category) {
        scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the expense you want to add: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the amount: ");
        double amount = scanner.nextDouble();
        Expense expense = new Expense(name, LocalDate.now().toString(), amount, category);
        expenseList.put(name, expense);
        System.out.println("The expense " + name + " has been successfully added!");
    }

    // REMOVE EXPENSE
    public void removeExpense() {
        scanner = new Scanner(System.in);
        System.out.println("What expense do you want to remove?");
        showAllExpenses();
        String name = scanner.nextLine();
        expenseList.remove(name);
        System.out.println("The expense " + name + " has been successfully deleted!");

    }

    // EDIT EXPENSE
    public void editExpense() {
        scanner = new Scanner(System.in);
        System.out.println("What expense do you want to edit?");

        for (Expense expense : expenseList.values()) {
            System.out.println(expense.getName());
        }

        String name = scanner.nextLine();
        Expense oldExpense = expenseList.get(name);
        System.out.println("What would you like to edit?");
        System.out.println("[1] Name");
        System.out.println("[2] Amount");
        String userInput = scanner.nextLine();


        switch (userInput) {
            case "1":
                System.out.println("Please enter the new name");
                String newName = scanner.nextLine();
                Expense expense = new Expense(newName, oldExpense.getDate(), oldExpense.getAmount(), oldExpense.geteCategory());
                expenseList.remove(name);
                expenseList.put(newName, expense);
                break;
            case "2":
                System.out.println("Please enter the new amount");
                double newAmount = scanner.nextDouble();
                Expense replaceExpense = new Expense(name, oldExpense.getDate(), newAmount, oldExpense.geteCategory());      // byter ut amount till NewAmount = user input
                expenseList.replace(name, replaceExpense);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
        System.out.println("The expense " + name + " has been successfully edited!");
    }
}