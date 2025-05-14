package com.pucp.gestionlentesvr.dominio;

import java.util.Date;

/**
 * Clase que representa una actividad o acción realizada por un usuario en el sistema
 */
public class Actividad {
    private int actividadId;
    private Usuario usuario;
    private Date fechaHora;
    private TipoActividad tipoActividad;
    private String descripcion;
    private String detallesTecnicos;
    private Dispositivo dispositivoAfectado;
    private boolean activo;
    
    public Actividad() {
        this.fechaHora = new Date();
    }
    
    public Actividad(int actividadId, Usuario usuario, TipoActividad tipoActividad, 
                    String descripcion, Dispositivo dispositivoAfectado, boolean activo) {
        this();
        this.actividadId = actividadId;
        this.usuario = usuario;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
        this.dispositivoAfectado = dispositivoAfectado;
        this.activo = activo;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetallesTecnicos() {
        return detallesTecnicos;
    }

    public void setDetallesTecnicos(String detallesTecnicos) {
        this.detallesTecnicos = detallesTecnicos;
    }

    public Dispositivo getDispositivoAfectado() {
        return dispositivoAfectado;
    }

    public void setDispositivoAfectado(Dispositivo dispositivoAfectado) {
        this.dispositivoAfectado = dispositivoAfectado;
    }
    
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }    
    
    @Override
    public String toString() {
        return "Actividad{" +
                "actividadId=" + actividadId +
                ", usuario=" + (usuario != null ? usuario.getNombre() + " " + usuario.getApellido() : "Sistema") +
                ", fechaHora=" + fechaHora +
                ", tipoActividad=" + tipoActividad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


}