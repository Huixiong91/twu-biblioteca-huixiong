package com.twu.biblioteca;

public class Account {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public Account(String username, String password, String name, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void displayInfo() {
        System.out.println("Your information");
        System.out.println("Name: " + getName() + "     Email: " + getEmail() + "      Phone Number: " + getPhoneNumber());
    }
}
