/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.Configuracion;
import com.pucp.gestionlentesvr.negocio.ConfiguracionService;
import com.pucp.gestionlentesvr.persistencia.dao.ConfiguracionDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.ConfiguracionDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class ConfiguracionServiceImpl implements ConfiguracionService {

    private final ConfiguracionDAO dao;

    public ConfiguracionServiceImpl() {
        this.dao = new ConfiguracionDAOImpl();
    }

    @Override
    public void registrarConfiguracion(Configuracion elemento) throws Exception {

        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre de la configuración no puede estar vacío");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción de la configuración no puede estar vacía");
        }
        if (elemento.getFechaCreacion() == null) {
            throw new Exception("La fecha de creación no puede ser nula");
        }
        if (elemento.getCreadoPor() == null) {
            throw new Exception("Debe especificarse el usuario que creó la configuración");
        }
        if (elemento.getTipo() == null) {
            throw new Exception("Debe especificarse el tipo de configuración");
        }
        if (elemento.getValor() == null || elemento.getValor().trim().isEmpty()) {
            throw new Exception("El valor de la configuración no puede estar vacío");
        }
        dao.agregar(elemento);
    }

    @Override
    public void actualizarConfiguracion(Configuracion elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre de la configuración no puede estar vacío");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción de la configuración no puede estar vacía");
        }
        if (elemento.getFechaCreacion() == null) {
            throw new Exception("La fecha de creación no puede ser nula");
        }
        if (elemento.getCreadoPor() == null) {
            throw new Exception("Debe especificarse el usuario que creó la configuración");
        }
        if (elemento.getTipo() == null) {
            throw new Exception("Debe especificarse el tipo de configuración");
        }
        if (elemento.getValor() == null || elemento.getValor().trim().isEmpty()) {
            throw new Exception("El valor de la configuración no puede estar vacío");
        }
        dao.actualizar(elemento);
    }

    @Override
    public void eliminarConfiguracion(int id) throws Exception {
        Configuracion elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Configuracion no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Configuracion obtenerConfiguracion(int id) throws Exception {
        Configuracion elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Configuracion no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Configuracion> listarConfiguracion() throws Exception {
        return dao.listarTodos();
    }
}
