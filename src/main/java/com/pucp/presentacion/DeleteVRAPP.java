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
                          
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.exists(1)) {
                usuarioDAO.delete(1);
                System.out.println("El usuario Fabian se  ha eliminado eliminado correctamente.");
            } else {
                System.out.println("No se ha encontrado este usuario.");
            }
                                   
            DispositivoDAO dispositivo1DAO = new DispositivoDAO();
            if (dispositivo1DAO.exists(68)) {
                dispositivo1DAO.delete(68);
                System.out.println("Dispositivo con ID " + 68 + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un dispositivo con ID " + 68 + ".");
            }
            
            DispositivoDAO dispositivo2DAO = new DispositivoDAO();
            if (dispositivo2DAO.exists(70)) {
                dispositivo2DAO.delete(70);
                System.out.println("Dispositivo con ID " + 70 + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un dispositivo con ID " + 70 + ".");
            }
            
            GrupoDAO grupoDAO = new GrupoDAO();
            if (grupoDAO.exists(1)) {
                grupoDAO.delete(1);
                System.out.println("Grupo con ID " + 1 + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró un grupo con ID " + 1 + ".");
            }  
            
            AplicacionDAO aplicacionDAO = new AplicacionDAO();
            if (aplicacionDAO.exists(100)) {
                aplicacionDAO.delete(100);
                System.out.println("Aplicación con ID " + 100 + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró una aplicación con ID " + 100 + ".");
            }

        } catch (SQLException e) {
            System.err.println("Error al intentar eliminar: " + e.getMessage());
        }
    }
}
