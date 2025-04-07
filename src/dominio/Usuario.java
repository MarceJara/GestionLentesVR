package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private Date fechaRegistro;
    private String rol; // admin, técnico, visor
    private List<Dispositivo> dispositivosAsignados;
    private List<Auditoria> auditorias;

    public Usuario() {
        this.dispositivosAsignados = new ArrayList<>();
        this.auditorias = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Dispositivo> getDispositivosAsignados() {
        return dispositivosAsignados;
    }

    public void setDispositivosAsignados(List<Dispositivo> dispositivosAsignados) {
        this.dispositivosAsignados = dispositivosAsignados;
    }

    public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public void cambiarContraseña(String nuevaContraseña) {
        // Método para cambiar la contraseña del usuario
    }

    public void asignarDispositivo(Dispositivo dispositivo) {
        // Método para asignar un dispositivo al usuario
    }

    public void desasignarDispositivo(Dispositivo dispositivo) {
        // Método para desasignar un dispositivo al usuario
    }

    public boolean validarCredenciales(String correo, String contraseña) {
        // Método para validar las credenciales del usuario
        return false;
    }
}