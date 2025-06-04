package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.dispositivos.Dispositivo;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.DispositivoDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DispositivoDAOImpl extends BaseDAOImpl<Dispositivo> implements DispositivoDAO {

    @Override
    protected CallableStatement getInsertPS(Connection conn, Dispositivo entity) throws SQLException {
        String query = "{CALL insertar_dispositivo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getModelo());
        cs.setString(4, entity.getNumeroSerie());
        cs.setDate(5, new java.sql.Date(entity.getFechaRegistro().getTime()));
        cs.setString(6, entity.getUbicacion());
        cs.setString(7, "S");
        cs.setInt(8, entity.getNivelBateria());
        cs.setDate(9, new java.sql.Date(entity.getUltimaConexion().getTime()));
        cs.setInt(10, entity.getGrupo().getGrupoId());
        return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, Dispositivo entity) throws SQLException {
        String query = "{CALL actualizar_dispositivo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
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
        cs.setInt(8, entity.getNivelBateria());
        cs.setDate(9, new java.sql.Date(entity.getUltimaConexion().getTime()));
        cs.setInt(10, entity.getGrupo().getGrupoId());
        return cs;
    }

    @Override
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_dispositivo(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_dispositivo(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected CallableStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_dispositivo()}";
        CallableStatement cs = conn.prepareCall(query);
        return cs;
    }

    @Override
    protected Dispositivo createFromResultSet(ResultSet rs) throws SQLException {
        Dispositivo dev = new Dispositivo();
        dev.setDispositivoId(rs.getInt("dispositivoid"));
        dev.setNombre(rs.getString("nombre"));
        dev.setModelo(rs.getString("modelo"));
        dev.setNumeroSerie(rs.getString("numeroserie"));
        dev.setFechaRegistro(new java.util.Date(rs.getDate("fecharegistro").getTime()));
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
