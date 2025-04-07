package dominio;

import java.util.Date;

public class Auditoria {
    private int idAuditoria;
    private Date fecha;
    private String accion;
    private String tabla;
    private int idRegistro;
    private String valorAnterior;
    private String valorNuevo;
    private Usuario usuario;
    private String direccionIP;

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public boolean esModificacion() {
        // Método para verificar si la auditoría es una modificación
        return accion.equals("MODIFICAR");
    }

    public boolean esEliminacion() {
        // Método para verificar si la auditoría es una eliminación
        return accion.equals("ELIMINAR");
    }

    public boolean esCreacion() {
        // Método para verificar si la auditoría es una creación
        return accion.equals("CREAR");
    }

    public String obtenerDescripcionCambio() {
        // Método para obtener una descripción del cambio realizado
        return "Cambio en " + tabla + ": " + valorAnterior + " -> " + valorNuevo;
    }
}