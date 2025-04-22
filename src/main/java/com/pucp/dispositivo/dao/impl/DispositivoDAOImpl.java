package com.pucp.dispositivo.dao.impl;

import com.pucp.dispositivo.Dispositivo;
import com.pucp.dispositivo.dao.DispositivoDAO;
import com.pucp.persistencia.conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DispositivoDAOImpl implements DispositivoDAO {

    @Override
    public int insertar(Dispositivo dispositivo) {
        int resultado = 0;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO dispositivo (nombre, modelo, numero_serie, ubicacion, activo) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, dispositivo.getNombre());
            stmt.setString(2, dispositivo.getModelo());
            stmt.setString(3, dispositivo.getNumeroSerie());
            stmt.setString(4, dispositivo.getUbicacion());
            stmt.setBoolean(5, dispositivo.isActivo());

            resultado = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int actualizar(Dispositivo dispositivo) {
        int resultado = 0;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE dispositivo SET nombre = ?, modelo = ?, numero_serie = ?, ubicacion = ?, activo = ? WHERE dispositivo_id = ?")) {

            stmt.setString(1, dispositivo.getNombre());
            stmt.setString(2, dispositivo.getModelo());
            stmt.setString(3, dispositivo.getNumeroSerie());
            stmt.setString(4, dispositivo.getUbicacion());
            stmt.setBoolean(5, dispositivo.isActivo());
            stmt.setInt(6, dispositivo.getDispositivoId());

            resultado = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int eliminar(int idDispositivo) {
        int resultado = 0;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM dispositivo WHERE dispositivo_id = ?")) {

            stmt.setInt(1, idDispositivo);
            resultado = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List<Dispositivo> listar() {
        List<Dispositivo> dispositivos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dispositivo");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dispositivo d = new Dispositivo();
                d.setDispositivoId(rs.getInt("dispositivo_id"));
                d.setNombre(rs.getString("nombre"));
                d.setModelo(rs.getString("modelo"));
                d.setNumeroSerie(rs.getString("numero_serie"));
                d.setUbicacion(rs.getString("ubicacion"));
                d.setActivo(rs.getBoolean("activo"));
                dispositivos.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dispositivos;
    }

    @Override
    public Dispositivo obtenerPorId(int idDispositivo) {
        Dispositivo d = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dispositivo WHERE dispositivo_id = ?")) {

            stmt.setInt(1, idDispositivo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    d = new Dispositivo();
                    d.setDispositivoId(rs.getInt("dispositivo_id"));
                    d.setNombre(rs.getString("nombre"));
                    d.setModelo(rs.getString("modelo"));
                    d.setNumeroSerie(rs.getString("numero_serie"));
                    d.setUbicacion(rs.getString("ubicacion"));
                    d.setActivo(rs.getBoolean("activo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }
}
