package com.stefansdotter.budgettracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stefansdotter.budgettracker.model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserStorage {

    // tanken är att jobba vidare med users och log in service så att en användare endast ska kunna logga in med sitt användarnamn och lösenord
    // samt att varje användare bara kan se sin egen Budget Tracker
    // lägga till funktion för att radera användare


    // MAP OF USERS
    private Map<Integer, User> userMap = new HashMap<>();
    private String fileName = "src/main/users.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // METHOD FOR CREATING A NEW USER
    // i nuläget är inte funktionen kopplad till programmet, utan bara "for show"
    public void createUser() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter your password ");
        String password = scanner.nextLine();

        // ökar anal nycklar i userMap med +1 för varje ny user
        int userId = userMap.size() + 1;
        User newUser = new User(userId, firstName, lastName, password);
        userMap.put(userId, newUser);
    }


    // METHOD FOR SAVING TO JSON
    public void saveUserFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(userMap, fw);
        fw.close();
    }

    // METHOD FOR READING JSON
    public void readUserFile() {
        Type type = new TypeToken<Map<Integer, User>>() {
        }.getType();
        try {
            Reader reader = new FileReader(new File(fileName));
            userMap = gson.fromJson(reader, type);
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage()); // skriver ut felet som kastats av file reader, om det kastats något fel
        }
    }
}