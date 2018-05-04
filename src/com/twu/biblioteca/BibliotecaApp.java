package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    List<Account> accounts = new ArrayList<Account>();
    List<String> mainMenuOptions = new ArrayList<String>();
    Account loggedInAccount;
    Library lib;

    public BibliotecaApp() {
        // init
        lib = new Library();

        Account account_1 = new Account("111-1111", "password1", "name1", "email1@gmail.com", "987654321");
        Account account_2= new Account("222-2222", "password2", "name2", "email2@gmail.com", "123456789");
        Account account_3 = new Account("333-3333", "password3", "name3", "email3@gmail.com", "33334444");
        accounts.add(account_1);
        accounts.add(account_2);
        accounts.add(account_3);

        mainMenuOptions.add("List Books");
        mainMenuOptions.add("Checkout Book");
        mainMenuOptions.add("Return Book");
        mainMenuOptions.add("List Movies");
        mainMenuOptions.add("Checkout Movie");
        mainMenuOptions.add("Display your info");
        mainMenuOptions.add("Quit");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca-HuiXiong!");
        BibliotecaApp app = new BibliotecaApp();
        app.promptLogin();
        app.mainMenu();
    }

    public void mainMenu() {
        int selectedOption;
        do {
            System.out.println("\n========== Main menu ==========");
            System.out.println("========== Select an option ==========");
            for (int i = 1; i <= mainMenuOptions.size(); i++) {
                System.out.println(i + ": " + mainMenuOptions.get(i-1));
            }

            selectedOption = getMainMenuSelectedOption();
            executeSelectedMainMenuOption(selectedOption);

        }while(true);
    }

    public void promptLogin() {
        System.out.println("Please Login");
        String username;
        String password;
        boolean triedOnce = false;
        do {
            if (triedOnce) {
                System.out.println("Invalid Credentials!");
            }
            triedOnce = true;
            System.out.print("Enter your username: ");
            Scanner scan = new Scanner(System.in);
            username = scan.nextLine();
            System.out.print("Enter your password: ");
            password = scan.nextLine();
        }while(!isValidCredentials(username, password));
        System.out.println("Successfully logged in as " + username);
        for (Account acc : accounts) {
            if ((acc.getUsername().equals(username)) && (acc.getPassword().equals(password))) {
                loggedInAccount = acc;
            }
        }
    }

    private boolean isValidCredentials(String username, String password) {
        for (Account acc : accounts) {
            if ((acc.getUsername().equals(username)) && (acc.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    public int getMainMenuSelectedOption() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        while ((i < 1) || (i > mainMenuOptions.size())) {
          System.out.println("Invalid option, please select again");
          i = scan.nextInt();
        }
        return i;
    }

    public void executeSelectedMainMenuOption(int selectedOption) {
        switch (selectedOption) {
            case 1: listBook();
            break;
            case 2: checkoutBook();
            break;
            case 3: returnBook();
            break;
            case 4: listMovie();
            break;
            case 5: checkoutMovie();
            break;
            case 6: displayUserInfo();
            break;
            case 7: quit();
            break;
        }
    }

    public void quit() {
        System.out.println("Bye bye!");
        System.exit(0);
    }

    public void displayUserInfo() {
        loggedInAccount.displayInfo();
    }

    public void checkoutBook() {
        System.out.println("Enter the book title that you wish to checkout: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        lib.checkoutBook(title);
    }

    public void returnBook() {
        System.out.println("Enter the book title that you wish to return: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        lib.returnBook(title);
    }

    public void checkoutMovie() {
        System.out.println("Enter the movie name that you wish to checkout: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        lib.checkoutMovie(title);
    }

    public void listBook() {
        lib.listBook();
    }

    public void listMovie() {
        lib.listMovie();
    }
}
