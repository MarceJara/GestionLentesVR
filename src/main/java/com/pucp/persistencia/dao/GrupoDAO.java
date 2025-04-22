package com.pucp.persistencia.dao;

import com.pucp.usuario.Grupo;
import com.pucp.persistencia.conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO extends GenericDAO<Grupo> {

    public GrupoDAO() {
        super();
    }

    @Override
    public Grupo get(int id) throws SQLException {
        String query = "SELECT * FROM grupo WHERE grupoid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return extractGrupoFromResultSet(rs);
            }
            return null;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public List<Grupo> getAll() throws SQLException {
        String query = "SELECT * FROM grupo";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Grupo> grupos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                grupos.add(extractGrupoFromResultSet(rs));
            }
            return grupos;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public void save(Grupo grupo) throws SQLException {
        String query = "INSERT INTO grupo (grupoid, nombre) VALUES (?, ?)";
        executeUpdate(query, grupo.getGrupoId(), grupo.getNombre());
    }

    @Override
    public void update(Grupo grupo) throws SQLException {
        String query = "UPDATE grupo SET nombre = ? WHERE grupoid = ?";
        executeUpdate(query, grupo.getNombre(), grupo.getGrupoId());
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM grupo WHERE grupoid = ?";
        executeUpdate(query, id);
    }

    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM grupo";
        Object result = executeScalar(query);
        return result != null ? ((Number) result).intValue() : 0;
    }

    @Override
    public List<Grupo> getByPage(int page, int pageSize) throws SQLException {
        String query = "SELECT * FROM grupo LIMIT ? OFFSET ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Grupo> grupos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, (page - 1) * pageSize);
            rs = stmt.executeQuery();
            while (rs.next()) {
                grupos.add(extractGrupoFromResultSet(rs));
            }
            return grupos;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public boolean exists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM grupo WHERE grupoid = ?";
        Object result = executeScalar(query, id);
        return result != null && ((Number) result).intValue() > 0;
    }

    private Grupo extractGrupoFromResultSet(ResultSet rs) throws SQLException {
        Grupo grupo = new Grupo();
        grupo.setGrupoId(rs.getInt("grupoid"));
        grupo.setNombre(rs.getString("nombre"));
        return grupo;
    }
}
