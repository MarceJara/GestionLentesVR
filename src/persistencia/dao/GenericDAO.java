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
    public abstract T get(int id) throws SQLException; // Obtener por ID
    public abstract List<T> getAll() throws SQLException; // Listar todos
    public abstract void save(T t) throws SQLException; // Insertar
    public abstract void update(T t) throws SQLException; // Modificar
    public abstract void delete(int id) throws SQLException; // Eliminar
    
    // Métodos adicionales comunes que pueden ser útiles
    public abstract int count() throws SQLException; // Contar registros
    public abstract List<T> getByPage(int page, int pageSize) throws SQLException; // Paginación
    public abstract boolean exists(int id) throws SQLException; // Verificar existencia
    
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
    
    // Método para ejecutar queries que retornan un solo valor (COUNT, MAX, etc.)
    protected Object executeScalar(String query, Object... params) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(query);
            setParameters(stmt, params);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getObject(1);
            }
            return null;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    // Método para ejecutar transacciones
    protected void executeTransaction(TransactionCallback callback) throws SQLException {
        try {
            connection.setAutoCommit(false);
            callback.execute(connection);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
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
            } else if (params[i] instanceof Boolean) {
                stmt.setBoolean(i + 1, (Boolean) params[i]);
            } else if (params[i] instanceof Float) {
                stmt.setFloat(i + 1, (Float) params[i]);
            } else if (params[i] instanceof Long) {
                stmt.setLong(i + 1, (Long) params[i]);
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
    
    // Interface funcional para transacciones
    @FunctionalInterface
    protected interface TransactionCallback {
        void execute(Connection connection) throws SQLException;
    }
}