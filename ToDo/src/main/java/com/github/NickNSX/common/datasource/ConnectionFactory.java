package com.github.NickNSX.common.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//implement ConnectionFactory and singleton
public class ConnectionFactory {

    private static ConnectionFactory connFactory;
    private Properties dbProps = new Properties();
    

    public ConnectionFactory() {

        try {
            Class.forName("org.postgresql.Driver");
            dbProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (ClassNotFoundException e) {
            //TODO replace runtime exception
            throw new RuntimeException("Failed to load PostgreSQL JDBC driver.", e);
        } catch (IOException e) {
            //TODO replace runtime exception
            throw new RuntimeException("Could not read from properties file.", e);
        }
    }

    public static ConnectionFactory getInstance() {
        if (connFactory == null) {
            connFactory = new ConnectionFactory();
        }
        return connFactory;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbProps.getProperty("db_url"), dbProps.getProperty("db_username"), dbProps.getProperty("db_password"));
    }
}
