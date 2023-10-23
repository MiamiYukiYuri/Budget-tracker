package com.stefansdotter.budgettracker.service;

import com.stefansdotter.budgettracker.model.User;

import java.util.Scanner;

public class UserService {
    public User createUser() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your first name ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter your last name ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter your password ");
        String password = scanner.nextLine();

        return new User(firstName, lastName, password);
    }


    // OBS skapa user.json

    public User registerUser() {
        return null;
    }

    public User logIn() {
        return null;
    }

}

/*
        UserService logInService = new UserService();
        User firstUser = logInService.createUser();
        System.out.println("Welcome " + firstUser.getFirstName() + " " + firstUser.getLastName() + ".");

        User secondUser = logInService.createUser();
        System.out.println("Welcome " + secondUser.getFirstName() + " " + secondUser.getLastName() + ".");
 */