package jm.task.core.jdbc.util;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Util  {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/my_tabel?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
        return connection;
    }
    // реализуйте настройку соеденения с БД
}
