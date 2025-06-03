package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.dominio.Usuario.Usuario;
import com.pucp.gestionlentesvr.negocio.UsuarioService;
import com.pucp.gestionlentesvr.negocioimpl.UsuarioServiceImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "UsuarioWS")
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
