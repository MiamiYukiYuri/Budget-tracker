package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.Expense;
import com.stefansdotter.budgettracker.model.enums.EExpenseCategory;

import java.io.*;
import java.lang.reflect.Type;
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
        public void saveExpense(Expense expense) throws IOException {
            expenseList.put(expense.getName(), expense);
            FileWriter fw = new FileWriter(new File(fileName));
            gson.toJson(expenseList, fw);
            fw.close();
            System.out.println("Your changes have been saved");
        }


        // READ JSON

        public void readExpenseFile() {
            Type type = new TypeToken<Map<Expense, Expense>>() {
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


        // ADD EXPENSE      // smäller, kopierat från Income
        public void addExpense (EExpenseCategory category) {
            System.out.print("Please enter the name of the expense you want to add: ");
            String name = scanner.nextLine();
            System.out.print("Please enter the amount: ");
            double amount = scanner.nextDouble();
            Expense expense = new Expense(name, "date", amount, category);
            expenseList.put(name, expense);
            addExpenseToArray(expense);
        }


        // REMOVE EXPENSE   - EJ LÖST!
        public void removeExpense(EExpenseCategory category) {
            String name = scanner.nextLine();
            System.out.println("");
            expenseList.remove(name);
            // nåt bättre sätt att komma åt expenses, id?
        }


        // EDIT EXPENSE     - EJ LÖST
        public void editExpense(EExpenseCategory category) {
            System.out.println("");
        }


    }