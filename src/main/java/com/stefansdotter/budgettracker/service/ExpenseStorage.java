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


    // METHOD FOR SAVING TO JSON
    public void saveExpenseFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(expenseMap, fw);
        fw.close();
    }


    // METHOD FOR READING JSON
    public void readExpenseFile() {
        Type type = new TypeToken<Map<String, Expense>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            expenseMap = gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // METHOD FOR LOOPING ALL EXPENSE CATEGORIES
    // metoden används i menyer där utgiftskategori skall väljas (add, delete, edit)
    public void expenseCategories() {
        int expenseIndex = 1;
        for (EExpenseCategory expenseCategory : EExpenseCategory.values()) {
            System.out.println("[" + expenseIndex + "]" + " " + expenseCategory);
            expenseIndex++;
        }
    }

    // METHOD FOR SHOWING EXPENSES BY THEIR CATEGORY
    // för att tydligt kunna se vilka utgifter som finns i vilken kategori
    public void showExpenseByCategory(EExpenseCategory category) {
        for (Expense expense : expenseMap.values()) {
            if (expense.getExpenseCategory() == category) {
                System.out.println(expense);
            }
        }
    }


    // METHOD FOR LISTING ALL EXPENSES
    // loopar alla utgifter som finns i min expenseMap
    public void showAllExpenses() {
        for (Expense expense : expenseMap.values()) {
            System.out.println(expense);
        }
    }

    // METHOD FOR SHOWING AND RETURNING ALL EXPENSES IN EXPENSE MAP
    // returnerar expenseMap, metoden används i "My Budget Tracker" för att räkna ut den totala summan av alla utgifter
    public List<Expense> getAllExpenses() {
        List<Expense> allExpenses = new ArrayList<>();
        for (Expense expense : expenseMap.values()) {
            allExpenses.add(expense);
        }
        return allExpenses;
    }


    // METHOD FOR ADDING AN EXPENSE
    // för att lägga till namn och summa för en ny utgift
    // felhantering med while loop och en try/catch runt input från user för att fånga felaktig input för amount/double
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

    // METHOD FOR REMOVING AN EXPENSE
    // felhantering med while loop och if-else runt user input för name för att endast kunna välja existerande utgifter
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


    // METHOD FOR EDITING AN EXPENSE
    // användaren får välja om det är namnet eller summan som skall ändras
    // felhantering med while loop och if-else för att endast kunna välja en existerande inkomst
    // felhantering med while loop och try-catch runt användarens input för att ändra summan för en utgift, fångar felaktig input (text) från användaren
    public void editExpense(EExpenseCategory category) {
        String name;

        while (true) {
            System.out.println();
            showExpenseByCategory(category);
            scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("Write the name of the expense you want to edit: ");
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
                System.out.println("Please enter the new name for this expense: ");
                String newName = scanner.nextLine();
                Expense expense = new Expense(newName, oldExpense.getDate(), oldExpense.getAmount(), oldExpense.getExpenseCategory());
                expenseMap.remove(name);
                expenseMap.put(newName, expense);
                break;
            case "2":
                double newAmount;
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Please enter the new amount of " + name);
                    try {
                        newAmount = scanner.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input, please enter a number");
                    }
                }
                // byter ut amount till NewAmount = user input
                Expense replaceExpense = new Expense(name, oldExpense.getDate(), newAmount, oldExpense.getExpenseCategory());
                expenseMap.replace(name, replaceExpense);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
        System.out.println("The expense " + name + " has been successfully edited!");
    }
}