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
    private final String fileName = "src/main/income.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // METHOD FOR SAVING TO JSON
    public void saveIncomeFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(incomeMap, fw);
        fw.close();
    }

    // METHOD FOR READING JSON
    public void readIncomeFile() {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            incomeMap = gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println(e.getMessage()); // skriver ut felet som kastats av file reader, om det kastats något fel
        }
    }

    // FOR LOOP LISTS ALL INCOME CATEGORIES
    // metod att använda i andra menyer där inkomstkategori skall väljas (add, delete, edit)
    public void incomeCategories() {
        int incomeIndex = 1;
        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println("[" + incomeIndex + "]" + " " + incomeCategory);
            incomeIndex++;
        }
    }

    // METHOD FOR LOOPING INCOMES BASED ON CATEGORY
    // för att se vilka inkomster som finns i vilken kategori
    public void showIncomeByCategory(EIncomeCategory category) {
        for (Income income : incomeMap.values()) {
            if (income.getIncomeCategory() == category) {
                System.out.println(income);
            }
        }
    }

    // METHOD FOR LISTING ALL INCOMES
    // listar alla inkomster som finns i min incomeMap
    public void showAllIncomes() {
        for (Income income : incomeMap.values()) {
            System.out.println(income);
        }
    }

    // METHOD FOR SHOWING AND RETURNING ALL INCOMES IN INCOME MAP
    // returnerar incomeMap, metoden används i "My Budget Tracker" för att räkna ut den totala summan av alla inkomster
    public List<Income> getAllIncomes() {
        List<Income> allIncomes = new ArrayList<>();
        for (Income income : incomeMap.values()) {
            allIncomes.add(income);
        }
        return allIncomes;
    }


    // METHOD FOR ADDING AN INCOME
    // för att lägga till namn och summa för en ny inkomst
    // felhantering med while loop och en try/catch runt input från user för att fånga felaktig input (text) för double
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
        // lagt till toString på LocalDate.now, lägger till dagens datum automagiskt
        Income income = new Income(name, LocalDate.now().toString(), amount, category);
        incomeMap.put(name, income);
        System.out.println("The income " + name + " has been successfully saved!");
    }


    // METHOD FOR REMOVING AN INCOME
    // felhantering med while loop och if-else runt user input för name för att endast kunna välja existerande inkomster
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

    // METHOD FOR EDITING AN INCOME
    // användaren får välja om det är namnet eller summan som skall ändras
    // felhantering med while loop och if-else för att endast kunna välja en existerande inkomst
    // felhantering med while loop och try-catch för att fånga felaktig input (text) från användaren
    public void editIncome(EIncomeCategory category) {
        String name;

        while (true) {
            System.out.println("");
            showIncomeByCategory(category);
            scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("Write the name of the income you want to edit: ");
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
                System.out.println("Please enter the new name of the income: ");
                String newName = scanner.nextLine();
                Income income = new Income(newName, oldIncome.getDate(), oldIncome.getAmount(), oldIncome.getIncomeCategory());
                incomeMap.remove(name);
                incomeMap.put(newName, income);
                break;
            case "2":
                double newAmount;

                while (true) {
                    scanner = new Scanner(System.in);
                    System.out.print("Please enter the new amount: ");
                    try {
                        newAmount = scanner.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input, please enter a number");
                    }
                }

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