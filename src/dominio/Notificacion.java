package dominio;

import java.util.Date;

public class Notificacion {
    private int idNotificacion;
    private String titulo;
    private String contenido;
    private String tipo; // alerta, información, error
    private Date fechaEnvio;
    private boolean leida;
    private Usuario destinatario;
    private Dispositivo dispositivoRelacionado;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Dispositivo getDispositivoRelacionado() {
        return dispositivoRelacionado;
    }

    public void setDispositivoRelacionado(Dispositivo dispositivoRelacionado) {
        this.dispositivoRelacionado = dispositivoRelacionado;
    }

    public void marcarComoLeida() {
        // Método para marcar la notificación como leída
    }

    public void enviar() {
        // Método para enviar la notificación al destinatario
    }

    public boolean esUrgente() {
        // Método para determinar si la notificación es urgente
        return "alerta".equals(tipo) || "error".equals(tipo);
    }

    public String generarTextoNotificacion() {
        // Método para generar el texto completo de la notificación
        return "[" + tipo.toUpperCase() + "] " + titulo + ": " + contenido;
    }
}