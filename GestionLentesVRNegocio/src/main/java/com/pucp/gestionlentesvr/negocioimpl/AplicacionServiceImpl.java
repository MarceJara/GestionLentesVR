/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.Aplicacion;
import com.pucp.gestionlentesvr.negocio.AplicacionService;
import com.pucp.gestionlentesvr.persistencia.dao.AplicacionDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.AplicacionDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class AplicacionServiceImpl implements AplicacionService{

    private final AplicacionDAO dao;

    public AplicacionServiceImpl() {
        this.dao = new AplicacionDAOImpl();
    }

    @Override
    public void registrarAplicacion(Aplicacion elemento) throws Exception {
        
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getVersion() == null || elemento.getVersion().trim().isEmpty()) {
            throw new Exception("La versión del Elemento no puede estar vacía");
        }
        if (elemento.getDesarrollador() == null || elemento.getDesarrollador().trim().isEmpty()) {
            throw new Exception("El desarrollador del Elemento no puede estar vacío");
        }
        if (elemento.getFechaLanzamiento() == null) {
            throw new Exception("La fecha de lanzamiento no puede ser nula");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }
        if (elemento.getCategoria() == null) {
            throw new Exception("Debe especificarse una categoría para el Elemento");
        }
        if (elemento.getTamanoMB() <= 0) {
            throw new Exception("El tamaño del Elemento debe ser mayor a 0 MB");
        }
        if (elemento.getRutaInstalador() == null || elemento.getRutaInstalador().trim().isEmpty()) {
            throw new Exception("La ruta del instalador no puede estar vacía");
        }

        dao.agregar(elemento);
    }

    @Override
    public void actualizarAplicacion(Aplicacion elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getVersion() == null || elemento.getVersion().trim().isEmpty()) {
            throw new Exception("La versión del Elemento no puede estar vacía");
        }
        if (elemento.getDesarrollador() == null || elemento.getDesarrollador().trim().isEmpty()) {
            throw new Exception("El desarrollador del Elemento no puede estar vacío");
        }
        if (elemento.getFechaLanzamiento() == null) {
            throw new Exception("La fecha de lanzamiento no puede ser nula");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }
        if (elemento.getCategoria() == null) {
            throw new Exception("Debe especificarse una categoría para el Elemento");
        }
        if (elemento.getTamanoMB() <= 0) {
            throw new Exception("El tamaño del Elemento debe ser mayor a 0 MB");
        }
        if (elemento.getRutaInstalador() == null || elemento.getRutaInstalador().trim().isEmpty()) {
            throw new Exception("La ruta del instalador no puede estar vacía");
        }

        dao.actualizar(elemento);
    }

    @Override
    public void eliminarAplicacion(int id) throws Exception {
        Aplicacion elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Aplicacion no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Aplicacion obtenerAplicacion(int id) throws Exception {
        Aplicacion elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Aplicacion no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Aplicacion> listarAplicacion() throws Exception {
        return dao.listarTodos();
    }
}
