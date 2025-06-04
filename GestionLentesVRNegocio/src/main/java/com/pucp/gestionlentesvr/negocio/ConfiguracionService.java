/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;
import com.pucp.gestionlentesvr.dominio.dispositivos.Configuracion;
import java.util.List;
/**
 *
 * @author oscar
 */
public interface ConfiguracionService {
    void registrarConfiguracion(Configuracion elemento) throws Exception;
    void actualizarConfiguracion(Configuracion elemento) throws Exception;
    void eliminarConfiguracion(int id) throws Exception;
    Configuracion obtenerConfiguracion(int id) throws Exception;
    List<Configuracion> listarConfiguracion() throws Exception; 
}
