package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String userName = "bestuser";
    private static final String userPassword = "bestuser";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/mynewdb";

    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties myProperties = new Properties();

                myProperties.put(Environment.USER, userName);
                myProperties.put(Environment.PASS, userPassword);
                myProperties.put(Environment.URL, connectionURL);
                myProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                myProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                myProperties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");


                configuration.setProperties(myProperties);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(builder);

            } catch (Exception e) {
                System.out.println("Исключение " + e);
            }

        }
        return sessionFactory;
    }
}
