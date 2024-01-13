package pl.wszib.lms;

import pl.wszib.lms.authorization.Authenticator;
import pl.wszib.lms.db.BookRepository;
import pl.wszib.lms.gui.GUI;
import pl.wszib.lms.model.User;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
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
                    gui.listBooks(bookRepository.getBooks());
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
                    break;
                case "6":
                    System.out.println("Insert information about new book: \n");
                    gui.showResult(bookRepository.addBook());
                    break;
                case "7":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}