package pl.wszib.lms.model;
import java.time.LocalDate;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private boolean leaseStatus;
    private String bookInfo;

public Book(String isbn, String title, String author) {

    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.leaseStatus = false;

}
public Book(String isbn, String title, String author, LocalDate leaseStartDate,
    LocalDate leaseEndDate, boolean leaseStatus, String bookInfo){
        
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.leaseStatus = leaseStatus;
        this.bookInfo = bookInfo;


    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getLeaseStartDate() {return leaseStartDate; }
    public void setLeaseStartDate(LocalDate leaseStartDate) {this.leaseStartDate = leaseStartDate; }
    public LocalDate getLeaseEndDate() {return leaseEndDate; }
    public void setLeaseEndDate(LocalDate leaseEndDate) {this.leaseEndDate = leaseStartDate.plusWeeks(2); }

}