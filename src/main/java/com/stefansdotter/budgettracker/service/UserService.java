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

        return new User(firstName, lastName, password);          // varför funkar det ej?

    }

    public User registerUser() {
        return null;
    }

    public User logIn() {
        return null;
    }

}