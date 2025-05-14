package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Usuario;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    protected PreparedStatement getInsertPS(Connection conn, Usuario entity) throws SQLException {
        String query = "{CALL insertar_usuario(?, ?, ?, ?,?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getUsuarioId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getApellido());
        cs.setString(4, entity.getCorreo());
        cs.setString(5, entity.getContrasena());
        cs.setTimestamp(6, new java.sql.Timestamp(entity.getFechaCreacion().getTime()));
        cs.setString(7, "S");
        cs.setInt(8, entity.getRol().getRolId());
        return cs;
    }

    @Override
    protected PreparedStatement getUpdatePS(Connection conn, Usuario entity) throws SQLException {
        String query = "{CALL actualizar_usuario(?, ?, ?, ?,?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getUsuarioId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getApellido());
        cs.setString(4, entity.getCorreo());
        cs.setString(5, entity.getContrasena());
        cs.setTimestamp(6, new java.sql.Timestamp(entity.getFechaCreacion().getTime()));
        if(entity.isActivo()){
            cs.setString(7, "S");
        }else{
            cs.setString(7, "N");
        }
        cs.setInt(8, entity.getRol().getRolId());
        return cs;
    }

    @Override
    protected PreparedStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_usuario(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected PreparedStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_usuario(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected PreparedStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_usuario(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        return cs;
    }

    @Override
    protected Usuario createFromResultSet(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(rs.getInt("usuarioid"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setContrasena(rs.getString("contrasena"));
        usuario.setFechaCreacion(rs.getTimestamp("fechacreacion"));
        usuario.getRol().setRolId(rs.getInt("rol_rolid"));
        if(rs.getString("activo").compareTo("S")==0){
            usuario.setActivo(true);
        }else{
            usuario.setActivo(false);
        }

        return usuario;
    }

    @Override
    protected void setId(Usuario entity, Integer id) {
        entity.setUsuarioId(id);
    }
    
}
