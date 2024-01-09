package pl.wszib.lms;

import pl.wszib.lms.authorization.Authenticator;
import pl.wszib.lms.db.BookRepository;
import pl.wszib.lms.gui.GUI;

public class App {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        Authenticator authenticator = new Authenticator();
        boolean run = false;
        int counter = 0;

        while (!run && counter < 3) {
            authenticator.authenticate(GUI.readAuthData());
            run = Authenticator.loggedUser != null;
            counter++;
        }
        while (run) {
            switch (GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.listBooks(bookRepository.getBooks());
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    
                    break;
                case "5":
                    
                    break;
                case "6":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}