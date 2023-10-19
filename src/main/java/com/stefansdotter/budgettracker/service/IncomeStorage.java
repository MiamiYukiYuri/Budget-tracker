package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.Income;
import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.util.ArrayList;
import java.util.Scanner;

public class IncomeStorage {

    private EIncomeCategory incomeCategory;       // hämtar enum EIncomeCategory -> incomeCategory

    ArrayList<Income> incomeList = new ArrayList<>();       // ny ArrayList för inkomster
    Scanner scanner = new Scanner(System.in);

    // metod för att loopa igenom enumet??
    public void showIncomeList() {
        for (EIncomeCategory incomeList : EIncomeCategory.values()) {
            System.out.println(incomeList);
        }
    }

    // visar alla inkomster i listan
    public void allIncome() {
        for (Income income : incomeList) {
            System.out.println(income);
        }
    }

    // ADD INCOME
    public void addIncome(Income income) {
        String userInput = scanner.nextLine();
        System.out.print("Please enter the income that you want to add to this category: ");
        incomeList.add(income);
    }

    // REMOVE INCOME
    public void removeIncome(Income income) {
        String userInput = scanner.nextLine();
        System.out.println("What income do you want to edit?");
        incomeList.remove(userInput);
    }


    // MENY FÖR ATT ADDERA INKOMST PER KATEGORI
    public void incomeMenu() {
        int incomeIndex = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Please chose an income category");

        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println(incomeIndex + " " + incomeCategory);
            incomeIndex++;
        }

        String userInput = input.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("You've chosen the category Salary");
                System.out.print("Please enter the income that you want to add to this category: ");
                String name = scanner.nextLine();
                System.out.print("Please enter the amount: ");
                double amount = scanner.nextDouble();
                Income income = new Income(name, amount, EIncomeCategory.SALARY);
                incomeList.add(income);
                System.out.println("The income " + income + " has been added to the category Salary");
                break;

            case "2":
                System.out.println("You've chosen the income category Child benefit");
                System.out.print("Please enter the income that you want to add to this category: ");
                userInput = scanner.nextLine();
                //incomeList.add(userInput); // whyyyy????
                System.out.println("The income " + userInput + " has been added to the category Child benefit");
                break;

            case "3":
                System.out.println("You've chosen the income category Other");
                System.out.print("Please enter the income that you want to add to this category: ");
                userInput = scanner.nextLine();
                System.out.println("The income " + userInput + " has been added to the category Other");
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }
}


// EDIT INCOME
//public void editIncome(String income) {
//  incomeList.set(income);


// SAVE TO FILE


// READ FILE


// Den här klassen ska ansvara för att spara till fil, läsa in fil, lista alla inkomster,
//lägga till, uppdatera eller ta bort en inkomst.