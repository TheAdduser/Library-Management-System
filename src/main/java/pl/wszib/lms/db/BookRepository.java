package pl.wszib.lms.db;

import pl.wszib.lms.model.Book;


public class BookRepository {
    private final Book[] books = new Book[10];

    public BookRepository() {
        this.books[0] = new Book("9788304004467","Pan Tadeusz","Adam Mickiewicz");
        this.books[1] = new Book("9782824903996","Krzyżacy", "Henryk Sienkiewicz");
        this.books[2] = new Book("9788373271890", "W pustyni i w puszczy", "Henryk Sienkiewicz");
        this.books[3] = new Book("9788380080666", "Chłopi", "Władysław Reymont");
        this.books[4] = new Book("9788373191724", "Lalka", "Bolesław Prus");
        this.books[5] = new Book("9788389681111", "Ferdydurke", "Witold Gombrowicz");
        this.books[6] = new Book("9788389598570", "Zbrodnia i kara", "Fiodor Dostojewski");
        this.books[7] = new Book("9788386802546", "Quo Vadis", "Henryk Sienkiewicz");
        this.books[8] = new Book("9788324014251", "Nad Niemnem", "Eliza Orzeszkowa");
        this.books[9] = new Book("9788380108574", "Solaris", "Stanisław Lem");
    }

    public Book[] getBooks()    {
        return books;
    }
}