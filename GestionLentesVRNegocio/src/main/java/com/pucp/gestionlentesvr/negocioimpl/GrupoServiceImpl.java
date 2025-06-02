/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.Usuario.Grupo;
import com.pucp.gestionlentesvr.negocio.GrupoService;
import com.pucp.gestionlentesvr.persistencia.dao.GrupoDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.GrupoDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class GrupoServiceImpl implements GrupoService {

    private final GrupoDAO dao;

    public GrupoServiceImpl() {
        this.dao = new GrupoDAOImpl();
    }

    @Override
    public void registrarGrupo(Grupo elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }
        if (elemento.getFechaCreacion() == null) {
            throw new Exception("La fecha de creación del Elemento no puede ser nula");
        }
        if (elemento.getUbicacion() == null || elemento.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación del Elemento no puede estar vacía");
        }
        if (elemento.getResponsable() == null) {
            throw new Exception("Debe asignarse un responsable al Elemento");
        }

        dao.agregar(elemento);
    }

    @Override
    public void actualizarGrupo(Grupo elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }
        if (elemento.getFechaCreacion() == null) {
            throw new Exception("La fecha de creación del Elemento no puede ser nula");
        }
        if (elemento.getUbicacion() == null || elemento.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación del Elemento no puede estar vacía");
        }
        if (elemento.getResponsable() == null) {
            throw new Exception("Debe asignarse un responsable al Elemento");
        }

        dao.actualizar(elemento);
    }

    @Override
    public void eliminarGrupo(int id) throws Exception {
        Grupo elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Grupo no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Grupo obtenerGrupo(int id) throws Exception {
        Grupo elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Grupo no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Grupo> listarGrupo() throws Exception {
        return dao.listarTodos();
    }
}
