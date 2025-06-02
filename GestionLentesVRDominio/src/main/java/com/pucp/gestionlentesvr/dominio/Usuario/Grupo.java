package com.pucp.gestionlentesvr.dominio.Usuario;

import com.pucp.gestionlentesvr.dominio.dispositivos.Dispositivo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un grupo o laboratorio de dispositivos VR
 */
public class Grupo {
    private int grupoId;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private String ubicacion;
    private Usuario responsable;
    private List<Dispositivo> dispositivos;
    private boolean activo;
    
    public Grupo() {
        this.fechaCreacion = new Date();
        this.dispositivos = new ArrayList<>();
    }
    
    public Grupo(int grupoId, String nombre, String descripcion, String ubicacion, Usuario responsable) {
        this();
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.responsable = responsable;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
    
    public void agregarDispositivo(Dispositivo dispositivo) {
        this.dispositivos.add(dispositivo);
        dispositivo.setGrupo(this);
    }
    
    public void eliminarDispositivo(Dispositivo dispositivo) {
        this.dispositivos.remove(dispositivo);
        dispositivo.setGrupo(null);
    }
    
    public int cantidadDispositivos() {
        return this.dispositivos.size();
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return "Grupo{" +
                "grupoId=" + grupoId +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", cantidadDispositivos=" + cantidadDispositivos() +
                '}';
    }
}