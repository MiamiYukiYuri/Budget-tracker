package com.stefansdotter.budgettracker.model;

public class User {
    private String firstName;
    private String lastName;
    private String password;

    public User(String firstName, String lastName, String password) {
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
