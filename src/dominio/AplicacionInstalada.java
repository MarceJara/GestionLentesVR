package dominio;

import java.util.Date;

// Clase AplicacionInstalada
public class AplicacionInstalada {
    private int idDispositivo;
    private int idApp;
    private Date fechaInstalacion;
    
    public AplicacionInstalada() {
    }
    
    public AplicacionInstalada(int idDispositivo, int idApp, Date fechaInstalacion) {
        this.idDispositivo = idDispositivo;
        this.idApp = idApp;
        this.fechaInstalacion = fechaInstalacion;
    }
    
    public int getIdDispositivo() {
        return idDispositivo;
    }
    
    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }
    
    public int getIdApp() {
        return idApp;
    }
    
    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }
    
    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }
    
    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }
    
    public boolean desinstalar() {
        // Lógica para desinstalar la aplicación
        return true;
    }
}