package services;

import classes.Cliente;
import classes.Producto;
import repositories.PedidoRepository;

public class PedidoService {

    private PedidoRepository pedidoRepository;
    

    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();
        
    }



    public void realizarPedido(Cliente clienteSeleccionado, Producto productoSeleccionado, int cantidad) {
        this.pedidoRepository.insertarPedido(clienteSeleccionado, productoSeleccionado, cantidad);
    }



    // public void actualizarStock(Producto productoSeleccionado, int cantidad) {
    //     int stockActual = productoSeleccionado.getStock();
    //     int stockNuevo = stockActual - cantidad;
    //     productoSeleccionado.setStock(stockNuevo);
        
    //     // hacer la llamada en el service de producto para actualizar el stock, dandole los datos al repository
    // }
    
}
