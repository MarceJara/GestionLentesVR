/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.negocio.FirmwareService;
import com.pucp.gestionlentesvr.negocioimpl.FirmwareServiceImpl;
import com.pucp.gestionlentesvr.dominio.Firmware;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
/**
 *
 * @author oscar
 */
@WebService(serviceName = "FirmwareWS", targetNamespace = "com.pucp.gestionlentesvr")
public class FirmwareWS {

    private final FirmwareService service;

    public FirmwareWS() {
        this.service = new FirmwareServiceImpl();
    }

    @WebMethod(operationName = "registrarFirmware")
    public void registrarFirmware(@WebParam(name = "elemento") Firmware elemento) throws Exception {
        service.registrarFirmware(elemento);
    }

    @WebMethod(operationName = "actualizarFirmware")
    public void actualizarFirmware(@WebParam(name = "elemento") Firmware elemento) throws Exception {
        service.actualizarFirmware(elemento);
    }

    @WebMethod(operationName = "eliminarFirmware")
    public void eliminarFirmware(@WebParam(name = "id") int id) throws Exception {
        service.eliminarFirmware(id);
    }

    @WebMethod(operationName = "obtenerFirmware")
    public Firmware obtenerFirmware(@WebParam(name = "id") int id) throws Exception {
        return service.obtenerFirmware(id);
    }

    @WebMethod(operationName = "listarFirmware")
    public List<Firmware> listarFirmware() throws Exception {
        return service.listarFirmware();
    }
}
