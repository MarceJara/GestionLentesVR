/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.negocio.RolService;
import com.pucp.gestionlentesvr.negocioimpl.RolServiceImpl;
import com.pucp.gestionlentesvr.dominio.Rol   ;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
/**
 *
 * @author oscar
 */
@WebService(serviceName = "RolWS", targetNamespace = "com.pucp.gestionlentesvr")
public class RolWS {


    private final RolService service;

    public RolWS() {
        this.service = new RolServiceImpl();
    }

    @WebMethod(operationName = "registrarRol")
    public void registrarRol(@WebParam(name = "elemento") Rol elemento) throws Exception {
        service.registrarRol(elemento);
    }

    @WebMethod(operationName = "actualizarRol")
    public void actualizarRol(@WebParam(name = "elemento") Rol elemento) throws Exception {
        service.actualizarRol(elemento);
    }
}
