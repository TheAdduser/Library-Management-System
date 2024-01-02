package pl.wszib.lms.db;

import pl.wszib.lms.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

        public UserRepository() {
        this.users.put("admin",
                new User("admin", "362706cff716326a8a8317c9c5bd47f9", "ADMIN"));
        this.users.put("janusz",
                new User("janusz", "5550b60e1d08b7c2e88d146c0721de00", "USER"));
    }

    public User getByLogin(String login) {
        return this.users.get(login);
    }
}