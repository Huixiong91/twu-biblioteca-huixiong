import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class LibraryUnitTest {
    private Library lib = new Library();

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testDisplayUserInfo() {
        lib.loggedInAccount = lib.accounts.get(0);
        lib.loggedInAccount.displayInfo();
        String expected = "Your information\n";
        expected += "Name: " + lib.loggedInAccount.getName() + "     Email: " + lib.loggedInAccount.getEmail() + "      Phone Number: " + lib.loggedInAccount.getPhoneNumber() + "\n";
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testCheckoutAndReturnBookRecordsTransaction() {
        Book bookToCheckOut = lib.books.get(0);
        systemInMock.provideLines(bookToCheckOut.getTitle(), bookToCheckOut.getTitle());
        assertFalse(lib.checkedOutBooks.contains(bookToCheckOut));
        lib.checkoutBook();
        assertTrue(lib.checkedOutBooks.contains(bookToCheckOut));
        lib.returnBook();
        assertFalse(lib.checkedOutBooks.contains(bookToCheckOut));
    }

    @Test
    public void testCheckoutMovieRecordsTransaction() {
        Movie movieToCheckOut = lib.movies.get(0);
        systemInMock.provideLines(movieToCheckOut.getName());
        assertFalse(lib.checkedOutMovies.contains(movieToCheckOut));
        lib.checkoutMovie();
        assertTrue(lib.checkedOutMovies.contains(movieToCheckOut));
    }
}
