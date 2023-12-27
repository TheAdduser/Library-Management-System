package pl.wszib.lms;
import java.util.*;
import java.time.LocalDate;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;



    public Book(int id) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.leaseStartDate;
        this.leaseEndDate = leaseStartDate.plusWeeks(2);
    }
}