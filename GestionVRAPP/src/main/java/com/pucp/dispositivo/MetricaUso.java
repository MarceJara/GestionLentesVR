package com.pucp.dispositivo;
import com.pucp.usuario.*;
import com.pucp.aplicacion.*;

import java.util.Date;

/**
 * Clase que representa métricas de uso de un dispositivo VR
 */
public class MetricaUso {
    private int metricaId;
    private Dispositivo dispositivo;
    private Date fechaRegistro;
    private int tiempoUsoMinutos;
    private Aplicacion aplicacionUsada;
    private int nivelBateriaInicial;
    private int nivelBateriaFinal;
    private Usuario usuario;
    
    public MetricaUso() {
        this.fechaRegistro = new Date();
    }
    
    public MetricaUso(int metricaId, Dispositivo dispositivo, int tiempoUsoMinutos, 
                     Aplicacion aplicacionUsada, int nivelBateriaInicial, 
                     int nivelBateriaFinal, Usuario usuario) {
        this();
        this.metricaId = metricaId;
        this.dispositivo = dispositivo;
        this.tiempoUsoMinutos = tiempoUsoMinutos;
        this.aplicacionUsada = aplicacionUsada;
        this.nivelBateriaInicial = nivelBateriaInicial;
                         
    } 
} 
