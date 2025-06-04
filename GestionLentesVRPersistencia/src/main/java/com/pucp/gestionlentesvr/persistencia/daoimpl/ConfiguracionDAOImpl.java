package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.dispositivos.Configuracion;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.ConfiguracionDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ConfiguracionDAOImpl extends BaseDAOImpl<Configuracion> implements ConfiguracionDAO {

    @Override
    protected CallableStatement getInsertPS(Connection conn, Configuracion entity) throws SQLException {
        String query = "{CALL insertar_configuracion(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getDescripcion());
        cs.setDate(4, new java.sql.Date(entity.getFechaCreacion().getTime()));
        cs.setString(5, entity.getValor());
        cs.setInt(6, entity.getCreadoPor().getUsuarioId());
        cs.setString(7, "S");
        return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, Configuracion entity) throws SQLException {
        String query = "{CALL actualizar_configuracion(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, entity.getConfiguracionId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getDescripcion());
        cs.setDate(4, new java.sql.Date(entity.getFechaCreacion().getTime()));
        cs.setString(5, entity.getValor());
        cs.setInt(6, entity.getCreadoPor().getUsuarioId());
        if(entity.isActivo()){
            cs.setString(7, "S");
        }else{
            cs.setString(7, "N");
        }
        return cs;
    }

    @Override
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_configuracion(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_configuracion(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected CallableStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_configuracion()}";
        CallableStatement cs = conn.prepareCall(query);
        return cs;
    }

    @Override
    protected Configuracion createFromResultSet(ResultSet rs) throws SQLException {
        Configuracion con = new Configuracion();
        con.setConfiguracionId(rs.getInt("configuracionid"));
        con.setNombre(rs.getString("nombre"));
        con.setDescripcion(rs.getString("descripcion"));
        con.setFechaCreacion(rs.getDate("fechacreacion"));
        con.setValor(rs.getString("valor"));
        con.getCreadoPor().setUsuarioId(rs.getInt("usuario_usuarioid"));
        if(rs.getString("activo").compareTo("S")==0){
            con.setActivo(true);
        }else{
            con.setActivo(false);
        }
        return con;
    }

    @Override
    protected void setId(Configuracion entity, Integer id) {
        entity.setConfiguracionId(id);
    }
}
