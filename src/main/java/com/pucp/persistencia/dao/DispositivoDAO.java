package com.pucp.persistencia.dao;

import com.pucp.dispositivo.Dispositivo;
import com.pucp.usuario.Grupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DispositivoDAO extends GenericDAO<Dispositivo> {

    private GrupoDAO grupoDAO;

    public DispositivoDAO() {
        super();
        this.grupoDAO = new GrupoDAO();
    }

    @Override
    public Dispositivo get(int id) throws SQLException {
        String query = "SELECT * FROM dispositivo WHERE dispositivoid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return extractDispositivoFromResultSet(rs);
            }
            return null;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public List<Dispositivo> getAll() throws SQLException {
        String query = "SELECT * FROM dispositivo";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Dispositivo> dispositivos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                dispositivos.add(extractDispositivoFromResultSet(rs));
            }
            return dispositivos;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public void save(Dispositivo dispositivo) throws SQLException {
        String query = "INSERT INTO dispositivo (dispositivoid, nombre, modelo, numeroserie, ubicacion, grupo_grupoid) VALUES (?, ?, ?, ?, ?, ?)";
        executeUpdate(query,
            dispositivo.getDispositivoId(),
            dispositivo.getNombre(),
            dispositivo.getModelo(),
            dispositivo.getNumeroSerie(),
            dispositivo.getUbicacion(),
            dispositivo.getGrupo() != null ? dispositivo.getGrupo().getGrupoId() : null
        );
    }

    @Override
    public void update(Dispositivo dispositivo) throws SQLException {
        String query = "UPDATE dispositivo SET nombre = ?, grupo_grupoid = ? WHERE dispositivoid = ?";
        executeUpdate(query,
            dispositivo.getNombre(),
            dispositivo.getGrupo() != null ? dispositivo.getGrupo().getGrupoId() : null,
            dispositivo.getDispositivoId()
        );
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM dispositivo WHERE dispositivoid = ?";
        executeUpdate(query, id);
    }

    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM dispositivo";
        Object result = executeScalar(query);
        return result != null ? ((Number) result).intValue() : 0;
    }

    @Override
    public List<Dispositivo> getByPage(int page, int pageSize) throws SQLException {
        String query = "SELECT * FROM dispositivo LIMIT ? OFFSET ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Dispositivo> dispositivos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, pageSize);
            stmt.setInt(2, (page - 1) * pageSize);
            rs = stmt.executeQuery();

            while (rs.next()) {
                dispositivos.add(extractDispositivoFromResultSet(rs));
            }
            return dispositivos;
        } finally {
            closeResources(rs, stmt);
        }
    }

    @Override
    public boolean exists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM dispositivo WHERE dispositivoid = ?";
        Object result = executeScalar(query, id);
        return result != null && ((Number) result).intValue() > 0;
    }

    private Dispositivo extractDispositivoFromResultSet(ResultSet rs) throws SQLException {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setDispositivoId(rs.getInt("dispositivoid"));
        dispositivo.setNombre(rs.getString("nombre"));

        int grupoId = rs.getInt("grupo_grupoid");
        if (!rs.wasNull()) {
            Grupo grupo = grupoDAO.get(grupoId);
            dispositivo.setGrupo(grupo);
        }

        return dispositivo;
    }
}
