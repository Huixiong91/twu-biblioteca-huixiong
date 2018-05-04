package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> books = new ArrayList<Book>();
    List<Movie> movies = new ArrayList<Movie>();
    List<Book> checkedOutBooks = new ArrayList<>();
    List<Movie> checkedOutMovies = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();
    Account loggedInAccount;

    public Library() {
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
    }

    public void listBook() {
        System.out.println("List of books available");
        int index = 1;
        String s1 = String.format("   %-25s %-25s %-25s", "Title", "Author", "Year Published");
        System.out.println(s1);
        for (Book book : books){
            if (!checkedOutBooks.contains(book)) {
                String bookDetail = String.format("%s: %-25s %-25s %-25s", index++, book.getTitle(), book.getAuthor(), book.getYearPublished());
                System.out.println(bookDetail);
            }
        }
    }

    public void checkoutBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && !checkedOutBooks.contains(b)) {
                checkedOutBooks.add(b);
                System.out.println("Thank you! Enjoy the book.");
                return;
            }
        }
        System.out.println("That book is not available.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && checkedOutBooks.contains(b)) {
                checkedOutBooks.remove(b);
                System.out.println("Thank you for returning the book.");
                return;
            }
        }
        System.out.println("That is not a valid book to return.");
    }

    public void listMovie() {
        System.out.println("List of movies available");
        int index = 1;
        String s1 = String.format("   %-25s %-25s %-25s %-2s", "Name", "Year", "Director", "Rating");
        System.out.println(s1);
        for (Movie movie : movies) {
            if (!checkedOutMovies.contains(movie)) {
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

    public void checkoutMovie(String title) {
        for (Movie m : movies) {
            if (m.getName().equals(title) && !checkedOutMovies.contains(m)) {
                System.out.println("Thank you! Enjoy the movie.");
                checkedOutMovies.add(m);
                return;
            }
        }
        System.out.println("That movie is not available.");
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

}
