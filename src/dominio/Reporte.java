package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reporte {
    private int idReporte;
    private String titulo;
    private String tipo; // PDF, Excel, etc.
    private Date fechaGeneracion;
    private Usuario generador;
    private String contenido;
    private List<Dispositivo> dispositivosIncluidos;
    private String rutaArchivo;
    
    public Reporte() {
        this.dispositivosIncluidos = new ArrayList<>();
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Usuario getGenerador() {
        return generador;
    }

    public void setGenerador(Usuario generador) {
        this.generador = generador;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Dispositivo> getDispositivosIncluidos() {
        return dispositivosIncluidos;
    }

    public void setDispositivosIncluidos(List<Dispositivo> dispositivosIncluidos) {
        this.dispositivosIncluidos = dispositivosIncluidos;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void generarReporte() {
        // Método para generar el reporte
    }

    public void exportarAPDF() {
        // Método para exportar el reporte a PDF
    }

    public void exportarAExcel() {
        // Método para exportar el reporte a Excel
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        // Método para agregar un dispositivo al reporte
    }

    public void enviarPorCorreo(String correoDestino) {
        // Método para enviar el reporte por correo electrónico
    }
}