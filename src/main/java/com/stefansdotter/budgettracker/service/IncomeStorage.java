package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.Income;
import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.io.*;
import java.lang.reflect.Type;
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
    public void saveIncome(Income income) throws IOException {
        incomeList.put(income.getName(), income);
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(incomeList, fw);
        fw.close();
        System.out.println("Your changes has been saved");
    }


    // READ JSON
    public void readIncomeFile() throws IOException {
        Type type = new TypeToken<Map<String, Income>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        incomeList = gson.fromJson(reader, type);

        System.out.println("Income list retrieved");
    }


    // FOR LOOP TO LIST ALL INCOME CATEGORIES
    public void incomeArray() {
        int incomeIndex = 1;
        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println(incomeIndex + " " + incomeCategory);
            incomeIndex++;
        }
    }


    // FOR LOOP TO LIST ALL INCOMES
    public void showAllIncomes() {
        for (Income income : incomeList.values()) {
            System.out.println(income);
        }
    }


    // ADD INCOME   - det smäller, vad är det som är fel?
    public void addIncome(EIncomeCategory category) {
        System.out.print("Please enter the name of the income you want to add: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the amount: ");
        double amount = scanner.nextDouble();
        Income income = new Income(name, "date", amount, category);
        incomeList.put(name, income);
        addIncomeToArray(income);
    }

    // ADDS INCOME TO MAP/ARRAY LIST
    public void addIncomeToArray(Income income) {
        incomeList.put(income.getName(), income);
        System.out.println("Income saved!");
    }


    // REMOVE INCOME   - EJ LÖST!
    public void removeIncome(EIncomeCategory category) {
        String name = scanner.nextLine();
        System.out.println("What income do you want to remove?");
        showAllIncomes();
        incomeList.remove(name);
        System.out.println("The income " + name + " has now been removed");
    }



    // EDIT INCOME      -  EJ LÖST
    public void editIncome(EIncomeCategory Income) {
    }
}