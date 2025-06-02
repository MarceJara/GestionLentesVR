package com.pucp.gestionlentesvr.dominio.dispositivos;

import java.util.Date;

/**
 * Clase que representa una aplicación instalable en dispositivos VR
 */
public class Aplicacion {
    private int aplicacionId;
    private String nombre;
    private String version;
    private String desarrollador;
    private Date fechaLanzamiento;
    private String descripcion;
    private CategoriaAplicacion categoria;
    private double tamanoMB;
    private String rutaInstalador;
    private boolean activo;
    
    public Aplicacion() {
    }
    
    public Aplicacion(int aplicacionId, String nombre, String version, String desarrollador, 
                     Date fechaLanzamiento, String descripcion, CategoriaAplicacion categoria, 
                     double tamanoMB, String rutaInstalador, boolean activo) {
        this.aplicacionId = aplicacionId;
        this.nombre = nombre;
        this.version = version;
        this.desarrollador = desarrollador;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tamanoMB = tamanoMB;
        this.rutaInstalador = rutaInstalador;
        this.activo = activo;
    }

    public int getAplicacionId() {
        return aplicacionId;
    }

    public void setAplicacionId(int aplicacionId) {
        this.aplicacionId = aplicacionId;
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

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
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

    public CategoriaAplicacion getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAplicacion categoria) {
        this.categoria = categoria;
    }

    public double getTamanoMB() {
        return tamanoMB;
    }

    public void setTamanoMB(double tamanoMB) {
        this.tamanoMB = tamanoMB;
    }

    public String getRutaInstalador() {
        return rutaInstalador;
    }

    public void setRutaInstalador(String rutaInstalador) {
        this.rutaInstalador = rutaInstalador;
    }
    
    @Override
    public String toString() {
        return "Aplicacion{" +
                "aplicacionId=" + aplicacionId +
                ", nombre='" + nombre + '\'' +
                ", version='" + version + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", categoria=" + categoria +
                ", tamaño=" + tamanoMB + " MB" +
                '}';
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }   
}