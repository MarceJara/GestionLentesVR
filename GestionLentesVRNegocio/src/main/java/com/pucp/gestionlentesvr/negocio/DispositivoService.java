/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;

import com.pucp.gestionlentesvr.dominio.Dispositivo;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface DispositivoService {
    void registrarDispositivo(Dispositivo elemento) throws Exception;
    void actualizarDispositivo(Dispositivo elemento) throws Exception;
    void eliminarDispositivo(int id) throws Exception;
    Dispositivo obtenerDispositivo(int id) throws Exception;
    List<Dispositivo> listarDispositivo() throws Exception; 
}
