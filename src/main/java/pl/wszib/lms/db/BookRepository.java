package pl.wszib.lms.db;

import pl.wszib.lms.model.Book;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class BookRepository {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book("9788304004467", "Pan Tadeusz", "Adam Mickiewicz"));
        this.books.add(new Book("9782824903996", "Krzyżacy", "Henryk Sienkiewicz"));
        this.books.add(new Book("9788373271890", "W pustyni i w puszczy", "Henryk Sienkiewicz"));
        this.books.add(new Book("9788380080666", "Chłopi", "Władysław Reymont"));
        this.books.add(new Book("9788373191724", "Lalka", "Bolesław Prus"));
        this.books.add(new Book("9788389681111", "Ferdydurke", "Witold Gombrowicz"));
        this.books.add(new Book("9788389598570", "Zbrodnia i kara", "Fiodor Dostojewski"));
        this.books.add(new Book("9788386802546", "Quo Vadis", "Henryk Sienkiewicz"));
        this.books.add(new Book("9788324014251", "Nad Niemnem", "Eliza Orzeszkowa"));
        this.books.add(new Book("9788380108574", "Solaris", "Stanisław Lem"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}