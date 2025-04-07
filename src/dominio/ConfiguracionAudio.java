package dominio;

import java.util.Date;

public class ConfiguracionAudio {
    private int idConfiguracion;
    private String nombre;
    private int volumen;
    private boolean silenciado;
    private int nivelBajo;
    private int nivelMedio;
    private int nivelAlto;
    private Date fechaCreacion;
    private Usuario creador;
    private Dispositivo dispositivo;

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public boolean isSilenciado() {
        return silenciado;
    }

    public void setSilenciado(boolean silenciado) {
        this.silenciado = silenciado;
    }

    public int getNivelBajo() {
        return nivelBajo;
    }

    public void setNivelBajo(int nivelBajo) {
        this.nivelBajo = nivelBajo;
    }

    public int getNivelMedio() {
        return nivelMedio;
    }

    public void setNivelMedio(int nivelMedio) {
        this.nivelMedio = nivelMedio;
    }

    public int getNivelAlto() {
        return nivelAlto;
    }

    public void setNivelAlto(int nivelAlto) {
        this.nivelAlto = nivelAlto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void aplicarConfiguracion() {
        // Método para aplicar la configuración de audio al dispositivo
    }

    public void guardarConfiguracion() {
        // Método para guardar la configuración de audio
    }

    public void silenciar() {
        // Método para silenciar el audio
    }

    public void dessilenciar() {
        // Método para dessilenciar el audio
    }

    public void ajustarVolumen(int nuevoVolumen) {
        // Método para ajustar el volumen
    }
}