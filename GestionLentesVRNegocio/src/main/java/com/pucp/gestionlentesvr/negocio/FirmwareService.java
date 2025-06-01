/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;

import com.pucp.gestionlentesvr.dominio.Firmware;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface FirmwareService {
    void registrarFirmware(Firmware elemento) throws Exception;
    void actualizarFirmware(Firmware elemento) throws Exception;
    void eliminarFirmware(int id) throws Exception;
    Firmware obtenerFirmware(int id) throws Exception;
    List<Firmware> listarFirmware() throws Exception;
}
