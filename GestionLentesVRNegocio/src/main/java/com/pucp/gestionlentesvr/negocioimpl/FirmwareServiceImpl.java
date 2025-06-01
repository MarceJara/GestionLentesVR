/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.Firmware;
import com.pucp.gestionlentesvr.negocio.FirmwareService;
import com.pucp.gestionlentesvr.persistencia.dao.FirmwareDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.FirmwareDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class FirmwareServiceImpl implements FirmwareService {

    private final FirmwareDAO dao;

    public FirmwareServiceImpl() {
        this.dao = new FirmwareDAOImpl();
    }

    @Override
    public void registrarFirmware(Firmware elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getVersion() == null || elemento.getVersion().trim().isEmpty()) {
            throw new Exception("La versión del Elemento no puede estar vacía");
        }
        if (elemento.getFechaLanzamiento() == null) {
            throw new Exception("La fecha de lanzamiento del Elemento no puede ser nula");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }
        if (elemento.getRutaArchivo() == null || elemento.getRutaArchivo().trim().isEmpty()) {
            throw new Exception("La ruta del archivo del Elemento no puede estar vacía");
        }
        if (elemento.getDispositivo() == null) {
            throw new Exception("El Elemento debe estar asociado a un dispositivo");
        }
        if (elemento.getGrupo() == null) {
            throw new Exception("El Elemento debe estar asociado a un grupo");
        }
        dao.agregar(elemento);
    }

    @Override
    public void actualizarFirmware(Firmware elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getVersion() == null || elemento.getVersion().trim().isEmpty()) {
            throw new Exception("La versión del Elemento no puede estar vacía");
        }
        if (elemento.getFechaLanzamiento() == null) {
            throw new Exception("La fecha de lanzamiento del Elemento no puede ser nula");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }
        if (elemento.getRutaArchivo() == null || elemento.getRutaArchivo().trim().isEmpty()) {
            throw new Exception("La ruta del archivo del Elemento no puede estar vacía");
        }
        if (elemento.getDispositivo() == null) {
            throw new Exception("El Elemento debe estar asociado a un dispositivo");
        }
        if (elemento.getGrupo() == null) {
            throw new Exception("El Elemento debe estar asociado a un grupo");
        }
        dao.actualizar(elemento);
    }

    @Override
    public void eliminarFirmware(int id) throws Exception {
        Firmware elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Firmware no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Firmware obtenerFirmware(int id) throws Exception {
        Firmware elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Firmware no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Firmware> listarFirmware() throws Exception {
        return dao.listarTodos();
    }
}
