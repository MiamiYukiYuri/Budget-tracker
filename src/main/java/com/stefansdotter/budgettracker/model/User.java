package com.stefansdotter.budgettracker.model;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String password;


    // Konstruktor för att skapa en ny user
    public User(int id, String firstName, String lastName, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
