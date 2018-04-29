package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    List<Book> books = new ArrayList<Book>();
    List<Movie> movies = new ArrayList<Movie>();
    List<Account> accounts = new ArrayList<Account>();
    List<String> mainMenuOptions = new ArrayList<String>();
    Account loggedInAccount;

    public BibliotecaApp() {
        // init
        Book book_1 = new Book("Book 1", "Mr Lee", "2004");
        Book book_2 = new Book("Book 2", "James Cook", "2011");
        Book book_3 = new Book("Book 3", "Peter Ang", "2015");
        books.add(book_1);
        books.add(book_2);
        books.add(book_3);

        Movie movie_1 = new Movie("Movie 1", "2004", "Director 1");
        Movie movie_2 = new Movie("Movie 2", "2014", "Director 2");
        Movie movie_3 = new Movie("Movie 3", "2000", "Director 3");
        movie_3.setRating(10);
        movies.add(movie_1);
        movies.add(movie_2);
        movies.add(movie_3);

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
        for (Book b : books) {
            if (b.title.equals(title)) {
                if (b.isCheckedOut()) {
                    System.out.println("That book is not available.");
                }
                else {
                    b.isCheckedOut = true;
                    System.out.println("Thank you! Enjoy the book.");
                }
                return;
            }
        }
        System.out.println("That book is not available.");
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

    public void checkoutMovie() {
        System.out.println("Enter the movie name that you wish to checkout: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        for (Movie m : movies) {
            if (m.getName().equals(title)) {
                if (m.isCheckedOut()) {
                    System.out.println("That movie is not available.");
                }
                else {
                    m.isCheckedOut = true;
                    System.out.println("Thank you! Enjoy the movie.");
                }
                return;
            }
        }
        System.out.println("That movie is not available.");
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
    }

    public void listMovie() {
        System.out.println("List of movies available");
        int index = 1;
        String s1 = String.format("   %-25s %-25s %-25s %-2s", "Name", "Year", "Director", "Rating");
        System.out.println(s1);
        for (Movie movie : movies) {
            if (!movie.isCheckedOut) {
                String movieDetail;
                if (movie.getRating() != null) {
                    movieDetail = String.format("%s: %-25s %-25s %-25s %-2s", index++, movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
                } else {
                    movieDetail = String.format("%s: %-25s %-25s %-25s Unrated", index++, movie.getName(), movie.getYear(), movie.getDirector());
                }
                System.out.println(movieDetail);
            }
        }
    }

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

    public class Movie {
        String name;
        String year;
        String director;
        Integer rating;
        boolean isCheckedOut;

        public Movie(String name, String year, String director) {
            this.name = name;
            this.year = year;
            this.director = director;
            this.isCheckedOut = false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }
        public boolean isCheckedOut() {
            return isCheckedOut;
        }

        public void setCheckedOut(boolean checkedOut) {
            isCheckedOut = checkedOut;
        }
    }

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

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void displayInfo() {
            System.out.println("Your information");
            System.out.println("Name: " + getName() + "     Email: " + getEmail() + "      Phone Number: " + getPhoneNumber());
        }
    }
}
