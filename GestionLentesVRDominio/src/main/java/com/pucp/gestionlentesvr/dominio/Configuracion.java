package com.pucp.gestionlentesvr.dominio;

import java.util.Date;

/**
 * Clase que representa una configuración aplicable a un dispositivo VR
 */
public class Configuracion {
    private int configuracionId;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Usuario creadoPor;
    private TipoConfiguracion tipo;
    private String valor;
    private boolean activo;
    
    public Configuracion() {
        this.fechaCreacion = new Date();
    }
    
    public Configuracion(int configuracionId, String nombre, String descripcion, 
                        Usuario creadoPor, TipoConfiguracion tipo, String valor, boolean activo) {
        this();
        this.configuracionId = configuracionId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creadoPor = creadoPor;
        this.tipo = tipo;
        this.valor = valor;
        this.activo = activo;
    }

    public int getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(int configuracionId) {
        this.configuracionId = configuracionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public TipoConfiguracion getTipo() {
        return tipo;
    }

    public void setTipo(TipoConfiguracion tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Configuracion{" +
                "configuracionId=" + configuracionId +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", valor='" + valor + '\'' +
                '}';
    }

    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}