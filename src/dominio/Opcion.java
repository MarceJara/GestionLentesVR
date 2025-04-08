package dominio;

// Clase Opcion
public class Opcion {
    private int idOpcion;
    private String valor;
    
    public Opcion() {
    }
    
    public Opcion(int idOpcion, String valor) {
        this.idOpcion = idOpcion;
        this.valor = valor;
    }
    
    public int getIdOpcion() {
        return idOpcion;
    }
    
    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public boolean seleccionarValor(String valor) {
        this.valor = valor;
        return true;
    }
}
