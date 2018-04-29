package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    List<Book> books = new ArrayList<Book>();
    List<String> mainMenuOptions = new ArrayList<String>();

    public BibliotecaApp() {
        // init
        Book book_1 = new Book("Book 1", "Mr Lee", "2004");
        Book book_2 = new Book("Book 2", "James Cook", "2011");
        Book book_3 = new Book("Book 3", "Peter Ang", "2015");
        books.add(book_1);
        books.add(book_2);
        books.add(book_3);
        mainMenuOptions.add("List Books");
        mainMenuOptions.add("Checkout Book");
        mainMenuOptions.add("Return Book");
        mainMenuOptions.add("Quit");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca-HuiXiong!");
        BibliotecaApp app = new BibliotecaApp();
        app.mainMenu();
    }

    public void mainMenu() {
//        System.out.println("========== Main menu ==========");
//        System.out.println("========== Select an option ==========");
//        for (int i = 1; i <= mainMenuOptions.size(); i++) {
//            System.out.println(i + ": " + mainMenuOptions.get(i-1));
//        }
//
//        int selectedOption = getMainMenuSelectedOption();
//        while (selectedOption != mainMenuOptions.size()) {
//            executeSelectedMainMenuOption(selectedOption);
//            System.out.println("========== Main menu ==========");
//            System.out.println("========== Select an option ==========");
//            for (int i = 1; i <= mainMenuOptions.size(); i++) {
//                System.out.println(i + ": " + mainMenuOptions.get(i-1));
//            }
//            selectedOption = getMainMenuSelectedOption();
//        }
//        quit();

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
            case 4: quit();
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
        for (Book b : books) {
            if (b.title.equals(title)) {
                if (b.isCheckedOut()) {
                    System.out.println("That book is not available.");
                }
                else {
                    b.isCheckedOut = true;
                    System.out.println("Thank you! Enjoy the book.");
                }
//                mainMenu();
                return;
            }
        }
        System.out.println("That book is not available.");
//        mainMenu();
    }

    public void returnBook() {
        System.out.println("Enter the book title that you wish to return: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        for (Book b : books) {
            if (b.title.equals(title)) {
                if (!b.isCheckedOut()) {
                    System.out.println("That is not a valid book to return.");
                }
                else {
                    b.isCheckedOut = false;
                    System.out.println("Thank you for returning the book.");
                }
                mainMenu();
                return;
            }
        }
        System.out.println("That is not a valid book to return.");
        mainMenu();
    }

    public void listBook() {
        System.out.println("List of books available");
        int index = 1;
        String s1 = String.format("   %-25s %-25s %-25s", "Title", "Author", "Year Published");
        System.out.println(s1);
        for (Book book : books){
            if (!book.isCheckedOut) {
                String bookDetail = String.format("%s: %-25s %-25s %-25s", index++, book.title, book.author, book.yearPublished);
                System.out.println(bookDetail);
            }
        }
//        mainMenu();
    }

//    public void printBookDetail(Book b) {
//        System.out.println("Author: " + b.author + " Year Published: " + b.yearPublished);
//    }

    public class Book {
        String title;
        String author;
        String yearPublished;
        boolean isCheckedOut;

        public Book(String title, String author, String yearPublished) {
            this.title = title;
            this.author = author;
            this.yearPublished = yearPublished;
            this.isCheckedOut = false;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getYearPublished() {
            return yearPublished;
        }

        public void setYearPublished(String yearPublished) {
            this.yearPublished = yearPublished;
        }

        public boolean isCheckedOut() {
            return isCheckedOut;
        }

        public void setCheckedOut(boolean checkedOut) {
            isCheckedOut = checkedOut;
        }
    }
}
