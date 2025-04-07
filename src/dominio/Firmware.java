package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Firmware {
    private int idFirmware;
    private String version;
    private Date fechaLanzamiento;
    private String descripcion;
    private String rutaArchivo;
    private int tamaño;
    private List<Dispositivo> dispositivosActualizados;
    private List<String> modelosCompatibles;

    public Firmware() {
        this.dispositivosActualizados = new ArrayList<>();
        this.modelosCompatibles = new ArrayList<>();
    }

    public int getIdFirmware() {
        return idFirmware;
    }

    public void setIdFirmware(int idFirmware) {
        this.idFirmware = idFirmware;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public List<Dispositivo> getDispositivosActualizados() {
        return dispositivosActualizados;
    }

    public void setDispositivosActualizados(List<Dispositivo> dispositivosActualizados) {
        this.dispositivosActualizados = dispositivosActualizados;
    }

    public List<String> getModelosCompatibles() {
        return modelosCompatibles;
    }

    public void setModelosCompatibles(List<String> modelosCompatibles) {
        this.modelosCompatibles = modelosCompatibles;
    }

    public void agregarModeloCompatible(String modelo) {
        // Método para agregar un modelo compatible con el firmware
    }

    public void removerModeloCompatible(String modelo) {
        // Método para remover un modelo compatible con el firmware
    }

    public boolean esCompatibleCon(Dispositivo dispositivo) {
        // Método para verificar si el firmware es compatible con un dispositivo
        return false;
    }

    public void registrarActualizacion(Dispositivo dispositivo) {
        // Método para registrar que un dispositivo ha sido actualizado con este firmware
    }

    public boolean esVersionPosteriorA(Firmware otroFirmware) {
        // Método para verificar si este firmware es una versión posterior a otro
        return false;
    }
}