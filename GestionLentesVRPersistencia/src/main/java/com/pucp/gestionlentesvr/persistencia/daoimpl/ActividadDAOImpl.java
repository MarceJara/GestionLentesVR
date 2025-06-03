package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Usuario.Usuario;
import com.pucp.gestionlentesvr.dominio.dispositivos.Actividad;
import com.pucp.gestionlentesvr.dominio.dispositivos.Dispositivo;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.ActividadDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ActividadDAOImpl extends BaseDAOImpl<Actividad> implements ActividadDAO {

    @Override
    protected CallableStatement getInsertPS(Connection conn, Actividad entity) throws SQLException {
        String query = "{CALL insertar_actividad(?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setDate(2, new java.sql.Date(entity.getFechaHora().getTime()));
        cs.setString(3, entity.getDescripcion());
        cs.setString(4, entity.getDetallesTecnicos());
        cs.setInt(5, entity.getUsuario().getUsuarioId());
        cs.setInt(6, entity.getDispositivoAfectado().getDispositivoId());
        cs.setInt(7, entity.getDispositivoAfectado().getGrupo().getGrupoId()); // Asumiendo que Dispositivo tiene un método getId()
        cs.setString(8, "S");
        return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, Actividad entity) throws SQLException {
        String query = "{CALL actualizar_actividad(?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, entity.getActividadId());
        cs.setDate(2, new java.sql.Date(entity.getFechaHora().getTime()));
        cs.setString(3, entity.getDescripcion());
        cs.setString(4, entity.getDetallesTecnicos());
        cs.setInt(5, entity.getUsuario().getUsuarioId());
        cs.setInt(6, entity.getDispositivoAfectado().getDispositivoId());
        cs.setInt(7, entity.getDispositivoAfectado().getGrupo().getGrupoId()); // Asumiendo que Dispositivo tiene un método getId()
        if(entity.isActivo()){
            cs.setString(8, "S");
        }else{
            cs.setString(8, "N");
        }
        return cs;
    }

    @Override
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_actividad(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_actividad(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected CallableStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_actividad()}";
        CallableStatement cs = conn.prepareCall(query);
        return cs;  
    }

    @Override
    protected Actividad createFromResultSet(ResultSet rs) throws SQLException {
        Actividad act = new Actividad();
        act.setActividadId(rs.getInt("actividadid"));
        act.setFechaHora(rs.getDate("fechahora"));
        act.setDescripcion(rs.getString("descripcion"));
        act.setDetallesTecnicos(rs.getString("detallestecnicos"));
        Usuario user = act.getUsuario();
        user.setUsuarioId(rs.getInt("usuario_usuarioid"));
        Dispositivo dis= act.getDispositivoAfectado();
        dis.setDispositivoId(rs.getInt("dispositivo_dispositivoid"));
        dis.getGrupo().setGrupoId(rs.getInt("dispositivo_grupo_grupoid"));
        if(rs.getString("activo").compareTo("S")==0){
            act.setActivo(true);
        }else{
            act.setActivo(false);
        }
        return act;
    }

    @Override
    protected void setId(Actividad entity, Integer id) {
        entity.setActividadId(id);
    }
    
}
