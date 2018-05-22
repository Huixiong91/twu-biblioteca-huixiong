import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class ExampleTest {
    private Library lib = new Library();
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testListBookShouldNotShowCheckedOutBooks() {
        lib.books.get(0).setCheckedOut(true);
        lib.listBook();
        String expected = "List of books available\n";
        String s1 = String.format("   %-25s %-25s %-25s", "Title", "Author", "Year Published");
        expected += s1 + '\n';
        int index = 1;
        for (Book b : lib.books) {
            if (!lib.checkedOutBooks.contains(b)) {
                String bookDetail = String.format("%s: %-25s %-25s %-25s\n", index++, b.getTitle(), b.getAuthor(), b.getYearPublished());
                expected += bookDetail;
            }
        }
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testListMovieShouldNotShowCheckedOutMovie() {
        lib.movies.get(0).setCheckedOut(true);
        lib.listMovie();
        String expected = "List of movies available\n";
        String s1 = String.format("   %-25s %-25s %-25s %-2s", "Name", "Year", "Director", "Rating");
        expected += s1 + '\n';
        int index = 1;
        for (Movie movie : lib.movies) {
            if (!lib.checkedOutMovies.contains(movie)) {
                String movieDetail;
                if (movie.getRating() != null) {
                    movieDetail = String.format("%s: %-25s %-25s %-25s %-2s", index++, movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
                } else {
                    movieDetail = String.format("%s: %-25s %-25s %-25s Unrated", index++, movie.getName(), movie.getYear(), movie.getDirector());
                }
                expected += movieDetail + "\n";
            }
        }
        assertEquals(expected, systemOutRule.getLog());
    }


    @Test
    public void testCheckOutValidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "Thank you! Enjoy the book.\n";
        systemInMock.provideLines(lib.books.get(0).getTitle());
        lib.checkoutBook();
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testCheckOutInvalidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "That book is not available.\n";
        systemInMock.provideLines("Unavailable book");
        lib.checkoutBook();
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testCheckOutValidMovie() {
        String expected = "Enter the movie name that you wish to checkout: \n";
        expected += "Thank you! Enjoy the movie.\n";
        systemInMock.provideLines(lib.movies.get(0).getName());
        lib.checkoutMovie();
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testCheckOutInvalidMovie() {
        String expected = "Enter the movie name that you wish to checkout: \n";
        expected += "That movie is not available.\n";
        systemInMock.provideLines("Unavailable movie");
        lib.checkoutMovie();
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testReturnValidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "Thank you! Enjoy the book.\n";
        systemInMock.provideLines(lib.books.get(0).getTitle());
        lib.checkoutBook();
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testReturnInvalidBook() {
        String expected = "Enter the book title that you wish to checkout: \n";
        expected += "That book is not available.\n";
        systemInMock.provideLines("Unavailable book");
        lib.checkoutBook();
        assertEquals(expected, systemOutRule.getLog());
    }

}