package com.pucp.presentacion;
import com.pucp.dispositivo.dao.DispositivoDAO;
import com.pucp.dispositivo.dao.impl.DispositivoDAOImpl;
import com.pucp.dispositivo.*;

import java.util.List;

public class GestionVRAPP {
    public static void main(String[] args) {
        // Crear instancia del DAO
        DispositivoDAO dispositivoDAO = new DispositivoDAOImpl();

        // Prueba de inserción
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setNombre("Dispositivo 1");
        dispositivo.setModelo("Modelo A");
        dispositivo.setNumeroSerie("123456");
        dispositivo.setUbicacion("Oficina");
        dispositivo.setActivo(true);

        int resultadoInsercion = dispositivoDAO.insertar(dispositivo);
        System.out.println("Resultado de inserción: " + resultadoInsercion);

        // Prueba de obtención por ID
        Dispositivo dispositivoObtenido = dispositivoDAO.obtenerPorId(1);
        if (dispositivoObtenido != null) {
            System.out.println("Dispositivo obtenido: " + dispositivoObtenido.getNombre());
        } else {
            System.out.println("No se encontró el dispositivo con ID 1.");
        }

        // Prueba de actualización
        if (dispositivoObtenido != null) {
            dispositivoObtenido.setNombre("Dispositivo Actualizado");
            int resultadoActualizacion = dispositivoDAO.actualizar(dispositivoObtenido);
            System.out.println("Resultado de actualización: " + resultadoActualizacion);
        }

        // Prueba de listado de dispositivos
        List<Dispositivo> dispositivos = dispositivoDAO.listar();
        System.out.println("Lista de dispositivos:");
        for (Dispositivo d : dispositivos) {
            System.out.println("ID: " + d.getDispositivoId() + ", Nombre: " + d.getNombre());
        }

        // Prueba de eliminación
        if (dispositivoObtenido != null) {
            int resultadoEliminacion = dispositivoDAO.eliminar(dispositivoObtenido.getDispositivoId());
            System.out.println("Resultado de eliminación: " + resultadoEliminacion);
        }

        // Verificar eliminación
        dispositivoObtenido = dispositivoDAO.obtenerPorId(1);
        if (dispositivoObtenido == null) {
            System.out.println("El dispositivo con ID 1 ha sido eliminado.");
        } else {
            System.out.println("El dispositivo con ID 1 sigue presente.");
        }
    }
}
    