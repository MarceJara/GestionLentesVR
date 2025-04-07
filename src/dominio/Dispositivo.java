package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dispositivo {
    private int idDispositivo;
    private String nombre;
    private String modelo;
    private String numeroSerie;
    private String estado; // activo, inactivo, mantenimiento
    private String ubicacion;
    private Date fechaRegistro;
    private Date ultimaConexion;
    private int nivelBateria;
    private int tiempoUso;
    private int nivelBrillo;
    private Usuario usuarioAsignado;
    private Grupo grupo;
    private List<Aplicacion> aplicacionesInstaladas;
    private List<Firmware> firmwares;
    private List<ConfiguracionAudio> configuracionesAudio;
    private List<Log> logs;
    private List<Etiqueta> etiquetas;

    public Dispositivo() {
        this.aplicacionesInstaladas = new ArrayList<>();
        this.firmwares = new ArrayList<>();
        this.configuracionesAudio = new ArrayList<>();
        this.logs = new ArrayList<>();
        this.etiquetas = new ArrayList<>();
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public int getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public int getNivelBrillo() {
        return nivelBrillo;
    }

    public void setNivelBrillo(int nivelBrillo) {
        this.nivelBrillo = nivelBrillo;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Aplicacion> getAplicacionesInstaladas() {
        return aplicacionesInstaladas;
    }

    public void setAplicacionesInstaladas(List<Aplicacion> aplicacionesInstaladas) {
        this.aplicacionesInstaladas = aplicacionesInstaladas;
    }

    public List<Firmware> getFirmwares() {
        return firmwares;
    }

    public void setFirmwares(List<Firmware> firmwares) {
        this.firmwares = firmwares;
    }

    public List<ConfiguracionAudio> getConfiguracionesAudio() {
        return configuracionesAudio;
    }

    public void setConfiguracionesAudio(List<ConfiguracionAudio> configuracionesAudio) {
        this.configuracionesAudio = configuracionesAudio;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void instalarAplicacion(Aplicacion aplicacion) {
        // Método para instalar una aplicación en el dispositivo
    }

    public void desinstalarAplicacion(Aplicacion aplicacion) {
        // Método para desinstalar una aplicación del dispositivo
    }

    public void actualizarFirmware(Firmware firmware) {
        // Método para actualizar el firmware del dispositivo
    }

    public void cambiarEstado(String nuevoEstado) {
        // Método para cambiar el estado del dispositivo
    }

    public void registrarLog(String accion, String descripcion) {
        // Método para registrar un log en el dispositivo
    }

    public void agregarEtiqueta(Etiqueta etiqueta) {
        // Método para agregar una etiqueta al dispositivo
    }

    public void removerEtiqueta(Etiqueta etiqueta) {
        // Método para remover una etiqueta del dispositivo
    }

    public boolean verificarActualizaciones() {
        // Método para verificar si hay actualizaciones disponibles
        return false;
    }

    public boolean verificarConexion() {
        // Método para verificar si el dispositivo está conectado
        return false;
    }
}