package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private BibliotecaApp app = new BibliotecaApp();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void testGetMainMenuSelectedOptionNotifyInvalidOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("0\n1\n".getBytes());
        System.setIn(in);
        app.getMainMenuSelectedOption();
        assertEquals("Invalid option, please select again\n", outContent.toString());
    }

    @Test
    public void testListBookShouldNotShowCheckedOutBooks() {
        app.books.get(0).isCheckedOut = true;
        app.listBook();
        String expected = "List of books available\n";
        String s1 = String.format("   %-25s %-25s %-25s", "Title", "Author", "Year Published");
        expected+= s1 +'\n';
        int index = 1;
        for (BibliotecaApp.Book b : app.books) {
            if (!b.isCheckedOut) {
                String bookDetail = String.format("%s: %-25s %-25s %-25s\n", index++, b.title, b.author, b.yearPublished);
                expected += bookDetail;
            }
        }
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testListMovieShouldNotShowCheckedOutMovie() {
        app.movies.get(0).isCheckedOut = true;
        app.listMovie();
        String expected = "List of movies available\n";
        String s1 = String.format("   %-25s %-25s %-25s %-2s", "Name", "Year", "Director", "Rating");
        expected+= s1 +'\n';
        int index = 1;
        for (BibliotecaApp.Movie movie : app.movies) {
            if (!movie.isCheckedOut) {
                String movieDetail;
                if (movie.getRating() != null) {
                    movieDetail = String.format("%s: %-25s %-25s %-25s %-2s", index++, movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
                } else {
                    movieDetail = String.format("%s: %-25s %-25s %-25s Unrated", index++, movie.getName(), movie.getYear(), movie.getDirector());
                }
                expected += movieDetail + "\n";
            }
        }
        assertEquals(expected, outContent.toString());
    }


    @Test
    public void testCheckOutValidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "Thank you! Enjoy the book.\n";
        ByteArrayInputStream in = new ByteArrayInputStream(app.books.get(0).getTitle().getBytes());
        System.setIn(in);
        app.checkoutBook();
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCheckOutInvalidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "That book is not available.\n";
        ByteArrayInputStream in = new ByteArrayInputStream("Unavailable book\n".getBytes());
        System.setIn(in);
        app.checkoutBook();
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testReturnValidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "Thank you! Enjoy the book.\n";
        ByteArrayInputStream in = new ByteArrayInputStream(app.books.get(0).getTitle().getBytes());
        System.setIn(in);
        app.checkoutBook();
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testReturnInvalidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "That book is not available.\n";
        ByteArrayInputStream in = new ByteArrayInputStream("Unavailable book\n".getBytes());
        System.setIn(in);
        app.checkoutBook();
        assertEquals(expected, outContent.toString());
    }
}
