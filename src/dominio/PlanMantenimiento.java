package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanMantenimiento {
    private int idPlan;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaProximoMantenimiento;
    private int intervaloMantenimiento; // en días
    private Usuario responsable;
    private List<Dispositivo> dispositivosIncluidos;
    private List<String> tareasMantenimiento;
    private boolean activo;

    public PlanMantenimiento() {
        this.dispositivosIncluidos = new ArrayList<>();
        this.tareasMantenimiento = new ArrayList<>();
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
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

    public Date getFechaProximoMantenimiento() {
        return fechaProximoMantenimiento;
    }

    public void setFechaProximoMantenimiento(Date fechaProximoMantenimiento) {
        this.fechaProximoMantenimiento = fechaProximoMantenimiento;
    }

    public int getIntervaloMantenimiento() {
        return intervaloMantenimiento;
    }

    public void setIntervaloMantenimiento(int intervaloMantenimiento) {
        this.intervaloMantenimiento = intervaloMantenimiento;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public List<Dispositivo> getDispositivosIncluidos() {
        return dispositivosIncluidos;
    }

    public void setDispositivosIncluidos(List<Dispositivo> dispositivosIncluidos) {
        this.dispositivosIncluidos = dispositivosIncluidos;
    }

    public List<String> getTareasMantenimiento() {
        return tareasMantenimiento;
    }

    public void setTareasMantenimiento(List<String> tareasMantenimiento) {
        this.tareasMantenimiento = tareasMantenimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        // Método para agregar un dispositivo al plan de mantenimiento
    }

    public void removerDispositivo(Dispositivo dispositivo) {
        // Método para remover un dispositivo del plan de mantenimiento
    }

    public void agregarTarea(String tarea) {
        // Método para agregar una tarea al plan de mantenimiento
    }

    public void removerTarea(String tarea) {
        // Método para remover una tarea del plan de mantenimiento
    }

    public void programarProximoMantenimiento() {
        // Método para programar el próximo mantenimiento
    }

    public boolean necesitaMantenimiento() {
        // Método para verificar si se necesita mantenimiento
        return new Date().after(fechaProximoMantenimiento);
    }

    public void generarNotificaciones() {
        // Método para generar notificaciones sobre el mantenimiento
    }

    public String generarInforme() {
        // Método para generar un informe sobre el plan de mantenimiento
        return "Informe de mantenimiento: " + nombre;
    }
}