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

    // MAP OF USERS
    // basen för att skapa ny user file
    private Map<Integer, User> userMap = new HashMap<>();
    private String fileName = "src/main/users.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void createUser() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your first name ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter your last name ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter your password ");
        String password = scanner.nextLine();

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


    public User registerUser() {
        return null;
    }

    public User logIn() {
        return null;
    }

}