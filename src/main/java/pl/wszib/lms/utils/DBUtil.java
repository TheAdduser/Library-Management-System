package pl.wszib.lms.utils;

import pl.wszib.lms.App;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static void connect()    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            App.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","")
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            App.connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
