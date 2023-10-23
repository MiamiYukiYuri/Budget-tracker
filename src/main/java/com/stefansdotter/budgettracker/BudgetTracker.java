package com.stefansdotter.budgettracker;

import com.stefansdotter.budgettracker.service.IncomeStorage;
import com.stefansdotter.budgettracker.service.IncomeMenuService;

import java.io.IOException;

public class BudgetTracker {

    public static void main(String[] args) throws IOException {

        IncomeStorage iStorage = new IncomeStorage();
        iStorage.readIncomeFile();

        //     Test   incomeMenu
        IncomeMenuService incomeMenuService = new IncomeMenuService();
        incomeMenuService.incomeMenu();


      // Income income = new Income("Barnbidrag", "231023", 500, EIncomeCategory.BENEFITS);
      // Income income2 = new Income("Lön", "120923", 20000, EIncomeCategory.SALARY);

       // visar alla inkomster
       iStorage.showAllIncomes();

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