package com.pucp.gestionlentesvr.dominio;

/**
 * Clase que representa un rol de usuario en el sistema VRegister
 */
public class Rol {
    private int rolId;
    private String nombre;
    private String descripcion;
    
    public Rol() {
    }
    
    public Rol(int rolId, String nombre, String descripcion) {
        this.rolId = rolId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
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
    
    @Override
    public String toString() {
        return "Rol{" +
                "rolId=" + rolId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}