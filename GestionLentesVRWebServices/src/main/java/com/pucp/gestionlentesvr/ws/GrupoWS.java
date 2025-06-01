/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.negocio.GrupoService;
import com.pucp.gestionlentesvr.negocioimpl.GrupoServiceImpl;
import com.pucp.gestionlentesvr.dominio.Grupo   ;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
/**
 *
 * @author oscar
 */
@WebService(serviceName = "GrupoWS", targetNamespace = "com.pucp.gestionlentesvr")
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
