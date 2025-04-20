package com.vregister.persistencia.dao;

import com.vregister.domain.Actividad;
import com.vregister.domain.Usuario;
import com.vregister.domain.Dispositivo;
import com.vregister.domain.TipoActividad;
import com.vregister.persistencia.conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAO extends GenericDAO<Actividad> {
    
    private UsuarioDAO usuarioDAO;
    private DispositivoDAO dispositivoDAO;
    
    public ActividadDAO() {
        super();
        this.usuarioDAO = new UsuarioDAO();
        this.dispositivoDAO = new DispositivoDAO();
    }
    
    @Override
    public Actividad get(int id) throws SQLException {
        String query = "SELECT * FROM actividad WHERE actividadid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return extractActividadFromResultSet(rs);
            }
            return null;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    @Override
    public List<Actividad> getAll() throws SQLException {
        String query = "SELECT * FROM actividad";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Actividad> actividades = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                actividades.add(extractActividadFromResultSet(rs));
            }
            return actividades;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    @Override
    public void save(Actividad actividad) throws SQLException {
        String query = "INSERT INTO actividad (actividadid, fechahora, descripcion, detallestecnicos, " +
                      "usuario_usuarioid, dispositivo_dispositivoid, dispositivo_grupo_grupoid, tipoactividad) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        executeUpdate(query, 
            actividad.getActividadId(),
            new Timestamp(actividad.getFechaHora().getTime()),
            actividad.getDescripcion(),
            actividad.getDetallesTecnicos(),
            actividad.getUsuario() != null ? actividad.getUsuario().getUsuarioId() : null,
            actividad.getDispositivoAfectado() != null ? actividad.getDispositivoAfectado().getDispositivoId() : null,
            actividad.getDispositivoAfectado() != null ? actividad.getDispositivoAfectado().getGrupo().getGrupoId() : null,
            actividad.getTipoActividad() != null ? actividad.getTipoActividad().toString() : null
        );
    }
    
    @Override
    public void update(Actividad actividad) throws SQLException {
        String query = "UPDATE actividad SET fechahora = ?, descripcion = ?, detallestecnicos = ?, " +
                      "usuario_usuarioid = ?, dispositivo_dispositivoid = ?, dispositivo_grupo_grupoid = ?, " +
                      "tipoactividad = ? WHERE actividadid = ?";
        
        executeUpdate(query,
            new Timestamp(actividad.getFechaHora().getTime()),
            actividad.getDescripcion(),
            actividad.getDetallesTecnicos(),
            actividad.getUsuario() != null ? actividad.getUsuario().getUsuarioId() : null,
            actividad.getDispositivoAfectado() != null ? actividad.getDispositivoAfectado().getDispositivoId() : null,
            actividad.getDispositivoAfectado() != null ? actividad.getDispositivoAfectado().getGrupo().getGrupoId() : null,
            actividad.getTipoActividad() != null ? actividad.getTipoActividad().toString() : null,
            actividad.getActividadId()
        );
    }
    
    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM actividad WHERE actividadid = ?";
        executeUpdate(query, id);
    }
    
    // Métodos específicos de ActividadDAO
    public List<Actividad> getByUsuario(Usuario usuario) throws SQLException {
        String query = "SELECT * FROM actividad WHERE usuario_usuarioid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Actividad> actividades = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, usuario.getUsuarioId());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                actividades.add(extractActividadFromResultSet(rs));
            }
            return actividades;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    public List<Actividad> getByDispositivo(Dispositivo dispositivo) throws SQLException {
        String query = "SELECT * FROM actividad WHERE dispositivo_dispositivoid = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Actividad> actividades = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, dispositivo.getDispositivoId());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                actividades.add(extractActividadFromResultSet(rs));
            }
            return actividades;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    public List<Actividad> getByTipoActividad(TipoActividad tipo) throws SQLException {
        String query = "SELECT * FROM actividad WHERE tipoactividad = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Actividad> actividades = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, tipo.toString());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                actividades.add(extractActividadFromResultSet(rs));
            }
            return actividades;
        } finally {
            closeResources(rs, stmt);
        }
    }
    
    private Actividad extractActividadFromResultSet(ResultSet rs) throws SQLException {
        Actividad actividad = new Actividad();
        actividad.setActividadId(rs.getInt("actividadid"));
        actividad.setFechaHora(rs.getTimestamp("fechahora"));
        actividad.setDescripcion(rs.getString("descripcion"));
        actividad.setDetallesTecnicos(rs.getString("detallestecnicos"));
        
        // Cargar el usuario asociado
        int usuarioId = rs.getInt("usuario_usuarioid");
        if (!rs.wasNull()) {
            Usuario usuario = usuarioDAO.get(usuarioId);
            actividad.setUsuario(usuario);
        }
        
        // Cargar el dispositivo asociado
        int dispositivoId = rs.getInt("dispositivo_dispositivoid");
        if (!rs.wasNull()) {
            Dispositivo dispositivo = dispositivoDAO.get(dispositivoId);
            actividad.setDispositivoAfectado(dispositivo);
        }
        
        // Cargar el tipo de actividad
        String tipoActividadStr = rs.getString("tipoactividad");
        if (tipoActividadStr != null) {
            try {
                TipoActividad tipoActividad = TipoActividad.valueOf(tipoActividadStr);
                actividad.setTipoActividad(tipoActividad);
            } catch (IllegalArgumentException e) {
                // Manejar el caso donde el valor no es válido
                System.err.println("Tipo de actividad desconocido: " + tipoActividadStr);
            }
        }
        
        return actividad;
    }
}