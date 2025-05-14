package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Dispositivo;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.DispositivoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DispositivoDAOImpl extends BaseDAOImpl<Dispositivo> implements DispositivoDAO {

    @Override
    protected PreparedStatement getInsertPS(Connection conn, Dispositivo entity) throws SQLException {
        String query = "{CALL insertar_dispositivo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getDispositivoId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getModelo());
        cs.setString(4, entity.getNumeroSerie());
        cs.setDate(5, new java.sql.Date(entity.getFechaRegistro().getTime()));
        cs.setString(6, entity.getUbicacion());
        cs.setString(7, "S");
        cs.setDate(8, new java.sql.Date(entity.getUltimaConexion().getTime()));
        cs.setInt(9, entity.getGrupo().getGrupoId());
        return cs;
    }

    @Override
    protected PreparedStatement getUpdatePS(Connection conn, Dispositivo entity) throws SQLException {
        String query = "{CALL actualizar_dispositivo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, entity.getDispositivoId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getModelo());
        cs.setString(4, entity.getNumeroSerie());
        cs.setDate(5, new java.sql.Date(entity.getFechaRegistro().getTime()));
        cs.setString(6, entity.getUbicacion());
        if(entity.isActivo()){
            cs.setString(7, "S");
        }else{
            cs.setString(7, "N");
        }
        cs.setDate(8, new java.sql.Date(entity.getUltimaConexion().getTime()));
        cs.setInt(9, entity.getGrupo().getGrupoId());
        return cs;
    }

    @Override
    protected PreparedStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_dispositivo(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected PreparedStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_dispositivo(?)}";
        PreparedStatement cs = conn.prepareStatement(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected PreparedStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_configuracion()}";
        PreparedStatement cs = conn.prepareStatement(query);
        return cs;
    }

    @Override
    protected Dispositivo createFromResultSet(ResultSet rs) throws SQLException {
        Dispositivo dev = new Dispositivo();
        dev.setDispositivoId(rs.getInt("dispositivoid"));
        dev.setNombre(rs.getString("nombre"));
        dev.setModelo(rs.getString("modelo"));
        dev.setNumeroSerie(rs.getString("numeroserie"));
        dev.setFechaRegistro(rs.getDate("fecharegistro"));
        dev.setUbicacion(rs.getString("ubicacion"));
        if(rs.getString("activo").compareTo("S")==0){
            dev.setActivo(true);
        }else{
            dev.setActivo(false);
        }
        dev.setNivelBateria(rs.getInt("nivelbateria"));
        dev.setUltimaConexion(rs.getDate("ultimaconexion"));
        dev.getGrupo().setGrupoId(rs.getInt("grupo_grupoid"));
        return dev;
    }

    @Override
    protected void setId(Dispositivo entity, Integer id) {
        entity.setDispositivoId(id);
    }
    
}
