package pl.wszib.lms.model;
import java.time.LocalDate;

public class Book {

    private long isbn;
    private String title;
    private String author;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private boolean leaseStatus;
    private String usersName;

public Book(long isbn, String title, String author) {

    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.leaseStatus = false;

}
public Book(long isbn, String title, String author, LocalDate leaseStartDate,
    LocalDate leaseEndDate, boolean leaseStatus, String usersName){
        
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.leaseStatus = leaseStatus;
        this.usersName = usersName;


    }
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
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
    public void setLeaseEndDate(LocalDate leaseEndDate) {this.leaseEndDate = leaseEndDate; }
    public boolean getLeaseStatus() {return leaseStatus; }
    public void setLeaseStatus(boolean leaseStatus) {this.leaseStatus = leaseStatus; }
    public String getUsersNAme(){ return usersName; }
    public void setUserName(String usersName){ this.usersName = usersName; }

    @Override
    public String toString(){
    return new StringBuilder().append("\"")
            .append(this.getTitle())
            .append("\", ")
            .append(this.getAuthor())
            .append(", ")
            .append("ISBN No. ")
            .append(this.getIsbn())
            .append(" ")
            .append(this.getLeaseStartDate() == null ? "" : this.getLeaseStartDate())
            .append(" - ")
            .append(this.getLeaseEndDate() == null ? "" : this.getLeaseEndDate())
            .append(" ")
            .append(this.getLeaseStatus() ? "is leased " : "is not leased ")
            .append(this.getUsersNAme() == null ? "": "by ")
            .append(this.getUsersNAme() == null ? "": this.getUsersNAme())
            .toString();
    }

}