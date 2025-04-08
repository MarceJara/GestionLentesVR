package com.vregister.domain;

import java.util.Date;

/**
 * Clase que representa un firmware para dispositivos VR
 */
public class Firmware {
    private int firmwareId;
    private String nombre;
    private String version;
    private Date fechaLanzamiento;
    private String descripcion;
    private String rutaArchivo;
    
    public Firmware() {
    }
    
    public Firmware(int firmwareId, String nombre, String version, Date fechaLanzamiento, 
                   String descripcion, String rutaArchivo) {
        this.firmwareId = firmwareId;
        this.nombre = nombre;
        this.version = version;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.rutaArchivo = rutaArchivo;
    }

    public int getFirmwareId() {
        return firmwareId;
    }

    public void setFirmwareId(int firmwareId) {
        this.firmwareId = firmwareId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    @Override
    public String toString() {
        return "Firmware{" +
                "firmwareId=" + firmwareId +
                ", nombre='" + nombre + '\'' +
                ", version='" + version + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}