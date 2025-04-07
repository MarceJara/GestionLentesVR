package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Grupo {
    private int idGrupo;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Usuario responsable;
    private List<Dispositivo> dispositivos;

    public Grupo() {
        this.dispositivos = new ArrayList<>();
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        // Método para agregar un dispositivo al grupo
    }

    public void removerDispositivo(Dispositivo dispositivo) {
        // Método para remover un dispositivo del grupo
    }

    public void cambiarResponsable(Usuario nuevoResponsable) {
        // Método para cambiar el responsable del grupo
    }

    public int contarDispositivosActivos() {
        // Método para contar los dispositivos activos del grupo
        return 0;
    }

    public List<Dispositivo> listarDispositivosPorEstado(String estado) {
        // Método para listar los dispositivos por estado
        return new ArrayList<>();
    }
}