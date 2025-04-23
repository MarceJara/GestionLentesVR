package com.pucp.presentacion;

import com.pucp.aplicacion.Aplicacion;
import com.pucp.dispositivo.Dispositivo;
import com.pucp.usuario.Grupo;
import com.pucp.usuario.Usuario;
import com.pucp.persistencia.dao.*;

import java.sql.SQLException;

public class UpdateVRAPP {
    public static void main(String[] args) {
        try {
            GrupoDAO grupoDAO = new GrupoDAO();
            Grupo grupo1 = grupoDAO.get(1);
            
            
            grupo1.setDescripcion("nuevaDescripcion");
            grupoDAO.update(grupo1);
            System.out.println("Grupo actualizado: " + grupo1.getNombre());
            
            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            Dispositivo dispositivo1 = dispositivoDAO.get(68);
            
            
            dispositivo1.setModelo("Diaz");
            dispositivoDAO.update(dispositivo1);
            System.out.println("Dispositivo actualizado: " + dispositivo1.getNombre());
           
            
            AplicacionDAO aplicacionDAO = new AplicacionDAO();
            Aplicacion aplicacion1 = aplicacionDAO.get(100);
            aplicacion1.setVersion("2.5");

            aplicacionDAO.update(aplicacion1);
            System.out.println("Aplicación fue actualizada");
            

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario1 = usuarioDAO.get(1);
            usuario1.setApellido("Diaz");
            
            usuarioDAO.update(usuario1);
            System.out.println("Usuario "+usuario1.getNombre()+" fue actualizada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}