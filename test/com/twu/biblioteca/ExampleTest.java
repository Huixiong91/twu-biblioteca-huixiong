package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void testMain() {
        BibliotecaApp.main(null);
        assertEquals("Welcome to Biblioteca-HuiXiong!\n", outContent.toString());
    }

    @Test
    public void testListBook() {
        app.listBook();
        String expected = "List of books available\n";
        int index = 1;
        for (BibliotecaApp.Book b : app.books) {
            expected += index++ + ": " + b.title + "\n";
        }
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testPrintBookDetail(){
        BibliotecaApp.Book b = app.books.get(1);
        app.printBookDetail(app.books.get(1));
        assertEquals("Author: " + b.author + " Year Published: " + b.yearPublished +"\n", outContent.toString());

    }
}
