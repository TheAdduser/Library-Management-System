package pl.wszib.lms.model;
import java.util.*;
import java.time.LocalDate;

public class Book {
    
    private String id;
    private String isbn;
    private String title;
    private String author;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;



public Book(String isbn, String title, String author, LocalDate leaseStartDate) {

    this.id = UUID.randomUUID().toString();
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.leaseStartDate;
    this.leaseEndDate = leaseStartDate.plusWeeks(2);
}

}