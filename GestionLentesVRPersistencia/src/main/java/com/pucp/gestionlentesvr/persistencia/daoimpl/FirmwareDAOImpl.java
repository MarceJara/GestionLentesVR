package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.dispositivos.Firmware;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.FirmwareDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class FirmwareDAOImpl extends BaseDAOImpl<Firmware> implements FirmwareDAO {

    @Override
    protected CallableStatement getInsertPS(Connection conn, Firmware entity) throws SQLException {
        String query = "{CALL insertar_firmware(?, ?, ?, ?,?, ?, ?, ?,?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getVersion());
        cs.setDate(4, new java.sql.Date(entity.getFechaLanzamiento().getTime()));
        cs.setString(5, entity.getDescripcion());
        cs.setString(6, entity.getRutaArchivo());
        cs.setInt(7, entity.getDispositivo().getDispositivoId()); 
        cs.setInt(8, entity.getGrupo().getGrupoId()); 
        cs.setString(7, "S");
        return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, Firmware entity) throws SQLException {
       String query = "{CALL actualizar_firmware(?, ?, ?, ?,?, ?, ?, ?,?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, entity.getFirmwareId());
        cs.setString(2, entity.getNombre());
        cs.setString(3, entity.getVersion());
        cs.setDate(4, new java.sql.Date(entity.getFechaLanzamiento().getTime()));
        cs.setString(5, entity.getDescripcion());
        cs.setString(6, entity.getRutaArchivo());
        cs.setInt(7, entity.getDispositivo().getDispositivoId());
        cs.setInt(8, entity.getGrupo().getGrupoId()); 
        if(entity.isActivo()){
            cs.setString(9, "S");
        }else{
            cs.setString(9, "N");
        }
        return cs;
    }

    @Override
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_firmware(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_firmware(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected CallableStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_firmware()}";
        CallableStatement cs = conn.prepareCall(query);
        return cs;  
    }

    @Override
    protected Firmware createFromResultSet(ResultSet rs) throws SQLException {
        Firmware firm = new Firmware();
        firm.setFirmwareId(rs.getInt("firmwareid"));
        firm.setNombre(rs.getString("nombre"));
        firm.setVersion(rs.getString("version"));
        firm.setFechaLanzamiento(rs.getTimestamp("fechalanzamiento"));
        firm.setDescripcion(rs.getString("descripcion"));
        firm.setRutaArchivo(rs.getString("rutaarchivo"));
        firm.getDispositivo().setDispositivoId(rs.getInt("dispositivo_dispositivoid"));
        firm.getGrupo().setGrupoId(rs.getInt("dispositivo_grupo_grupoid"));
        if(rs.getString("activo").compareTo("S")==0){
            firm.setActivo(true);
        }else{
            firm.setActivo(false);
        }
        return firm;
    }
    
    @Override
    protected void setId(Firmware entity, Integer id) {
        entity.setFirmwareId(id);
    }
    
}
