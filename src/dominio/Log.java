package dominio;

import java.util.Date;

public class Log {
    private int idLog;
    private Date fecha;
    private String tipoAccion;
    private String descripcion;
    private Usuario usuario;
    private Dispositivo dispositivo;
    private String detallesError;
    private int nivelSeveridad; // 1-5, siendo 5 el más severo

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getDetallesError() {
        return detallesError;
    }

    public void setDetallesError(String detallesError) {
        this.detallesError = detallesError;
    }

    public int getNivelSeveridad() {
        return nivelSeveridad;
    }

    public void setNivelSeveridad(int nivelSeveridad) {
        this.nivelSeveridad = nivelSeveridad;
    }

    public boolean esError() {
        // Método para verificar si el log es un error
        return nivelSeveridad >= 4;
    }

    public boolean requiereAtencion() {
        // Método para verificar si el log requiere atención inmediata
        return nivelSeveridad >= 3;
    }

    public String formatearLog() {
        // Método para formatear el log en un formato específico
        return "[" + fecha + "] " + tipoAccion + ": " + descripcion;
    }

    public void enviarNotificacion() {
        // Método para enviar una notificación sobre este log si es crítico
    }
}