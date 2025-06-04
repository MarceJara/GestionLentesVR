/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocioimpl;

import com.pucp.gestionlentesvr.dominio.dispositivos.Actividad;
import com.pucp.gestionlentesvr.negocio.ActividadService;
import com.pucp.gestionlentesvr.persistencia.dao.ActividadDAO;
import com.pucp.gestionlentesvr.persistencia.daoimpl.ActividadDAOImpl;
import java.util.List;

/**
 *
 * @author oscar
 */
public class ActividadServiceImpl implements ActividadService{
    
    private final ActividadDAO dao;
    
    public ActividadServiceImpl() {
        this.dao = new ActividadDAOImpl();
    }

    @Override
    public void registrarActividad(Actividad elemento) throws Exception {

//        if (elemento.getUsuario() == null) {
//            throw new Exception("La actividad debe tener un usuario asociado");
//        }
//        if (elemento.getTipoActividad() == null) {
//            throw new Exception("La actividad debe tener un tipo definido");
//        }
//        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
//            throw new Exception("La descripción de la actividad no puede estar vacía");
//        }
//        if (elemento.getDetallesTecnicos() == null || elemento.getDetallesTecnicos().trim().isEmpty()) {
//            throw new Exception("Los detalles técnicos no pueden estar vacíos");
//        }
//        if (elemento.getDispositivoAfectado() == null) {
//            throw new Exception("Debe especificarse el dispositivo afectado por la actividad");
//        }

        // Si pasa todas las validaciones, registra el cliente
        dao.agregar(elemento);
    }

    @Override
    public void actualizarActividad(Actividad elemento) throws Exception {
        

        if (elemento.getUsuario() == null) {
            throw new Exception("La actividad debe tener un usuario asociado");
        }
        if (elemento.getTipoActividad() == null) {
            throw new Exception("La actividad debe tener un tipo definido");
        }
        if (elemento.getDescripcion() == null || elemento.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción de la actividad no puede estar vacía");
        }
        if (elemento.getDetallesTecnicos() == null || elemento.getDetallesTecnicos().trim().isEmpty()) {
            throw new Exception("Los detalles técnicos no pueden estar vacíos");
        }
        if (elemento.getDispositivoAfectado() == null) {
            throw new Exception("Debe especificarse el dispositivo afectado por la actividad");
        }
  

        dao.actualizar(elemento);
    }

    @Override
    public void eliminarActividad(int id) throws Exception {
        Actividad cliente = dao.obtener(id);
        if (cliente == null) {
            throw new Exception("Actividad no encontrada para eliminación");
        }
        dao.eliminar(id);
    }

    @Override
    public Actividad obtenerActividad(int id) throws Exception {
        Actividad elemento = dao.obtener(id);
        if (elemento == null) {
            throw new Exception("Actividad no encontrada");
        }
        return elemento;
    }

    @Override
    public List<Actividad> listarActividad() throws Exception {
        return dao.listarTodos();
    }
}
