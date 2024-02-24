package pl.wszib.lms.db;

import pl.wszib.lms.App;
import pl.wszib.lms.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

        public UserRepository() {
            }

    public User getByLogin(String login) {
            try {
                String sql = "SELECT * FROM tuser WHERE login = ?";
                PreparedStatement preparedStatement = App.connection.prepareStatement(sql);

                preparedStatement.setString(1,login);

                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    return new User(rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("password"),
                            rs.getString("role"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
}