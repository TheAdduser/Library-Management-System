package pl.wszib.lms.db;

import pl.wszib.lms.model.Book;


public class BookRepository {
    private final Book[] books = new Book[10];

    public BookRepository() {
        this.books[0] = new Book("978837141","Pan Tadeusz","Adam Mickiewicz");
        this.books[1] = new Book("9782824903996","Krzyżacy", "Henryk Sienkiewicz");
    }
}