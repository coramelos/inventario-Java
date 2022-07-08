package classes;
public class Pedido {

  private int idPedido;
  private int cantidad;
  private String dniCliente;
  private String numeroReferenciaProducto;

    public Pedido(int idPedido, int cantidad, String dniCliente,
        String numeroReferenciaProducto) {

        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.dniCliente = dniCliente;
        this.numeroReferenciaProducto = numeroReferenciaProducto;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDniCliente() {
        return this.dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNumeroReferenciaProducto() {
        return this.numeroReferenciaProducto;
    }

    public void setNumeroReferenciaProducto(String numeroReferenciaProducto) {
        this.numeroReferenciaProducto = numeroReferenciaProducto;
    }

    @Override
    public String toString(){
        return "Id Pedido: " + this.idPedido + " Cantidad : " + this.cantidad;

    }
}