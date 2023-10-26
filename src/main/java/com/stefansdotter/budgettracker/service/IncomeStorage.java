package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.Income;
import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class IncomeStorage {
    private EIncomeCategory incomeCategory;
    Scanner scanner = new Scanner(System.in);


    // MAP OF INCOMES
    private Map<String, Income> incomeList;
    private String fileName = "src/main/income.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // SAVE TO JSON
    public void saveIncomeFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(incomeList, fw);
        fw.close();
        System.out.println("Your changes has been saved");
    }


    // READ JSON
    public void readIncomeFile() {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            incomeList = gson.fromJson(reader, type);
            System.out.println("Income list retrieved");
        } catch (IOException e) {
            System.out.println(e.getMessage()); // skriver ut felet som kastats av file reader, om det kastats något fel
        }
    }


    // FOR LOOP LISTS ALL INCOME CATEGORIES
    public void incomeArray() {
        int incomeIndex = 1;
        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println(incomeIndex + " " + incomeCategory);
            incomeIndex++;
        }
    }


    // FOR LOOP LISTS ALL INCOMES
    public void showAllIncomes() {
        for (Income income : incomeList.values()) {
            System.out.println(income);
        }
    }


    // for each loop för varje kategori, showAllOtherIncome


    // ADD INCOME
    public void addIncome(EIncomeCategory category) {
        scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the income you want to add: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the amount: ");
        double amount = scanner.nextDouble();
        Income income = new Income(name, LocalDate.now().toString(), amount, category);
        incomeList.put(name, income);
        System.out.println("The income " + name + " has been successfully saved!");
    }


    // REMOVE INCOME
    public void removeIncome() {
        scanner = new Scanner(System.in);
        System.out.println("What income do you want to remove?");
        showAllIncomes();
        String name = scanner.nextLine();
        incomeList.remove(name);
        System.out.println("The income " + name + " has been successfully deleted!");
    }


    public void editIncome() {
        scanner = new Scanner(System.in);
        System.out.println("What income do you want to edit?");

        for (Income income : incomeList.values()) {
            System.out.println(income.getName());
        }

        String name = scanner.nextLine();
        Income oldIncome = incomeList.get(name);
        System.out.println("What would you like to edit?");
        System.out.println("[1] Name");
        System.out.println("[2] Amount");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Please enter the new name");
                String newName = scanner.nextLine();
                Income income = new Income(newName, oldIncome.getDate(), oldIncome.getAmount(), oldIncome.getIncomeCategory());
                incomeList.remove(name);
                incomeList.put(newName, income);
                break;
            case "2":
                System.out.println("Please enter the new amount");
                double newAmount = scanner.nextDouble();
                Income replaceIncome = new Income(name, oldIncome.getDate(), newAmount, oldIncome.getIncomeCategory());      // byter ut amount till NewAmount = user input
                incomeList.replace(name, replaceIncome);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }

        System.out.println("The income " + name + " has been successfully edited!");
    }
}