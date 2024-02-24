package pl.wszib.lms.gui;

import pl.wszib.lms.model.Book;
import pl.wszib.lms.model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class GUI {
    private final static Scanner scanner = new Scanner(System.in);
    public static String showMenuAndReadChoose() {
        System.out.println("\n===================================================");
        System.out.println("1. List all books");
        System.out.println("2. List leased books");
        System.out.println("3. List all expired books");
        System.out.println("4. Lease book");
        System.out.println("5. Search book");
        System.out.println("6. Add book");
        System.out.println("7. Exit");
        System.out.println("===================================================\n");

        return scanner.nextLine();
    }

    public void listBooks(ArrayList<Book> books) {
    for (Book book : books) {
        System.out.println(book);
        }
    }

    public void listLeasedBooks(ArrayList<Book> books){
        int counter = 0;
        for(Book book : books){
            if(book.getLeaseStatus()){
                System.out.println(book);
                counter++;
            }
        }
        if(counter == 0) System.out.println("All books are in the library!");
    }

    public long inputIsbn(){
        System.out.println("Enter ISBN No.");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        return isbn;
    }

    public void listExpiredBooks(ArrayList<Book> books){
        int counter = 0;
        for(Book book : books){
            if(book.getLeaseEndDate() != null && book.getLeaseStartDate() != null){
                if(book.getLeaseEndDate().isBefore(LocalDate.now()) && book.getLeaseStatus()){
                    System.out.println(book);
                    counter++;
                }
            }
        }
        if(counter == 0) System.out.println("There are no expired books");
    }

    public void searchBooks(ArrayList<Book> books){
        int counter = 0;
        String text = scanner.nextLine();
        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(text.toLowerCase()) ||
                    String.valueOf(book.getIsbn()).contains(text)){
                System.out.println(book);
                counter++;
            }
        }
        if(counter == 0) System.out.println("No books found");
    }


    public static void showResult(boolean result) {
        if(result) {
            System.out.println("Success !!");
        } else {
            System.out.println("Error !!");
        }
    }


    public User readAuthData() {
        System.out.println("Login:");
        String login = this.scanner.nextLine();
        System.out.println("Password:");
        return new User(login, this.scanner.nextLine());
    }
}

