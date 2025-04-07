package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MetricsCollector {
    private int idCollector;
    private String nombre;
    private Date fechaInicio;
    private int intervaloRecoleccion; // en segundos
    private boolean activo;
    private List<Dispositivo> dispositivosMonitoreados;
    private List<String> metricas; // batería, uso de CPU, memoria, etc.
    private Date ultimaRecoleccion;

    public MetricsCollector() {
        this.dispositivosMonitoreados = new ArrayList<>();
        this.metricas = new ArrayList<>();
    }

    public int getIdCollector() {
        return idCollector;
    }

    public void setIdCollector(int idCollector) {
        this.idCollector = idCollector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getIntervaloRecoleccion() {
        return intervaloRecoleccion;
    }

    public void setIntervaloRecoleccion(int intervaloRecoleccion) {
        this.intervaloRecoleccion = intervaloRecoleccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Dispositivo> getDispositivosMonitoreados() {
        return dispositivosMonitoreados;
    }

    public void setDispositivosMonitoreados(List<Dispositivo> dispositivosMonitoreados) {
        this.dispositivosMonitoreados = dispositivosMonitoreados;
    }

    public List<String> getMetricas() {
        return metricas;
    }

    public void setMetricas(List<String> metricas) {
        this.metricas = metricas;
    }

    public Date getUltimaRecoleccion() {
        return ultimaRecoleccion;
    }

    public void setUltimaRecoleccion(Date ultimaRecoleccion) {
        this.ultimaRecoleccion = ultimaRecoleccion;
    }

    public void iniciarRecoleccion() {
        // Método para iniciar la recolección de métricas
    }

    public void detenerRecoleccion() {
        // Método para detener la recolección de métricas
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        // Método para agregar un dispositivo a monitorear
    }

    public void removerDispositivo(Dispositivo dispositivo) {
        // Método para remover un dispositivo del monitoreo
    }

    public void agregarMetrica(String metrica) {
        // Método para agregar una métrica a recolectar
    }

    public void removerMetrica(String metrica) {
        // Método para remover una métrica de la recolección
    }

    public void ajustarIntervalo(int nuevoIntervalo) {
        // Método para ajustar el intervalo de recolección
    }

    public List<Object> obtenerMetricasActuales(Dispositivo dispositivo) {
        // Método para obtener las métricas actuales de un dispositivo
        return new ArrayList<>();
    }
}