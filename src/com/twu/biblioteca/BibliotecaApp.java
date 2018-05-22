package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library lib;

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
            case 2: lib.checkoutBook();
            break;
            case 3: lib.returnBook();
            break;
            case 4: lib.listMovie();
            break;
            case 5: lib.checkoutMovie();
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
}
