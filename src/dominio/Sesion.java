package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Alerta {
    private int idAlerta;
    private String titulo;
    private String descripcion;
    private String tipo; // error, advertencia, información
    private int nivelPrioridad; // 1-5, siendo 5 el más urgente
    private Date fechaCreacion;
    private Date fechaResolucion;
    private boolean resuelta;
    private Usuario creador;
    private Usuario asignado;
    private Dispositivo dispositivoAfectado;
    private List<String> acciones;

    public Alerta() {
        this.acciones = new ArrayList<>();
    }

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Usuario getAsignado() {
        return asignado;
    }

    public void setAsignado(Usuario asignado) {
        this.asignado = asignado;
    }

    public Dispositivo getDispositivoAfectado() {
        return dispositivoAfectado;
    }

    public void setDispositivoAfectado(Dispositivo dispositivoAfectado) {
        this.dispositivoAfectado = dispositivoAfectado;
    }

    public List<String> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<String> acciones) {
        this.acciones = acciones;
    }

    public void marcarComoResuelta() {
        // Método para marcar la alerta como resuelta
    }

    public void asignarA(Usuario usuario) {
        // Método para asignar la alerta a un usuario
    }

    public void agregarAccion(String accion) {
        // Método para agregar una acción a la alerta
    }

    public boolean esUrgente() {
        // Método para determinar si la alerta es urgente
        return nivelPrioridad >= 4;
    }

    public long getTiempoSinResolver() {
        // Método para calcular el tiempo que lleva sin resolver la alerta
        return 0; // Implementación dependerá de la lógica de cálculo
    }

    public void enviarNotificacion() {
        // Método para enviar una notificación sobre esta alerta
    }
}