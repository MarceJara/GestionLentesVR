package com.pucp.gestionlentesvr.persistencia;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager instance;
    private String jdbcUrl;
    private String username;
    private String password;
    
    private DBManager() {
        configurar();
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private void configurar() {
        Properties properties = new Properties();
        String propertiesFile = "db.properties";

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new IOException("No se pudo encontrar el archivo de propiedades: " + propertiesFile);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de propiedades", e);
        }

        jdbcUrl = properties.getProperty("mysql.jdbcUrl");
        username = properties.getProperty("mysql.username");
        password = properties.getProperty("mysql.password");
    }

    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}