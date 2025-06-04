/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.persistencia.daoimpl;

import com.pucp.gestionlentesvr.dominio.Usuario.MetricaUso;
import com.pucp.gestionlentesvr.persistencia.BaseDAOImpl;
import com.pucp.gestionlentesvr.persistencia.dao.MetricaUsoDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author HP
 */
public class MetricaUsoDAOImpl extends BaseDAOImpl<MetricaUso> implements MetricaUsoDAO{

    @Override
    protected CallableStatement getInsertPS(Connection conn, MetricaUso entity) throws SQLException {
       String query = "{CALL insertar_metricauso(?, ?, ?, ?,?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setTimestamp(2, new java.sql.Timestamp(entity.getFechaRegistro().getTime()));
        cs.setInt(3, entity.getTiempoUsoMinutos());
        cs.setInt(4, entity.getNivelBateriaInicial());
        cs.setInt(5, entity.getNivelBateriaFinal());
        cs.setInt(6, entity.getUsuario().getUsuarioId()); 
        cs.setString(7, "S");

        return cs;
    }

    @Override
    protected CallableStatement getUpdatePS(Connection conn, MetricaUso entity) throws SQLException {
        String query = "{CALL actualizar_metricauso(?, ?, ?,  ?, ?, ?,?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, entity.getMetricaId());
        cs.setTimestamp(2, new java.sql.Timestamp(entity.getFechaRegistro().getTime()));
        cs.setInt(3, entity.getTiempoUsoMinutos());
        cs.setInt(4, entity.getNivelBateriaInicial());
        cs.setInt(5, entity.getNivelBateriaFinal());
        cs.setInt(6, entity.getUsuario().getUsuarioId()); 
        if(entity.isActivo()){
            cs.setString(7, "S");
        }else{
            cs.setString(7, "N");
        }

        return cs;
    }

    @Override
    protected CallableStatement getDeletePS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL eliminar_metricauso(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs;
    }

    @Override
    protected CallableStatement getSelectByIdPS(Connection conn, Integer id) throws SQLException {
        String query = "{CALL obtener_metricauso(?)}";
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, id);
        return cs; 
    }

    @Override
    protected CallableStatement getSelectAllPS(Connection conn) throws SQLException {
        String query = "{CALL listar_metricauso()}";
        CallableStatement cs = conn.prepareCall(query);
        return cs;  
    }

    @Override
    protected MetricaUso createFromResultSet(ResultSet rs) throws SQLException {
        MetricaUso metrica = new MetricaUso();
        metrica.setMetricaId(rs.getInt("metricaid"));
        metrica.setFechaRegistro(rs.getTimestamp("fecharegistro"));
        metrica.setTiempoUsoMinutos(rs.getInt("tiempousominutos"));
        metrica.setNivelBateriaInicial(rs.getInt("nivelbateriainicial"));
        metrica.setNivelBateriaFinal(rs.getInt("nivelbateriafinal"));
        metrica.getUsuario().setUsuarioId(rs.getInt("usuario_usuarioid"));
        if(rs.getString("activo").compareTo("S")==0){
            metrica.setActivo(true);
        }else{
            metrica.setActivo(false);
        }

        return metrica;
    }

    @Override
    protected void setId(MetricaUso entity, Integer id) {
       entity.setMetricaId(id);
    }
    
}
