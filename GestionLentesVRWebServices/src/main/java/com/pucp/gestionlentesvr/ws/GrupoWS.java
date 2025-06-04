package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.dominio.Usuario.Grupo;
import com.pucp.gestionlentesvr.negocio.GrupoService;
import com.pucp.gestionlentesvr.negocioimpl.GrupoServiceImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "GrupoWS")
public class GrupoWS {

    private final GrupoService service;

    public GrupoWS() {
        this.service = new GrupoServiceImpl();
    }

    @WebMethod(operationName = "registrarGrupo")
    public void registrarGrupo(@WebParam(name = "elemento") Grupo elemento) throws Exception {
        service.registrarGrupo(elemento);
    }

    @WebMethod(operationName = "actualizarGrupo")
    public void actualizarGrupo(@WebParam(name = "elemento") Grupo elemento) throws Exception {
        service.actualizarGrupo(elemento);
    }
}
