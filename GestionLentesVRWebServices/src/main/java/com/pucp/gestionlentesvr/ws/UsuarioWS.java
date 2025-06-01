/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.negocio.UsuarioService;
import com.pucp.gestionlentesvr.negocioimpl.UsuarioServiceImpl;
import com.pucp.gestionlentesvr.dominio.Usuario   ;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
/**
 *
 * @author oscar
 */
@WebService(serviceName = "UsuarioWS", targetNamespace = "com.pucp.gestionlentesvr")
public class UsuarioWS {

    private final UsuarioService service;

    public UsuarioWS() {
        this.service = new UsuarioServiceImpl();
    }

    @WebMethod(operationName = "registrarUsuario")
    public void registrarUsuario(@WebParam(name = "elemento") Usuario elemento) throws Exception {
        service.registrarUsuario(elemento);
    }

    @WebMethod(operationName = "actualizarUsuario")
    public void actualizarUsuario(@WebParam(name = "elemento") Usuario elemento) throws Exception {
        service.actualizarUsuario(elemento);
    }
}
