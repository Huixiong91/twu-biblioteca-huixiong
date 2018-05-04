package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    Library lib;

    BibliotecaApp() {
        // init
        lib = new Library();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca-HuiXiong!");
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }

    private void start() {
        lib.promptLogin();
        while(true) {
            executeSelectedMainMenuOption(MainMenu.display());
        }
    }

    private void executeSelectedMainMenuOption(int selectedOption) {
        switch (selectedOption) {
            case 1: lib.listBook();
            break;
            case 2: checkoutBook();
            break;
            case 3: returnBook();
            break;
            case 4: lib.listMovie();
            break;
            case 5: checkoutMovie();
            break;
            case 6: lib.loggedInAccount.displayInfo();
            break;
            case 7: quit();
            break;
        }
    }

    private void quit() {
        System.out.println("Bye bye!");
        System.exit(0);
    }

    void checkoutBook() {
        System.out.println("Enter the book title that you wish to checkout: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        lib.checkoutBook(title);
    }

    private void returnBook() {
        System.out.println("Enter the book title that you wish to return: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        lib.returnBook(title);
    }

    void checkoutMovie() {
        System.out.println("Enter the movie name that you wish to checkout: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        lib.checkoutMovie(title);
    }
}
