package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> books = new ArrayList<Book>();
    List<Movie> movies = new ArrayList<Movie>();
    List<Book> checkedOutBooks = new ArrayList<>();
    List<Movie> checkedOutMovie = new ArrayList<>();


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
            if (!checkedOutMovie.contains(movie)) {
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
            if (m.getName().equals(title) && !checkedOutMovie.contains(m)) {
                System.out.println("Thank you! Enjoy the movie.");
                checkedOutMovie.add(m);
                return;
            }
        }
        System.out.println("That movie is not available.");
    }

}
