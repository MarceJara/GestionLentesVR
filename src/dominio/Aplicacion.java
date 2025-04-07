package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aplicacion {
    private int idAplicacion;
    private String nombre;
    private String version;
    private String descripcion;
    private String categoria;
    private Date fechaCreacion;
    private int tamaño;
    private String rutaArchivo;
    private List<Dispositivo> dispositivosConAplicacion;

    public Aplicacion() {
        this.dispositivosConAplicacion = new ArrayList<>();
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Dispositivo> getDispositivosConAplicacion() {
        return dispositivosConAplicacion;
    }

    public void setDispositivosConAplicacion(List<Dispositivo> dispositivosConAplicacion) {
        this.dispositivosConAplicacion = dispositivosConAplicacion;
    }

    public void subirNuevaVersion(String nuevaVersion, int nuevoTamaño, String nuevaRuta) {
        // Método para subir una nueva versión de la aplicación
    }

    public boolean esCompatibleCon(Dispositivo dispositivo) {
        // Método para verificar si la aplicación es compatible con un dispositivo
        return false;
    }

    public void agregarDispositivoAsociado(Dispositivo dispositivo) {
        // Método para agregar un dispositivo asociado a la aplicación
    }

    public void removerDispositivoAsociado(Dispositivo dispositivo) {
        // Método para remover un dispositivo asociado a la aplicación
    }
}