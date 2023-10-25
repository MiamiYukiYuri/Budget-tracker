package com.stefansdotter.budgettracker;

import com.stefansdotter.budgettracker.service.ExpenseStorage;
import com.stefansdotter.budgettracker.service.IncomeStorage;

import java.io.IOException;

public class BudgetTracker {

    public static void main(String[] args) throws IOException {

        IncomeStorage iStorage = new IncomeStorage();
        ExpenseStorage eStorage = new ExpenseStorage();


        /*
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
        
         */



       // spara till JSON när programmet avslutas
      // iStorage.saveIncome(income);





            /*
        UserService logInService = new UserService();
        User firstUser = logInService.createUser();
        System.out.println("Welcome " + firstUser.getFirstName() + " " + firstUser.getLastName() + ".");

        User secondUser = logInService.createUser();
        System.out.println("Welcome " + secondUser.getFirstName() + " " + secondUser.getLastName() + ".");

         */


    }
}