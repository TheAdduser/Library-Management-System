package pl.wszib.lms.db;

import pl.wszib.lms.App;
import pl.wszib.lms.model.Book;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book(1,9788304004467L, "Pan Tadeusz", "Adam Mickiewicz"));
        this.books.add(new Book(2,9782824903996L, "Krzyżacy", "Henryk Sienkiewicz"));
        this.books.add(new Book(3,9788373271890L, "W pustyni i w puszczy", "Henryk Sienkiewicz"));
        this.books.add(new Book(4,9788380080666L, "Chłopi", "Władysław Reymont"));
        this.books.add(new Book(5,9788373191724L, "Lalka", "Bolesław Prus"));
        this.books.add(new Book(6,9788389681111L, "Ferdydurke", "Witold Gombrowicz"));
        this.books.add(new Book(7,9788389598570L, "Zbrodnia i kara", "Fiodor Dostojewski"));
        this.books.add(new Book(8,9788386802546L, "Quo Vadis", "Henryk Sienkiewicz"));
        this.books.add(new Book(9,9788324014251L, "Nad Niemnem", "Eliza Orzeszkowa"));
        this.books.add(new Book(10,9788380108574L, "Solaris", "Stanisław Lem"));
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
                book.setLeaseEndDate(book.getLeaseStartDate().plusWeeks(2));
                return true;
            }
        }
        return false;
    }

    public boolean addBook(){
        System.out.println("Input title: ");
        String title = scanner.nextLine();
        System.out.println("Input author: ");
        String author = scanner.nextLine();
        System.out.println("Input ISBN No. ");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        Book newBook = new Book(isbn,title,author);
        books.add(newBook);
        return books.contains(newBook);

    }

    public void saveBook(Book book)  {
        try {
            String sql = "INSERT INTO tbook (isbn, title, author, leaseStartDate, leaseEndDate, leaseStatus, usersName) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);

            preparedStatement.setLong(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            if (book.getLeaseStartDate() != null) {
                preparedStatement.setDate(4, java.sql.Date.valueOf(book.getLeaseStartDate()));
            } else {
                preparedStatement.setNull(4, java.sql.Types.DATE);
            }
            if (book.getLeaseEndDate() != null) {
                preparedStatement.setDate(5, java.sql.Date.valueOf(book.getLeaseEndDate()));
            } else {
                preparedStatement.setNull(5, java.sql.Types.DATE);
            }
            preparedStatement.setBoolean(6, book.getLeaseStatus());
            preparedStatement.setString(7, book.getUsersName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}