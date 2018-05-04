package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    List<String> mainMenuOptions = new ArrayList<String>();
    Library lib;

    public BibliotecaApp() {
        // init
        lib = new Library();
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
        lib.promptLogin();
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

    public void quit() {
        System.out.println("Bye bye!");
        System.exit(0);
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
}
