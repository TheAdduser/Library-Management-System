package pl.wszib.lms.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import pl.wszib.lms.db.UserRepository;
import pl.wszib.lms.model.User;

public class Authenticator {
    private final UserRepository userRepository = new UserRepository();

    private final String SEED = "oGvZxgE'i0E+%qnVm7$#AZGL%x3Bua";
    public static User loggedUser = null;

    public boolean authenticate(String login, String password){
        User user = userRepository.getByLogin(login);
        return user != null && user.getPassword()
                .equals(DigestUtils.md5Hex((password)+SEED));
    }
}