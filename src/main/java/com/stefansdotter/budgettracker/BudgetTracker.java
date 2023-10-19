package com.stefansdotter.budgettracker;

import com.stefansdotter.budgettracker.model.enums.EIncomeCategory;

import java.util.Scanner;

public class BudgetTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vänligen välj en inkomstkälla");

        // En int för att visa användaren en lista av våra kategorier i Enumet
        int incomeIndex = 1;

        // Loopa igenom alla incomeCategories och skriv ut dem som ett val
        // för varje incomeCategory ("variabelnamn för loopen") så skall varje indexplats i Enumet skrivas ut

        for (EIncomeCategory incomeCategory : EIncomeCategory.values()) {
            System.out.println(incomeIndex + " " + incomeCategory); // siffran + namnet på kategorin
            incomeIndex++;  // plussar på en siffra per iteration  (1, 2, 3..)
        }
        int choice = scanner.nextInt();
        System.out.println("Du valde " + choice);
    }


            /*

        Menu menu = new Menu();
        menu.menu();

        UserService logInService = new UserService();
        User firstUser = logInService.createUser();
        System.out.println("Welcome " + firstUser.getFirstName() + " " + firstUser.getLastName() + ".");

        User secondUser = logInService.createUser();
        System.out.println("Welcome " + secondUser.getFirstName() + " " + secondUser.getLastName() + ".");

         */


}