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
            
            int cantidadDispositivos = dispositivoDAO.count();
            System.out.println("\nCantidad total de dispositivos: " + cantidadDispositivos);
            
           //comienza la prueba del DAO de grupo
            GrupoDAO grupoDAOPruebaLectura = new GrupoDAO();
            Grupo grupoPruebaLectura = grupoDAOPruebaLectura.get(1);
            System.out.println("Grupo obtenido: " + (grupoPruebaLectura != null ? grupoPruebaLectura.getNombre() : "No encontrado"));

            List<Grupo> gruposPruebaLectura = grupoDAOPruebaLectura.getAll();
            System.out.println("\nLista de grupos:");
            for (Grupo g : gruposPruebaLectura) {
                System.out.println("- " + g.getNombre());
            }

            //COmienza la prueba del DAO del Dispositivo
            DispositivoDAO dispositivoDAOPruebaLectura = new DispositivoDAO();
            Dispositivo dispositivoPruebaLectura = dispositivoDAOPruebaLectura.get(68);
            System.out.println("\nDispositivo obtenido: " + (dispositivoPruebaLectura != null ? dispositivoPruebaLectura.getNombre() : "No encontrado"));

            List<Dispositivo> dispositivosPruebaLectura = dispositivoDAOPruebaLectura.getAll();
            System.out.println("\nLista de dispositivos:");
            for (Dispositivo d : dispositivosPruebaLectura) {
                System.out.println("- " + d.getNombre());
            }

            //comienza la prueba del DAO del aplicación
            AplicacionDAO aplicacionDAOPruebaLectura = new AplicacionDAO();
            Aplicacion aplicacion = aplicacionDAOPruebaLectura.get(100);
            System.out.println("\nAplicación obtenida: " + (aplicacion != null ? aplicacion.getNombre() : "No encontrada"));

            List<Aplicacion> aplicacionesPruebaLectura = aplicacionDAOPruebaLectura.getAll();
            System.out.println("\nLista de aplicaciones:");
            for (Aplicacion appPreubaLectura : aplicacionesPruebaLectura) {
                System.out.println("- " + appPreubaLectura.getNombre() + " (Versión: " + appPreubaLectura.getVersion() + ")");
            }

            //comeinza la prueba del DAO del usuario
            UsuarioDAO usuarioDAOPruebaLectura = new UsuarioDAO();
            Usuario usuarioPruebaLectura = usuarioDAOPruebaLectura.get(1);
            System.out.println("\nUsuario obtenido: " + (usuarioPruebaLectura != null ? usuarioPruebaLectura.getNombre() : "No encontrado"));

            List<Usuario> usuariosPruebaLectura = usuarioDAOPruebaLectura.getAll();
            System.out.println("\nLista de usuarios:");
            for (Usuario u : usuariosPruebaLectura) {
                System.out.println("- " + u.getNombre());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
