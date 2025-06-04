/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.Usuario.Rol;
import com.pucp.gestionlentesvr.negocio.RolService;
import com.pucp.gestionlentesvr.persistencia.dao.RolDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.RolDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class RolServiceImpl implements RolService {

    private final RolDAO dao;

    public RolServiceImpl() {
        this.dao = new RolDAOImpl();
    }

    @Override
    public void registrarRol(Rol elemento) throws Exception {

        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }

        dao.agregar(elemento);
    }

    @Override
    public void actualizarRol(Rol elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Elemento no puede estar vacía");
        }

        dao.actualizar(elemento);
    }

    @Override
    public void eliminarRol(int id) throws Exception {
        Rol elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Rol no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Rol obtenerRol(int id) throws Exception {
        Rol elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Rol no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Rol> listarRol() throws Exception {
        return dao.listarTodos();
    }
}
