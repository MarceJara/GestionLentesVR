/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.dispositivos.Dispositivo;
import com.pucp.gestionlentesvr.negocio.DispositivoService;
import com.pucp.gestionlentesvr.persistencia.dao.DispositivoDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.DispositivoDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class DispositivoServiceImpl implements DispositivoService {

    private final DispositivoDAO dao;

    public DispositivoServiceImpl() {
        this.dao = new DispositivoDAOImpl();
    }

    @Override
    public void registrarDispositivo(Dispositivo elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del dispositivo no puede estar vacío");
        }
        if (elemento.getModelo() == null || elemento.getModelo().trim().isEmpty()) {
            throw new Exception("El modelo del dispositivo no puede estar vacío");
        }
        if (elemento.getNumeroSerie() == null || elemento.getNumeroSerie().trim().isEmpty()) {
            throw new Exception("El número de serie del dispositivo no puede estar vacío");
        }
        if (elemento.getFechaRegistro() == null) {
            throw new Exception("La fecha de registro no puede ser nula");
        }
        if (elemento.getUbicacion() == null || elemento.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación del dispositivo no puede estar vacía");
        }
        if (elemento.getEstadoConexion() == null) {
            throw new Exception("Debe especificarse el estado de conexión del dispositivo");
        }
        if (elemento.getNivelBateria() < 0 || elemento.getNivelBateria() > 100) {
            throw new Exception("El nivel de batería debe estar entre 0 y 100");
        }
        if (elemento.getUltimaConexion() == null) {
            throw new Exception("La fecha de última conexión no puede ser nula");
        }
        if (elemento.getFirmwareActual() == null) {
            throw new Exception("Debe especificarse el firmware actual del dispositivo");
        }
        if (elemento.getGrupo() == null) {
            throw new Exception("Debe asignarse el dispositivo a un grupo");
        }

        dao.agregar(elemento);
    }

    @Override
    public void actualizarDispositivo(Dispositivo elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del dispositivo no puede estar vacío");
        }
        if (elemento.getModelo() == null || elemento.getModelo().trim().isEmpty()) {
            throw new Exception("El modelo del dispositivo no puede estar vacío");
        }
        if (elemento.getNumeroSerie() == null || elemento.getNumeroSerie().trim().isEmpty()) {
            throw new Exception("El número de serie del dispositivo no puede estar vacío");
        }
        if (elemento.getFechaRegistro() == null) {
            throw new Exception("La fecha de registro no puede ser nula");
        }
        if (elemento.getUbicacion() == null || elemento.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación del dispositivo no puede estar vacía");
        }
        if (elemento.getEstadoConexion() == null) {
            throw new Exception("Debe especificarse el estado de conexión del dispositivo");
        }
        if (elemento.getNivelBateria() < 0 || elemento.getNivelBateria() > 100) {
            throw new Exception("El nivel de batería debe estar entre 0 y 100");
        }
        if (elemento.getUltimaConexion() == null) {
            throw new Exception("La fecha de última conexión no puede ser nula");
        }
        if (elemento.getFirmwareActual() == null) {
            throw new Exception("Debe especificarse el firmware actual del dispositivo");
        }
        if (elemento.getGrupo() == null) {
            throw new Exception("Debe asignarse el dispositivo a un grupo");
        }

        dao.actualizar(elemento);
    }

    @Override
    public void eliminarDispositivo(int id) throws Exception {
        Dispositivo elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Dispositivo no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Dispositivo obtenerDispositivo(int id) throws Exception {
        Dispositivo elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Dispositivo no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Dispositivo> listarDispositivo() throws Exception {
        return dao.listarTodos();
    }
}
