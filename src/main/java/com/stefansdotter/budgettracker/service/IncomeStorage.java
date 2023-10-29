package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.Income;
import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IncomeStorage {
    Scanner scanner = new Scanner(System.in);

    // MAP OF INCOMES
    private Map<String, Income> incomeMap;
    private String fileName = "src/main/income.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // SAVE TO JSON
    public void saveIncomeFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(incomeMap, fw);
        fw.close();
        System.out.println("Your changes to incomes has been saved");
    }

    // READ JSON
    public void readIncomeFile() {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            incomeMap = gson.fromJson(reader, type);
            System.out.println("Income list retrieved");
        } catch (IOException e) {
            System.out.println(e.getMessage()); // skriver ut felet som kastats av file reader, om det kastats något fel
        }
    }

    // FOR LOOP LISTS ALL INCOME CATEGORIES
    public void incomeCategories() {
        int incomeIndex = 1;
        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println(incomeIndex + " " + incomeCategory);
            incomeIndex++;
        }
    }

    // LOOPS INCOME BASED ON CATEGORY
    public void showIncomeByCategory(EIncomeCategory category) {
        for (Income income : incomeMap.values()) {
            if (income.getIncomeCategory() == category) {
                System.out.println(income);
            }
        }
    }

    // LISTS ALL INCOMES
    // prints all incomes one at the time
    public void showAllIncomes() {
        for (Income income : incomeMap.values()) {
            System.out.println(income);
        }
    }

    // GETS ALL INCOMES AS ARRAY LIST
    // returns incomeList
    public List<Income> getAllIncomes() {
        List<Income> allIncomes = new ArrayList<>();
        for (Income income : incomeMap.values()) {
            allIncomes.add(income);
        }
        return allIncomes;
    }


    // ADD INCOME
    // while loop och try/catch för att fånga felaktig input för double
    public void addIncome(EIncomeCategory category) {
        double amount;

        scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the income you want to add: ");
        String name = scanner.nextLine();

        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Please enter the amount of " + name);

            try {
                amount = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number");
            }
        }
        Income income = new Income(name, LocalDate.now().toString(), amount, category);
        incomeMap.put(name, income);
        System.out.println("The income " + name + " has been successfully saved!");
    }


    // REMOVE INCOME
    // if-else för att endast kunna nå existerande inkomster
    public void removeIncome(EIncomeCategory category) {
        String name;

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("What income do you want to remove?");
            showIncomeByCategory(category);
            name = scanner.nextLine();

            if (incomeMap.containsKey(name)) {
                break;
            } else {
                System.out.println("Could not find the income " + name + " , please try again");
                System.out.println("");
            }
        }
        incomeMap.remove(name);
        System.out.println("The income " + name + " has been successfully deleted!");
    }

    // EDIT INCOME
    // if-else för att endast kunna nå existerande inkomster
    public void editIncome(EIncomeCategory category) {
        String name;

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("What income do you want to edit?");
            showIncomeByCategory(category);
            name = scanner.nextLine();

            if (incomeMap.containsKey(name)) {
                break;
            } else {
                System.out.println("Could not find the income " + name + " , please try again");
                System.out.println("");
            }
        }

        Income oldIncome = incomeMap.get(name);
        System.out.println("What would you like to edit?");
        System.out.println("[1] Name");
        System.out.println("[2] Amount");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Please enter the new name");
                String newName = scanner.nextLine();
                Income income = new Income(newName, oldIncome.getDate(), oldIncome.getAmount(), oldIncome.getIncomeCategory());
                incomeMap.remove(name);
                incomeMap.put(newName, income);
                break;
            case "2":
                System.out.println("Please enter the new amount");
                double newAmount = scanner.nextDouble();
                Income replaceIncome = new Income(name, oldIncome.getDate(), newAmount, oldIncome.getIncomeCategory());      // byter ut amount till NewAmount = user input
                incomeMap.replace(name, replaceIncome);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
        System.out.println("The income " + name + " has been successfully edited!");
    }
}