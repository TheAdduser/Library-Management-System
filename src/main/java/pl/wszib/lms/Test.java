package pl.wszib.lms;

import org.apache.commons.codec.digest.DigestUtils;
import pl.wszib.lms.db.BookRepository;
import pl.wszib.lms.model.Book;
import pl.wszib.lms.utils.DBUtil;
import pl.wszib.lms.authorization.Authenticator;

public class Test {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();


        DBUtil.connect();
        for (Book book : bookRepository.getBooks()) {
            bookRepository.saveBook(book);
        }
        DBUtil.disconnect();


        String haslo = "janusz123" + Authenticator.SEED;
        String hash = DigestUtils.md5Hex(haslo);
        System.out.println(hash);
        DBUtil.connect();

        for (Book book : bookRepository.getBooks()) {
            bookRepository.saveBook(book);
            System.out.println(book);
        }
        DBUtil.disconnect();
    }
}
