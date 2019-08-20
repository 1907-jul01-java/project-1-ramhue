package com.revature.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionUtil
 */
public class ConnectionUtil {
    private Connection connection;
    private String url;
    private String user;
    private String password;

    public ConnectionUtil() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            properties.load(new FileReader(
                    new File(
                        getClass().getClassLoader().getResource("application.properties").getFile()
                    )
                )
            );
            this.url = properties.getProperty("url");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}