/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;

import com.pucp.gestionlentesvr.dominio.dispositivos.Aplicacion;
import java.util.List;
/**
 *
 * @author oscar
 */
public interface AplicacionService {
    void registrarAplicacion(Aplicacion elemento) throws Exception;
    void actualizarAplicacion(Aplicacion elemento) throws Exception;
    void eliminarAplicacion(int id) throws Exception;
    Aplicacion obtenerAplicacion(int id) throws Exception;
    List<Aplicacion> listarAplicacion() throws Exception;   
}
