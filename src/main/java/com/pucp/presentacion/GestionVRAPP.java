package com.pucp.presentacion;

import com.pucp.aplicacion.Aplicacion;
import com.pucp.dispositivo.Dispositivo;
import com.pucp.usuario.Grupo;
import com.pucp.usuario.Usuario;
import com.pucp.persistencia.dao.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class GestionVRAPP {
    public static void main(String[] args) {
        try {
            GrupoDAO grupoDAO = new GrupoDAO();
            Grupo grupo1 = new Grupo();
            grupo1.setGrupoId(1);
            grupo1.setNombre("Grupo de Prueba");
            grupo1.setDescripcion("descripcion");
            grupo1.setFechaCreacion(new Date());
            grupo1.setUbicacion("A");

            grupoDAO.save(grupo1);
            System.out.println("Grupo guardado: " + grupo1.getNombre());

            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            Dispositivo dispositivo1 = new Dispositivo();
            dispositivo1.setDispositivoId(68);
            dispositivo1.setNombre("FabianDevice");
            dispositivo1.setModelo("Oscar");
            dispositivo1.setNumeroSerie("123456789");
            dispositivo1.setUbicacion("Casa de Melgar");
            dispositivo1.setGrupo(grupo1);
            Dispositivo dispositivo2 = new Dispositivo();
            dispositivo2.setDispositivoId(70);
            dispositivo2.setNombre("Oscar");
            dispositivo2.setModelo("XXULTRA");
            dispositivo2.setNumeroSerie("123456789");
            dispositivo2.setUbicacion("Casa de Paz");
            dispositivo2.setGrupo(grupo1);

            dispositivoDAO.save(dispositivo1);
            System.out.println("Dispositivo guardado: " + dispositivo1.getNombre());
            dispositivoDAO.save(dispositivo2);
            System.out.println("Dispositivo guardado: " + dispositivo2.getNombre());

            AplicacionDAO aplicacionDAO = new AplicacionDAO();
            Aplicacion aplicacion1 = new Aplicacion();
            aplicacion1.setAplicacionId(100);
            aplicacion1.setNombre("Among us VR");
            aplicacion1.setVersion("1.9");
            aplicacion1.setDesarrollador("Innersloth");
            aplicacion1.setFechaLanzamiento(new Date());
            aplicacion1.setDescripcion("Funar, el videojuego");
            aplicacion1.setTamanoMB(178.5);
            aplicacion1.setRutaInstalador("C:/instaladores/mi_app.apk");

            aplicacionDAO.save(aplicacion1);
            System.out.println("Aplicación insertada correctamente.");
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario1 = new Usuario();
            usuario1.setUsuarioId(1);
            usuario1.setNombre("Fabian");
            usuario1.setApellido("Lau");
            usuario1.setCorreo("fabian@gmail.com");
            usuario1.setContrasena("PUCP123DB");
            usuario1.setFechaCreacion(new Date());
            
            usuarioDAO.save(usuario1);
            System.out.println("Usuario " + usuario1.getNombre() + " agregado satisfactoriamente");
            

            List<Aplicacion> aplicaciones = aplicacionDAO.getAll();
            System.out.println("\nLista de aplicaciones:");
            for (Aplicacion app : aplicaciones) {
                System.out.println("- " + app.getNombre() + " (Versión: " + app.getVersion() + ")");
            }

            int cantidadDispositivos = dispositivoDAO.count();
            System.out.println("\nCantidad total de dispositivos: " + cantidadDispositivos);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
