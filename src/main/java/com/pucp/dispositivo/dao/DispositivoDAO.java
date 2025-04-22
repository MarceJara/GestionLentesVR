package com.pucp.dispositivo.dao;

import com.pucp.dispositivo.Dispositivo;
import java.util.List;

public interface DispositivoDAO {
    int insertar(Dispositivo dispositivo);
    int actualizar(Dispositivo dispositivo);
    int eliminar(int idDispositivo);
    List<Dispositivo> listar();
    Dispositivo obtenerPorId(int idDispositivo);
}
