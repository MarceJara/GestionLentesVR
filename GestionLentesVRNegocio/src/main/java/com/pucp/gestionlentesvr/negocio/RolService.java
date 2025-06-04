/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;
import com.pucp.gestionlentesvr.dominio.Usuario.Rol;
import java.util.List;
/**
 *
 * @author oscar
 */
public interface RolService {

    void registrarRol(Rol elemento) throws Exception;

    void actualizarRol(Rol elemento) throws Exception;

    void eliminarRol(int id) throws Exception;

    Rol obtenerRol(int id) throws Exception;

    List<Rol> listarRol() throws Exception;

}
