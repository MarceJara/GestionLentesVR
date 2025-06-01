/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;

import com.pucp.gestionlentesvr.dominio.Usuario;
import java.util.List;
/**
 *
 * @author oscar
 */
public interface UsuarioService {
    void registrarUsuario(Usuario elemento) throws Exception;
    void actualizarUsuario(Usuario elemento) throws Exception;
    void eliminarUsuario(int id) throws Exception;
    Usuario obtenerUsuario(int id) throws Exception;
    List<Usuario> listarUsuario() throws Exception;
}
