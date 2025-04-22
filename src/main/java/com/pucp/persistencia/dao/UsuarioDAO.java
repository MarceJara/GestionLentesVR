package com.pucp.persistencia.dao;

import com.pucp.usuario.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario> {

    @Override
    public Usuario get(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE usuarioid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUsuarioFromResultSet(rs);
            }
            return null;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        String query = "SELECT * FROM usuario";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(extractUsuarioFromResultSet(rs));
            }
            return usuarios;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public void save(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (usuarioid, nombre, correo) VALUES (?, ?, ?)";
        executeUpdate(query,
            usuario.getUsuarioId(),
            usuario.getNombre(),
            usuario.getCorreo()
        );
    }

    @Override
    public void update(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombre = ?, correo = ? WHERE usuarioid = ?";
        executeUpdate(query,
            usuario.getNombre(),
            usuario.getCorreo(),
            usuario.getUsuarioId()
        );
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE usuarioid = ?";
        executeUpdate(query, id);
    }

    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM usuario";
        Object result = executeScalar(query);
        return result != null ? ((Number) result).intValue() : 0;
    }

    @Override
    public List<Usuario> getByPage(int page, int pageSize) throws SQLException {
        String query = "SELECT * FROM usuario LIMIT ? OFFSET ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, (page - 1) * pageSize);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(extractUsuarioFromResultSet(rs));
            }
            return usuarios;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public boolean exists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM usuario WHERE usuarioid = ?";
        Object result = executeScalar(query, id);
        return result != null && ((Number) result).intValue() > 0;
    }

    private Usuario extractUsuarioFromResultSet(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(rs.getInt("usuarioid"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setCorreo(rs.getString("correo"));
        return usuario;
    }
}
