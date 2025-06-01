/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.negocio.DispositivoService;
import com.pucp.gestionlentesvr.negocioimpl.DispositivoServiceImpl;
import com.pucp.gestionlentesvr.dominio.Dispositivo;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
/**
 *
 * @author oscar
 */
@WebService(serviceName = "DispositivoWS", targetNamespace = "com.pucp.gestionlentesvr")
public class DispositivoWS {

    private final DispositivoService service;

    public DispositivoWS() {
        this.service = new DispositivoServiceImpl();
    }

    @WebMethod(operationName = "registrarDispositivo")
    public void registrarDispositivo(@WebParam(name = "elemento") Dispositivo elemento) throws Exception {
        service.registrarDispositivo(elemento);
    }

    @WebMethod(operationName = "actualizarDispositivo")
    public void actualizarDispositivo(@WebParam(name = "elemento") Dispositivo elemento) throws Exception {
        service.actualizarDispositivo(elemento);
    }

    @WebMethod(operationName = "eliminarDispositivo")
    public void eliminarDispositivo(@WebParam(name = "id") int id) throws Exception {
        service.eliminarDispositivo(id);
    }

    @WebMethod(operationName = "obtenerDispositivo")
    public Dispositivo obtenerDispositivo(@WebParam(name = "id") int id) throws Exception {
        return service.obtenerDispositivo(id);
    }

    @WebMethod(operationName = "listarDispositivo")
    public List<Dispositivo> listarDispositivo() throws Exception {
        return service.listarDispositivo();
    }
}
