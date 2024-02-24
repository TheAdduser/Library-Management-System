package pl.wszib.lms;

import pl.wszib.lms.db.BookRepository;
import pl.wszib.lms.model.Book;
import pl.wszib.lms.utils.DBUtil;

public class Test {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();


        DBUtil.connect();
        for(Book book : bookRepository.getBooks()){
            bookRepository.saveBook(book);
        }
        DBUtil.disconnect();
    }
}
