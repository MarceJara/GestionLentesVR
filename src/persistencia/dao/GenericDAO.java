package com.vregister.persistencia.dao;

import com.vregister.persistencia.conexion.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T> {
    protected Connection connection;
    
    public GenericDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Métodos CRUD abstractos que deben ser implementados por las clases hijas
    public abstract T get(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
    public abstract void save(T t) throws SQLException;
    public abstract void update(T t) throws SQLException;
    public abstract void delete(int id) throws SQLException;
    
    // Método para ejecutar queries de consulta
    protected ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        setParameters(stmt, params);
        return stmt.executeQuery();
    }
    
    // Método para ejecutar queries de actualización (INSERT, UPDATE, DELETE)
    protected int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        setParameters(stmt, params);
        return stmt.executeUpdate();
    }
    
    // Método para obtener el ID generado después de un INSERT
    protected int executeInsert(String query, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        setParameters(stmt, params);
        stmt.executeUpdate();
        
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return -1;
    }
    
    // Método auxiliar para establecer parámetros en PreparedStatement
    private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof Integer) {
                stmt.setInt(i + 1, (Integer) params[i]);
            } else if (params[i] instanceof String) {
                stmt.setString(i + 1, (String) params[i]);
            } else if (params[i] instanceof Double) {
                stmt.setDouble(i + 1, (Double) params[i]);
            } else if (params[i] instanceof Timestamp) {
                stmt.setTimestamp(i + 1, (Timestamp) params[i]);
            } else if (params[i] instanceof java.util.Date) {
                stmt.setTimestamp(i + 1, new Timestamp(((java.util.Date) params[i]).getTime()));
            } else if (params[i] == null) {
                stmt.setNull(i + 1, Types.NULL);
            }
        }
    }
    
    // Método para cerrar recursos
    protected void closeResources(ResultSet rs, PreparedStatement stmt) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}