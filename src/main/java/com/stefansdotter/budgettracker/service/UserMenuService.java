package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class UserMenuService {

    UserStorage userStorage;
    Scanner scanner;
    String userMenu = """
                 ______________________________                        
                |  [1] Log in                  |\\
                |  [2] Register new user       | |    
                |______________________________| |     
                 \\______________________________\\|
                 """;

    public UserMenuService (UserStorage userStorage) {
        this.userStorage = userStorage;
    }

     public void firstMenu() {
        boolean isRunning = true;
         scanner = new Scanner(System.in);
         System.out.println(userMenu);

         while (isRunning) {
             String userInput = scanner.nextLine();

             switch (userInput) {
                 case "1":
                     logInMenu();
                     isRunning = false;
                     break;
                 case "2":
                     userStorage.createUser();
                     isRunning = false;
                     break;
                 default:
                     System.out.println("Invalid input, please try again");
                     break;
             }
         }

     }

    public void logInMenu() {

        System.out.print("Please enter your user name: ");
        String userName = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

    }

}
