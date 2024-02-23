package pl.wszib.lms.db;

import pl.wszib.lms.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

        public UserRepository() {
            }

    public User getByLogin(String login) {
        return this.users.get(login);
    }
}