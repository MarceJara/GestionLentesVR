/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.Usuario.Usuario;
import com.pucp.gestionlentesvr.negocio.UsuarioService;
import com.pucp.gestionlentesvr.persistencia.dao.UsuarioDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.UsuarioDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class UsuarioServiceImpl implements UsuarioService{
    
    private final UsuarioDAO dao;

    public UsuarioServiceImpl() {
        this.dao = new UsuarioDAOImpl();
    }

    @Override
    public void registrarUsuario(Usuario elemento) throws Exception {
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getApellido() == null || elemento.getApellido().trim().isEmpty()) {
            throw new Exception("El apellido del Elemento no puede estar vacío");
        }
        if (elemento.getCorreo() == null || elemento.getCorreo().trim().isEmpty()) {
            throw new Exception("El correo del Elemento no puede estar vacío");
        }
        if (elemento.getContrasena() == null || elemento.getContrasena().trim().isEmpty()) {
            throw new Exception("La contraseña del Elemento no puede estar vacía");
        }
        if (elemento.getFechaCreacion() == null) {
            throw new Exception("La fecha de creación del Elemento no puede ser nula");
        }
        if (elemento.getRol() == null) {
            throw new Exception("El Elemento debe tener un rol asignado");
        }


        dao.agregar(elemento);
    }

    @Override
    public void actualizarUsuario(Usuario elemento) throws Exception {
        
        if (elemento.getNombre() == null || elemento.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del Elemento no puede estar vacío");
        }
        if (elemento.getApellido() == null || elemento.getApellido().trim().isEmpty()) {
            throw new Exception("El apellido del Elemento no puede estar vacío");
        }
        if (elemento.getCorreo() == null || elemento.getCorreo().trim().isEmpty()) {
            throw new Exception("El correo del Elemento no puede estar vacío");
        }
        if (elemento.getContrasena() == null || elemento.getContrasena().trim().isEmpty()) {
            throw new Exception("La contraseña del Elemento no puede estar vacía");
        }
        if (elemento.getFechaCreacion() == null) {
            throw new Exception("La fecha de creación del Elemento no puede ser nula");
        }
        if (elemento.getRol() == null) {
            throw new Exception("El Elemento debe tener un rol asignado");
        }
        dao.actualizar(elemento);
    }

    @Override
    public void eliminarUsuario(int id) throws Exception {
        Usuario elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Usuario no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Usuario obtenerUsuario(int id) throws Exception {
        Usuario elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Usuario no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Usuario> listarUsuario() throws Exception {
        return dao.listarTodos();
    }
}
