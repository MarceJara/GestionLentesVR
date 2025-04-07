package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DashboardConfiguracion {
    private int idConfiguracion;
    private String nombre;
    private Usuario usuario;
    private Date fechaCreacion;
    private Date ultimaModificacion;
    private boolean esPorDefecto;
    private List<String> widgetsActivos;
    private String temaColor;
    private int refrescoAutomatico; // en segundos, 0 si está desactivado

    public DashboardConfiguracion() {
        this.widgetsActivos = new ArrayList<>();
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(Date ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public boolean isEsPorDefecto() {
        return esPorDefecto;
    }

    public void setEsPorDefecto(boolean esPorDefecto) {
        this.esPorDefecto = esPorDefecto;
    }

    public List<String> getWidgetsActivos() {
        return widgetsActivos;
    }

    public void setWidgetsActivos(List<String> widgetsActivos) {
        this.widgetsActivos = widgetsActivos;
    }

    public String getTemaColor() {
        return temaColor;
    }

    public void setTemaColor(String temaColor) {
        this.temaColor = temaColor;
    }

    public int getRefrescoAutomatico() {
        return refrescoAutomatico;
    }

    public void setRefrescoAutomatico(int refrescoAutomatico) {
        this.refrescoAutomatico = refrescoAutomatico;
    }

    public void agregarWidget(String widget) {
        // Método para agregar un widget a la configuración
    }

    public void eliminarWidget(String widget) {
        // Método para eliminar un widget de la configuración
    }

    public void establecerComoPredeterminado() {
        // Método para establecer esta configuración como predeterminada
    }

    public void actualizarUltimaModificacion() {
        // Método para actualizar la fecha de última modificación
    }

    public void guardarConfiguracion() {
        // Método para guardar la configuración en la base de datos
    }
}