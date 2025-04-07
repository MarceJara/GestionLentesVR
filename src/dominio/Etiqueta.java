package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Etiqueta {
    private int idEtiqueta;
    private String nombre;
    private String color;
    private Date fechaCreacion;
    private Usuario creador;
    private List<Dispositivo> dispositivos;

    public Etiqueta() {
        this.dispositivos = new ArrayList<>();
    }

    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        // Método para agregar un dispositivo a la etiqueta
    }

    public void removerDispositivo(Dispositivo dispositivo) {
        // Método para remover un dispositivo de la etiqueta
    }

    public int contarDispositivos() {
        // Método para contar los dispositivos con esta etiqueta
        return dispositivos.size();
    }
}