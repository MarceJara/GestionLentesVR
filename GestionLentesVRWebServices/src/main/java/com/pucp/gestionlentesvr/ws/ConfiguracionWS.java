package com.pucp.gestionlentesvr.ws;

import com.pucp.gestionlentesvr.dominio.dispositivos.Configuracion;
import com.pucp.gestionlentesvr.negocio.ConfiguracionService;
import com.pucp.gestionlentesvr.negocioimpl.ConfiguracionServiceImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;

@WebService(serviceName = "ConfiguracionWS")
public class ConfiguracionWS {

    private final ConfiguracionService service;

    public ConfiguracionWS() {
        this.service = new ConfiguracionServiceImpl();
    }

    @WebMethod(operationName = "registrarConfiguracion")
    public void registrarConfiguracion(@WebParam(name = "elemento") Configuracion elemento) throws Exception {
        service.registrarConfiguracion(elemento);
    }

    @WebMethod(operationName = "actualizarConfiguracion")
    public void actualizarConfiguracion(@WebParam(name = "elemento") Configuracion elemento) throws Exception {
        service.actualizarConfiguracion(elemento);
    }

    @WebMethod(operationName = "eliminarConfiguracion")
    public void eliminarConfiguracion(@WebParam(name = "id") int id) throws Exception {
        service.eliminarConfiguracion(id);
    }

    @WebMethod(operationName = "obtenerConfiguracion")
    public Configuracion obtenerConfiguracion(@WebParam(name = "id") int id) throws Exception {
        return service.obtenerConfiguracion(id);
    }

    @WebMethod(operationName = "listarConfiguracion")
    public List<Configuracion> listarConfiguracion() throws Exception {
        return service.listarConfiguracion();
    }
}
