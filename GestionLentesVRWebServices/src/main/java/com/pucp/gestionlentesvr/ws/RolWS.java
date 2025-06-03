package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.dominio.Usuario.Rol;
import com.pucp.gestionlentesvr.negocio.RolService;
import com.pucp.gestionlentesvr.negocioimpl.RolServiceImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "RolWS")
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
