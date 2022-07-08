package classes;
public class Producto {

    private String numeroReferencia;
    private String nombre;
    private float precio;
    private int stock;
    
    public Producto(String numeroReferencia, String nombre, float precio, int stock) {
        this.numeroReferencia = numeroReferencia;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", numeroReferencia=" + numeroReferencia + ", precio=" + precio
                + ", stock=" + stock + "]";
    }


    
}