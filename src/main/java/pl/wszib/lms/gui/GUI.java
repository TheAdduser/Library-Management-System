package pl.wszib.lms.gui;

import pl.wszib.lms.authorization.Authenticator;
import pl.wszib.lms.model.Book;
import pl.wszib.lms.model.User;

import java.util.Collection;
import java.util.Scanner;
public class GUI {
    private final static Scanner scanner = new Scanner(System.in);
    public static String showMenuAndReadChoose() {
        System.out.println("1. List all books");
        System.out.println("2. List leased book");
        System.out.println("3. Lease book");
        System.out.println("4. Search book");
        System.out.println("5. Add book");
        System.out.println("6. Exit");


        return scanner.nextLine();
    }

    public static void listBooks(Book[] books) {
    for (Book book : books) {
        System.out.println(book);
        }
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
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }
}

