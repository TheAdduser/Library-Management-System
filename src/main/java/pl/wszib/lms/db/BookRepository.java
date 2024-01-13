package pl.wszib.lms.db;

import pl.wszib.lms.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book(9788304004467L, "Pan Tadeusz", "Adam Mickiewicz"));
        this.books.add(new Book(9782824903996L, "Krzyżacy", "Henryk Sienkiewicz"));
        this.books.add(new Book(9788373271890L, "W pustyni i w puszczy", "Henryk Sienkiewicz"));
        this.books.add(new Book(9788380080666L, "Chłopi", "Władysław Reymont"));
        this.books.add(new Book(9788373191724L, "Lalka", "Bolesław Prus"));
        this.books.add(new Book(9788389681111L, "Ferdydurke", "Witold Gombrowicz"));
        this.books.add(new Book(9788389598570L, "Zbrodnia i kara", "Fiodor Dostojewski"));
        this.books.add(new Book(9788386802546L, "Quo Vadis", "Henryk Sienkiewicz"));
        this.books.add(new Book(9788324014251L, "Nad Niemnem", "Eliza Orzeszkowa"));
        this.books.add(new Book(9788380108574L, "Solaris", "Stanisław Lem"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean lease(long isbn){
        for (Book book : this.books){
            if (book.getIsbn() == isbn && !book.getLeaseStatus()){
                System.out.println("Enter your name and surname: ");
                String userName = scanner.nextLine();
                book.setUserName(userName);
                book.setLeaseStatus(true);
                book.setLeaseStartDate(LocalDate.now());
                book.setLeaseEndDate(LocalDate.now().plusWeeks(2));
                return true;
            }
        }
        return false;
    }
}