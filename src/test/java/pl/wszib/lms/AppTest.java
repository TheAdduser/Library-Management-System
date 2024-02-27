package pl.wszib.lms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.wszib.lms.db.BookRepository;
import pl.wszib.lms.model.Book;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Unit test for simple App.
 */

public class AppTest {

    @Test
    public void rentBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 1234;

        boolean actual = bookRepository.testLeaseBook(isbn);

        Assertions.assertTrue(actual);
    }

    @Test
    public void errorRentBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 1L;

        boolean actual = bookRepository.testLeaseBook(isbn);

        Assertions.assertFalse(actual);
    }

    @Test
    public void returnBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 1234L;

        boolean actual = bookRepository.testReturnBook(isbn);

        Assertions.assertTrue(actual);
    }

    @Test
    public void errorReturnBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 12345L;

        boolean actual = bookRepository.testReturnBook(isbn);

        Assertions.assertFalse(actual);
    }

    @Test
    public void getBooksShouldReturnBooksFromList() {

        List<Book> testDatabase = new ArrayList<>();
        testDatabase.add(new Book(123456789, "Test Book 1", "Test Author 1", null, null, false, null));
        testDatabase.add(new Book(987654321, "Test Book 2", "Test Author 2", null, null, false, null));

        BookRepository bookRepository = new BookRepository(testDatabase);

        List<Book> result = bookRepository.getBooks();

        assertEquals(2, result.size());
        assertEquals("Test Book 1", result.get(0).getTitle());
        assertEquals("Test Book 2", result.get(1).getTitle());
    }

    @Test
    public void errorGetBooksShouldReturnBooksFromList() {

        List<Book> testDatabase = new ArrayList<>();
        testDatabase.add(new Book(123456789, "Book 1", "Author 1", null, null, false, null));
        testDatabase.add(new Book(987654321, "Book 2", "Author 2", null, null, false, null));

        BookRepository bookRepository = new BookRepository(testDatabase);

        List<Book> result = bookRepository.getBooks();

        assertEquals(2, result.size());
        assertNotEquals("Test Book 2", result.get(0).getTitle());
        assertNotEquals("Test Book 1", result.get(1).getTitle());
    }
}