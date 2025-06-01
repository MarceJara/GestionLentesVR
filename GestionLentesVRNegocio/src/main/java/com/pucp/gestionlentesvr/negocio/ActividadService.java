/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;

import com.pucp.gestionlentesvr.dominio.Actividad;
import java.util.List;
/**
 *
 * @author oscar
 */
public interface ActividadService {
    void registrarActividad(Actividad elemento) throws Exception;
    void actualizarActividad(Actividad elemento) throws Exception;
    void eliminarActividad(int id) throws Exception;
    Actividad obtenerActividad(int id) throws Exception;
    List<Actividad> listarActividad() throws Exception;   
}
