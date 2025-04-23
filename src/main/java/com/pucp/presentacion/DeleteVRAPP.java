package com.pucp.presentacion;

import com.pucp.aplicacion.Aplicacion;
import com.pucp.dispositivo.Dispositivo;
import com.pucp.usuario.Grupo;
import com.pucp.usuario.Usuario;
import com.pucp.persistencia.dao.*;

import java.sql.SQLException;

public class DeleteVRAPP {

    public static void main(String[] args) {
        try {
            
            GrupoDAO grupoDAO = new GrupoDAO();
            if (grupoDAO.exists(1)) {
                grupoDAO.delete(1);
                System.out.println("Grupo con ID " + 1 + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró un grupo con ID " + 1 + ".");
            }  
            
            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            if (dispositivoDAO.exists(68)) {
                dispositivoDAO.delete(68);
                System.out.println("Dispositivo con ID " + 68 + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un dispositivo con ID " + 68 + ".");
            }
            
            if (dispositivoDAO.exists(70)) {
                dispositivoDAO.delete(70);
                System.out.println("Dispositivo con ID " + 70 + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un dispositivo con ID " + 70 + ".");
            }  
            
            AplicacionDAO aplicacionDAO = new AplicacionDAO();
            if (aplicacionDAO.exists(100)) {
                aplicacionDAO.delete(100);
                System.out.println("Aplicación con ID " + 100 + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró una aplicación con ID " + 100 + ".");
            }
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.exists(1)) {
                usuarioDAO.delete(1);
                System.out.println("El usuario Fabian se  ha eliminado eliminado correctamente.");
            }

        } catch (SQLException e) {
            System.err.println("Error al intentar eliminar la aplicación: " + e.getMessage());
        }
    }
}
