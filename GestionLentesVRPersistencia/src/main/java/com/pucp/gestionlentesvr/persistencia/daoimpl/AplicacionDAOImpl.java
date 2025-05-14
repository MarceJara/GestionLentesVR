package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Aplicacion;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.AplicacionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AplicacionDAOImpl extends BaseDAOImpl<Aplicacion> implements AplicacionDAO {

    @Override
    protected PreparedStatement getInsertPS(Connection conn, Aplicacion entity) throws SQLException {
        String query = "{CALL insertar_aplicacion(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
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
    protected PreparedStatement getUpdatePS(Connection conn, Aplicacion entity) throws SQLException {
        String query = "{CALL actualizar_aplicacion(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getAplicacionId());
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
    protected PreparedStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_aplicacion(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected PreparedStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_aplicacion(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected PreparedStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_actividad()}";
        PreparedStatement cs = conn.prepareStatement(query);
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
