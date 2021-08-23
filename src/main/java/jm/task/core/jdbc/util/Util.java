package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/my_tabel?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "12345";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
        return connection;

    }

    public SessionFactory getSessionFactory() {
            SessionFactory sessionFactory = null;

            Properties prop = new Properties();
            prop.put(Environment.DRIVER, DRIVER);
            prop.put(Environment.URL, URL);
            prop.put(Environment.USER, USER);
            prop.put(Environment.PASS, PASS);

            prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
            prop.put(Environment.SHOW_SQL, "true");
            prop.put(Environment.HBM2DDL_AUTO, "none");

            Configuration config = new Configuration();
            config.setProperties(prop);
            config.addAnnotatedClass(jm.task.core.jdbc.model.User.class);

            final ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties())
                    .build();
            try {
                sessionFactory = config.buildSessionFactory(registry);
                System.out.println("SessionFactory - создан");
            } catch (Exception e) {
                System.out.println("SessionFactory - НЕ создан");
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
            }
            return sessionFactory;
        }
    }

