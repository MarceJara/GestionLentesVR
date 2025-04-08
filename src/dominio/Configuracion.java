package dominio;

import java.util.ArrayList;
import java.util.List;

// Clase Configuracion
public class Configuracion {
    private int idConfig;
    private String nombre;
    private String valor;
    private List<Opcion> opciones;
    
    public Configuracion() {
        this.opciones = new ArrayList<>();
    }
    
    public Configuracion(int idConfig, String nombre, String valor) {
        this.idConfig = idConfig;
        this.nombre = nombre;
        this.valor = valor;
        this.opciones = new ArrayList<>();
    }
    
    public int getIdConfig() {
        return idConfig;
    }
    
    public void setIdConfig(int idConfig) {
        this.idConfig = idConfig;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public List<Opcion> getOpciones() {
        return opciones;
    }
    
    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }
    
    public void aplicar() {
        // Aplicar la configuración
    }
    
    public boolean modificarOpcionPorDefecto(int idOpcion, String nuevoValor) {
        // Lógica para modificar opción por defecto
        return true;
    }
    
    public boolean agregarOpcion(Opcion opcion, int valorPorDefecto) {
        // Lógica para agregar opción
        return true;
    }
}