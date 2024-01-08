package pl.wszib.lms.gui;

import pl.wszib.lms.authorization.Authenticator;
import pl.wszib.lms.model.Book;
import pl.wszib.lms.model.User;

import java.util.Collection;
import java.util.Scanner;
public class GUI {
    private final static Scanner scanner = new Scanner(System.in);
    public static String showMenuAndReadChoose() {
        System.out.println("1. List books");
        System.out.println("2. Rent book");
        System.out.println("3. Return book");
        System.out.println("4. Exit");
        return scanner.nextLine();
    }
    public static void listBooks(Book[] books) {
    for (Book book : books) {
        System.out.println(book);
        }
    }

}
