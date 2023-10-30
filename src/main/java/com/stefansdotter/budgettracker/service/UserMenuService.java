package com.stefansdotter.budgettracker.service;

import java.util.Scanner;

public class UserMenuService {

    UserStorage userStorage;
    Scanner scanner;
    String userMenu = """
                 ______________________________                        
                |  Hi! What do you want to do? |\\
                |                              | |
                |  [1] Log in                  | |
                |  [2] Register new user       | |    
                |______________________________| |     
                 \\______________________________\\|
                 """;

    public UserMenuService (UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    // METHOD FOR LOGGING IN AND CREATING A NEW USER
    // switch med ett case för respektive menyval
    // OBS inte "kopplad" till programmet än, men tänker jobba vidare med det
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
