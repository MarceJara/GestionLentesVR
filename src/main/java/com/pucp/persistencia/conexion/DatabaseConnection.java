package com.pucp.persistencia.conexion;
//    private static final String URL = "jdbc:mysql://http://bdlab04p3.clcmykqu8lqs.us-east-1.rds.amazonaws.com:3306/bdLab04";
  //  private static final String USER = "admin";
  //  private static final String PASSWORD = "FazazelDB75.";
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection = null;
    private static String url;
    private static String user;
    private static String password;
    
    static {
        loadCredentials();
    }
    
    private static void loadCredentials() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("src/resources/database.properties")) {
            props.load(input);
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
        } catch (IOException e) {
            System.err.println("Error loading database.properties file. Using environment variables.");
            
            // Try to load from environment variables as fallback
            url = System.getenv("DB_URL");
            user = System.getenv("DB_USER");
            password = System.getenv("DB_PASSWORD");
            
            if (url == null || user == null || password == null) {
                throw new RuntimeException("Database credentials not found. Please check your configuration.");
            }
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                throw new SQLException("MySQL Driver not found", e);
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
