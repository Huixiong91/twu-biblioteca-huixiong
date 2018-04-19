package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    List<Book> books = new ArrayList<Book>();
    public BibliotecaApp() {
        Book book_1 = new Book("Book 1", "Mr Lee", "2004");
        Book book_2 = new Book("Book 2", "James Cook", "2011");
        Book book_3 = new Book("Book 3", "Peter Ang", "2015");
        books.add(book_1);
        books.add(book_2);
        books.add(book_3);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca-HuiXiong!");
        BibliotecaApp app = new BibliotecaApp();
    }

    public void listBook() {
        System.out.println("List of books available");
        int index = 1;
        for (Book book : books){
            System.out.println(index++ + ": " + book.title);
        }
    }

    public void printBookDetail(Book b) {
        System.out.println("Author: " + b.author + " Year Published: " + b.yearPublished);
    }

    public class Book {
        String title;
        String author;
        String yearPublished;

        public Book(String title, String author, String yearPublished) {
            this.title = title;
            this.author = author;
            this.yearPublished = yearPublished;
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
    }
}
