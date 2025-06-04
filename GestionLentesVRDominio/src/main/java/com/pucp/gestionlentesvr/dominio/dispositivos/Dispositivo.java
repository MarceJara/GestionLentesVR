package com.pucp.gestionlentesvr.dominio.dispositivos;

import com.pucp.gestionlentesvr.dominio.Usuario.Grupo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un dispositivo VR en el sistema
 */
public class Dispositivo {
    private int dispositivoId;
    private String nombre;
    private String modelo;
    private String numeroSerie;
    private Date fechaRegistro;
    private String ubicacion;
    private boolean activo;
    private EstadoConexion estadoConexion;
    private int nivelBateria;
    private Date ultimaConexion;
    private Firmware firmwareActual;
    private List<Aplicacion> aplicacionesInstaladas;
    private List<Configuracion> configuraciones;
    private Grupo grupo;
    
    public Dispositivo() {
        this.fechaRegistro = new Date();
        this.activo = true;
        this.estadoConexion = EstadoConexion.DESCONECTADO;
        this.aplicacionesInstaladas = new ArrayList<>();
        this.configuraciones = new ArrayList<>();
        this.grupo = new Grupo();
    }
    
    public Dispositivo(int dispositivoId, String nombre, String modelo, String numeroSerie, 
                       String ubicacion, Grupo grupo) {
        this();
        this.dispositivoId = dispositivoId;
        this.nombre = nombre;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.ubicacion = ubicacion;
        this.grupo = grupo;
    }

    public int getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(int dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public EstadoConexion getEstadoConexion() {
        return estadoConexion;
    }

    public void setEstadoConexion(EstadoConexion estadoConexion) {
        this.estadoConexion = estadoConexion;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public Firmware getFirmwareActual() {
        return firmwareActual;
    }

    public void setFirmwareActual(Firmware firmwareActual) {
        this.firmwareActual = firmwareActual;
    }

    public List<Aplicacion> getAplicacionesInstaladas() {
        return aplicacionesInstaladas;
    }

    public void setAplicacionesInstaladas(List<Aplicacion> aplicacionesInstaladas) {
        this.aplicacionesInstaladas = aplicacionesInstaladas;
    }

    public List<Configuracion> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(List<Configuracion> configuraciones) {
        this.configuraciones = configuraciones;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    public void instalarAplicacion(Aplicacion aplicacion) {
        this.aplicacionesInstaladas.add(aplicacion);
    }
    
    public void desinstalarAplicacion(Aplicacion aplicacion) {
        this.aplicacionesInstaladas.remove(aplicacion);
    }
    
    public void actualizarFirmware(Firmware nuevoFirmware) {
        this.firmwareActual = nuevoFirmware;
    }
    
    public void agregarConfiguracion(Configuracion configuracion) {
        this.configuraciones.add(configuracion);
    }
    
    public boolean requiereActualizacionFirmware(Firmware firmwareDisponible) {
        if (this.firmwareActual == null) return true;
        return firmwareDisponible.getVersion().compareTo(this.firmwareActual.getVersion()) > 0;
    }
    
    public void conectar() {
        this.estadoConexion = EstadoConexion.CONECTADO;
        this.ultimaConexion = new Date();
    }
    
    public void desconectar() {
        this.estadoConexion = EstadoConexion.DESCONECTADO;
    }
    
    @Override
    public String toString() {
        return "Dispositivo{" +
                "dispositivoId=" + dispositivoId +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", estadoConexion=" + estadoConexion +
                ", nivelBateria=" + nivelBateria + "%" +
                ", grupo=" + (grupo != null ? grupo.getNombre() : "Sin grupo") +
                '}';
    }
}