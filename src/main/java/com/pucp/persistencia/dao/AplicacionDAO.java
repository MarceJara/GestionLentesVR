package com.pucp.persistencia.dao;

import com.pucp.aplicacion.Aplicacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AplicacionDAO extends GenericDAO<Aplicacion> {
    
    @Override
    public Aplicacion get(int id) throws SQLException {
        String query = "SELECT * FROM aplicacion WHERE aplicacionid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return extractAplicacionFromResultSet(rs);
            }
            return null;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    @Override
    public List<Aplicacion> getAll() throws SQLException {
        String query = "SELECT * FROM aplicacion";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                aplicaciones.add(extractAplicacionFromResultSet(rs));
            }
            return aplicaciones;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    @Override
    public void save(Aplicacion aplicacion) throws SQLException {
        String query = "INSERT INTO aplicacion (aplicacionid, nombre, version, desarrollador, " +
                      "fechalanzamiento, descripcion, tamanomb, rutainstalador) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        executeUpdate(query,
            aplicacion.getAplicacionId(),
            aplicacion.getNombre(),
            aplicacion.getVersion(),
            aplicacion.getDesarrollador(),
            aplicacion.getFechaLanzamiento() != null ? new Timestamp(aplicacion.getFechaLanzamiento().getTime()) : null,
            aplicacion.getDescripcion(),
            aplicacion.getTamanoMB(),
            aplicacion.getRutaInstalador()
        );
    }
    
    @Override
    public void update(Aplicacion aplicacion) throws SQLException {
        String query = "UPDATE aplicacion SET nombre = ?, version = ?, desarrollador = ?, " +
                      "fechalanzamiento = ?, descripcion = ?, tamanomb = ?, rutainstalador = ? " +
                      "WHERE aplicacionid = ?";
        
        executeUpdate(query,
            aplicacion.getNombre(),
            aplicacion.getVersion(),
            aplicacion.getDesarrollador(),
            aplicacion.getFechaLanzamiento() != null ? new Timestamp(aplicacion.getFechaLanzamiento().getTime()) : null,
            aplicacion.getDescripcion(),
            aplicacion.getTamanoMB(),
            aplicacion.getRutaInstalador(),
            aplicacion.getAplicacionId()
        );
    }
    
    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM aplicacion WHERE aplicacionid = ?";
        executeUpdate(query, id);
    }
    
    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM aplicacion";
        Object result = executeScalar(query);
        return result != null ? ((Number) result).intValue() : 0;
    }
    
    @Override
    public List<Aplicacion> getByPage(int page, int pageSize) throws SQLException {
        String query = "SELECT * FROM aplicacion LIMIT ? OFFSET ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, (page - 1) * pageSize);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                aplicaciones.add(extractAplicacionFromResultSet(rs));
            }
            return aplicaciones;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    @Override
    public boolean exists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM aplicacion WHERE aplicacionid = ?";
        Object result = executeScalar(query, id);
        return result != null && ((Number) result).intValue() > 0;
    }
    
    // Métodos específicos de AplicacionDAO
    public List<Aplicacion> getByNombre(String nombre) throws SQLException {
        String query = "SELECT * FROM aplicacion WHERE nombre LIKE ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + nombre + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                aplicaciones.add(extractAplicacionFromResultSet(rs));
            }
            return aplicaciones;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    public List<Aplicacion> getByDesarrollador(String desarrollador) throws SQLException {
        String query = "SELECT * FROM aplicacion WHERE desarrollador = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, desarrollador);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                aplicaciones.add(extractAplicacionFromResultSet(rs));
            }
            return aplicaciones;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    public List<Aplicacion> getByTamanioMenorQue(double tamanoMb) throws SQLException {
        String query = "SELECT * FROM aplicacion WHERE tamanomb < ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setDouble(1, tamanoMb);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                aplicaciones.add(extractAplicacionFromResultSet(rs));
            }
            return aplicaciones;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    public List<Aplicacion> getByFechaLanzamientoPosteriorA(java.util.Date fecha) throws SQLException {
        String query = "SELECT * FROM aplicacion WHERE fechalanzamiento > ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setTimestamp(1, new Timestamp(fecha.getTime()));
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                aplicaciones.add(extractAplicacionFromResultSet(rs));
            }
            return aplicaciones;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    private Aplicacion extractAplicacionFromResultSet(ResultSet rs) throws SQLException {
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setAplicacionId(rs.getInt("aplicacionid"));
        aplicacion.setNombre(rs.getString("nombre"));
        aplicacion.setVersion(rs.getString("version"));
        aplicacion.setDesarrollador(rs.getString("desarrollador"));
        
        Timestamp fechaLanzamiento = rs.getTimestamp("fechalanzamiento");
        if (fechaLanzamiento != null) {
            aplicacion.setFechaLanzamiento(new java.util.Date(fechaLanzamiento.getTime()));
        }
        
        aplicacion.setDescripcion(rs.getString("descripcion"));
        aplicacion.setTamanoMB(rs.getDouble("tamanomb"));
        aplicacion.setRutaInstalador(rs.getString("rutainstalador"));
        return aplicacion;
    }
}