package com.pucp.gestionlentesvr.persistencia;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager instance;
    private HikariDataSource dataSource;

    // Constructor privado para evitar instanciación externa
    private DBManager() {
        configurar();
    }

    // Método para obtener la instancia del Singleton
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    // Método para configurar el pool de conexiones
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

        HikariConfig config = new HikariConfig();
        String dbType = properties.getProperty("db.type").toLowerCase();
        config.setJdbcUrl(properties.getProperty(dbType + ".jdbcUrl"));
        config.setUsername(properties.getProperty(dbType + ".username"));
        config.setPassword(properties.getProperty(dbType + ".password"));

        // Configuración del pool
        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.maxPoolSize")));
        config.setMinimumIdle(Integer.parseInt(properties.getProperty("db.minIdle")));  
        config.setIdleTimeout(Integer.parseInt(properties.getProperty("db.idleTimeout")));
        config.setConnectionTimeout(Integer.parseInt(properties.getProperty("db.connectionTimeout")));

        // Configuraciones específicas según el tipo de base de datos
        if ("mysql".equals(dbType)) {
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        } else if ("postgresql".equals(dbType)) {
            // Configuraciones específicas para PostgreSQL (si es necesario)
        }
        dataSource = new HikariDataSource(config);
    }

    public Connection obtenerConexion() throws SQLException {
        return dataSource.getConnection();
    }

    public void cerrarPool() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}