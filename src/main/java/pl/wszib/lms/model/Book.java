package pl.wszib.lms.model;
import java.util.*;
import java.time.LocalDate;

public class Book {
    
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private int userID;



public Book(String isbn, String title, String author, LocalDate leaseStartDate) {

    this.bookId = UUID.randomUUID().toString();
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.leaseStartDate = leaseStartDate;
    this.leaseEndDate = leaseStartDate.plusWeeks(2);
    this.userID = userID;

}

}