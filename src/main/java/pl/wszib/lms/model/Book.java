package pl.wszib.lms.model;
import java.util.*;
import java.time.LocalDate;

public class Book {
    
    private final String bookId;
    private String isbn;
    private String title;
    private String author;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private int userID;



public Book(String isbn, String title, String author) {

    this.bookId = UUID.randomUUID().toString();
    this.isbn = isbn;
    this.title = title;
    this.author = author;

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

    public String getBookId() {return bookId; }
    public LocalDate getLeaseStartDate() {return leaseStartDate; }
    public void SetLeaseStartDate(LocalDate leaseStartDate) {this.leaseStartDate = leaseStartDate; }
    public LocalDate getLeaseEndDate() {return leaseEndDate; }
    public void SetLeaseEndDate(LocalDate leaseEndDate) {this.leaseEndDate = leaseStartDate.plusWeeks(2); }

    public int getUserID() {return userID; }
    public void setUserID(int userID) {this.userID = userID; }
}