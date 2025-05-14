package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Grupo;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.GrupoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrupoDAOImpl extends BaseDAOImpl<Grupo> implements GrupoDAO {

    @Override
    protected PreparedStatement getInsertPS(Connection conn, Grupo entity) throws SQLException {
        String query = "{CALL insertar_grupo(?, ?, ?, ?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getGrupoId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getDescripcion());
        cs.setDate(4, new java.sql.Date(entity.getFechaCreacion().getTime()));
        cs.setString(5, entity.getUbicacion());
        cs.setInt(6, entity.getResponsable().getUsuarioId()); // Asumiendo que Usuario tiene un método getId()
        cs.setString(7, "S");
    return cs;
    }

    @Override
    protected PreparedStatement getUpdatePS(Connection conn, Grupo entity) throws SQLException {
        String query = "{CALL actualizar_grupo(?, ?, ?, ?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getGrupoId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getDescripcion());
        cs.setDate(4, new java.sql.Date(entity.getFechaCreacion().getTime()));
        cs.setString(5, entity.getUbicacion());
        cs.setInt(6, entity.getResponsable().getUsuarioId()); 
        if(entity.isActivo()){
            cs.setString(7, "S");
        }else{
            cs.setString(7, "N");
        }
        return cs;
    }

    @Override
    protected PreparedStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_grupo(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected PreparedStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_grupo(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected PreparedStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_grupo(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        return cs;
    }

    @Override
    protected Grupo createFromResultSet(ResultSet rs) throws SQLException {
        Grupo grupo = new Grupo();
        grupo.setGrupoId(rs.getInt("grupo_id"));
        grupo.setNombre(rs.getString("nombre"));
        grupo.setDescripcion(rs.getString("descripcion"));
        grupo.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
        grupo.setUbicacion(rs.getString("ubicacion"));
        grupo.getResponsable().setUsuarioId(rs.getInt("responsable_id"));
        if(rs.getString("activo").compareTo("S")==0){
            grupo.setActivo(true);
        }else{
            grupo.setActivo(false);
        }

        return grupo;
    }

    @Override
    protected void setId(Grupo entity, Integer id) {
        entity.setGrupoId(id);
    }
    
}
