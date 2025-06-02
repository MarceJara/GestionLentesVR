package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.dispositivos.Aplicacion;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.AplicacionDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AplicacionDAOImpl extends BaseDAOImpl<Aplicacion> implements AplicacionDAO {

    @Override
    protected CallableStatement getInsertPS(Connection conn, Aplicacion entity) throws SQLException {
        String query = "{CALL insertar_aplicacion(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, entity.getAplicacionId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getVersion());
        cs.setString(4, entity.getDesarrollador());
        cs.setDate(5, new java.sql.Date(entity.getFechaLanzamiento().getTime()));
        cs.setString(6, entity.getDescripcion());
        cs.setDouble(7, entity.getTamanoMB());
        cs.setString(8, entity.getRutaInstalador());
        cs.setString(9, "S");
        return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, Aplicacion entity) throws SQLException {
        String query = "{CALL actualizar_aplicacion(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getVersion());
        cs.setString(4, entity.getDesarrollador());
        cs.setDate(5, new java.sql.Date(entity.getFechaLanzamiento().getTime()));
        cs.setString(6, entity.getDescripcion());
        cs.setDouble(7, entity.getTamanoMB());
        cs.setString(8, entity.getRutaInstalador());
        if(entity.isActivo()){
            cs.setString(9, "S");
        }else{
            cs.setString(9, "N");
        }
        return cs;
    }

    @Override
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_aplicacion(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_aplicacion(?)}";
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
    protected Aplicacion createFromResultSet(ResultSet rs) throws SQLException {
        Aplicacion app = new Aplicacion();
        app.setAplicacionId(rs.getInt("aplicacionid"));
        app.setNombre(rs.getString("nombre"));
        app.setVersion(rs.getString("version"));
        app.setDescripcion(rs.getString("desarrollador"));
        app.setFechaLanzamiento(rs.getDate("fechalanzamiento"));
        app.setDescripcion(rs.getString("descripcion"));
        app.setTamanoMB(rs.getDouble("tamanomb"));
        app.setRutaInstalador(rs.getString("rutainstalador"));
        if(rs.getString("activo").compareTo("S")==0){
            app.setActivo(true);
        }else{
            app.setActivo(false);
        }
        return app;
    }

    @Override
    protected void setId(Aplicacion entity, Integer id) {
        entity.setAplicacionId(id);
    }    
}
