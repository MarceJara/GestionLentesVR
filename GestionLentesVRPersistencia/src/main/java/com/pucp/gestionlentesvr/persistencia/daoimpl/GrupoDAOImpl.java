package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Usuario.Grupo;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.GrupoDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class GrupoDAOImpl extends BaseDAOImpl<Grupo> implements GrupoDAO {

    @Override
    protected CallableStatement getInsertPS(Connection conn, Grupo entity) throws SQLException {
        String query = "{CALL insertar_grupo(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getDescripcion());
        cs.setDate(4, new java.sql.Date(entity.getFechaCreacion().getTime()));
        cs.setString(5, entity.getUbicacion());
        cs.setInt(6, entity.getResponsable().getUsuarioId()); // Asumiendo que Usuario tiene un método getId()
        cs.setString(7, "S");
    return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, Grupo entity) throws SQLException {
        String query = "{CALL actualizar_grupo(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
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
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_grupo(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_grupo(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_grupo(?)}";
        CallableStatement cs = conn.prepareCall(query);
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
