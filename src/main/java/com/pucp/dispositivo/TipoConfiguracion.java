package com.pucp.dispositivo;

/**
 * Enumeración que representa los tipos de configuración disponibles
 */
public enum TipoConfiguracion {
    AUDIO("Configuración de Audio"),
    VIDEO("Configuración de Video"),
    CONTROL("Configuración de Controles"),
    RED("Configuración de Red"),
    SEGURIDAD("Configuración de Seguridad"),
    SISTEMA("Configuración de Sistema");
    
    private final String descripcion;
    
    TipoConfiguracion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}