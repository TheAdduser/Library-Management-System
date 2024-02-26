package pl.wszib.lms;

import pl.wszib.lms.authorization.Authenticator;
import pl.wszib.lms.db.BookRepository;
import pl.wszib.lms.gui.GUI;
import pl.wszib.lms.model.User;
import pl.wszib.lms.utils.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static Connection connection;

    //For testing purposes
    //Login: admin
    //Password admin123
    public static void main(String[] args) {
        DBUtil.connect();
        BookRepository bookRepository = new BookRepository();
        Authenticator authenticator = new Authenticator();
        GUI gui = new GUI();
        boolean run = false;
        int counter = 0;

        while (!run && counter < 3) {
            User user = gui.readAuthData();
            run = authenticator.authenticate(user.getLogin(), user.getPassword());
            counter++;
        }
        while (run) {
            switch (GUI.showMenuAndReadChoose()) {
                case "1":
                    System.out.println("Listing all books: \n");
                    gui.listBooks(bookRepository.getBooksFromDB());
                    break;
                case "2":
                    System.out.println("Listing all leased books: \n");
                    gui.listLeasedBooks(bookRepository.getBooks());
                    break;
                case "3":
                    System.out.println("Listing expired leases: \n");
                    gui.listExpiredBooks(bookRepository.getBooks());
                        break;
                case "4":
                    System.out.println("Which book do you want to lease?: \n");
                    gui.showResult(bookRepository.lease(gui.inputIsbn()));
                    break;
                case "5":
                    System.out.println("Which book are you looking for?: \n");
                    gui.searchBooks(bookRepository.getBooks());
                    break;
                case "6":
                    System.out.println("Insert information about new book: \n");
                    gui.showResult(bookRepository.addBook());
                    break;
                case "7":
                    DBUtil.disconnect();
                    run = false;
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}