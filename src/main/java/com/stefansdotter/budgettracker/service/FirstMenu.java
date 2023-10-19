package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class FirstMenu {
    public void menu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Please choose from the alternatives below");
        System.out.println("[1] My incomes");
        System.out.println("[2] My expenses");
        System.out.println("[3] Show my transactions");
        System.out.println("[4] My BudgetTracker");
        System.out.println("[5] Exit program");

        String menuChoice = scanner.nextLine();
    }
}