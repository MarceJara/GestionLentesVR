package com.vregister.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un usuario del sistema VRegister
 */
public class Usuario {
    private int usuarioId;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private Date fechaCreacion;
    private boolean activo;
    private Rol rol;
    private List<Actividad> actividades;

    public Usuario() {
        this.actividades = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.activo = true;
    }

    public Usuario(int usuarioId, String nombre, String apellido, String correo, 
                   String contrasena, Rol rol) {
        this();
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    public void agregarActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }
    
    public void cambiarContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", rol=" + rol +
                ", activo=" + activo +
                '}';
    }
}