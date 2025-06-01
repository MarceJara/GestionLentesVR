/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucp.gestionlentesvr.negocio;

import com.pucp.gestionlentesvr.dominio.Grupo;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface GrupoService {

    void registrarGrupo(Grupo elemento) throws Exception;
    void actualizarGrupo(Grupo elemento) throws Exception;
    void eliminarGrupo(int id) throws Exception;
    Grupo obtenerGrupo(int id) throws Exception;
    List<Grupo> listarGrupo() throws Exception;
}
