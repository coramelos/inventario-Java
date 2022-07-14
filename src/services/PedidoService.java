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
    
}
