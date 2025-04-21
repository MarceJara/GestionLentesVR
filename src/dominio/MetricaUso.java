package com.vregister.domain;

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
    }
    
  
    // Getters y Setters
    public int getMetricaId() {
        return metricaId;
    }
    
    public void setMetricaId(int metricaId) {
        this.metricaId = metricaId;
    }
    
    public Dispositivo getDispositivo() {
        return dispositivo;
    }
    
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public int getTiempoUsoMinutos() {
        return tiempoUsoMinutos;
    }
    
    public void setTiempoUsoMinutos(int tiempoUsoMinutos) {
        this.tiempoUsoMinutos = tiempoUsoMinutos;
    }
    
    public Aplicacion getAplicacionUsada() {
        return aplicacionUsada;
    }
    
    public void setAplicacionUsada(Aplicacion aplicacionUsada) {
        this.aplicacionUsada = aplicacionUsada;
    }
    
    public int getNivelBateriaInicial() {
        return nivelBateriaInicial;
    }
    
    public void setNivelBateriaInicial(int nivelBateriaInicial) {
        this.nivelBateriaInicial = nivelBateriaInicial;
    }
    
    public int getNivelBateriaFinal() {
        return nivelBateriaFinal;
    }
    
    public void setNivelBateriaFinal(int nivelBateriaFinal) {
        this.nivelBateriaFinal = nivelBateriaFinal;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Calcula el consumo de batería durante el uso
     * @return Porcentaje de batería consumido
     */
    public int calcularConsumoBateria() {
        return nivelBateriaInicial - nivelBateriaFinal;
    }
    
    /**
     * Verifica si el uso fue prolongado (más de 60 minutos)
     * @return true si el uso fue prolongado, false en caso contrario
     */
    public boolean esUsoProlongado() {
        return tiempoUsoMinutos > 60;
    }
    
    @Override
    public String toString() {
        return "MetricaUso{" +
                "metricaId=" + metricaId +
                ", dispositivo=" + dispositivo +
                ", fechaRegistro=" + fechaRegistro +
                ", tiempoUsoMinutos=" + tiempoUsoMinutos +
                ", aplicacionUsada=" + aplicacionUsada +
                ", nivelBateriaInicial=" + nivelBateriaInicial +
                ", nivelBateriaFinal=" + nivelBateriaFinal +
                ", usuario=" + usuario +
                '}';
    }
}
