package pl.wszib.lms.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import pl.wszib.lms.db.UserRepository;
import pl.wszib.lms.model.User;

public class Authenticator {
    private final UserRepository userRepository = new UserRepository();

    private final String SEED = "oGvZxgE'i0E+%qnVm7$#AZGL%x3Bua";
    public static User loggedUser = null;

    public void authenticate(User user) {
        User userFromDB = userRepository.getByLogin(user.getLogin());
        if(userFromDB != null &&
                userFromDB.getPassword().equals(DigestUtils.md5Hex(user.getPassword()+SEED))) {
            loggedUser = userFromDB;
        }
    }
}