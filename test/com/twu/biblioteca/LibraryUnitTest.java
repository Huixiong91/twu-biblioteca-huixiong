package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryUnitTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private BibliotecaApp app = new BibliotecaApp();
    private Library lib = new Library();

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
    public void testDisplayUserInfo() {
        lib.loggedInAccount = lib.accounts.get(0);
        lib.loggedInAccount.displayInfo();
        String expected = "Your information\n";
        expected += "Name: " + lib.loggedInAccount.getName() + "     Email: " + lib.loggedInAccount.getEmail() + "      Phone Number: " + lib.loggedInAccount.getPhoneNumber() + "\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCheckoutAndReturnBookRecordsTransaction() {
        Book bookToCheckOut = lib.books.get(0);
        assertEquals(false, lib.checkedOutBooks.contains(bookToCheckOut));
        lib.checkoutBook(bookToCheckOut.getTitle());
        assertEquals(true, lib.checkedOutBooks.contains(bookToCheckOut));
        lib.returnBook(bookToCheckOut.getTitle());
        assertEquals(false, lib.checkedOutBooks.contains(bookToCheckOut));
    }

    @Test
    public void testCheckoutMovieRecordsTransaction() {
        Movie movieToCheckOut = lib.movies.get(0);
        assertEquals(false, lib.checkedOutMovies.contains(movieToCheckOut));
        lib.checkoutMovie(movieToCheckOut.getName());
        assertEquals(true, lib.checkedOutMovies.contains(movieToCheckOut));
    }
}
