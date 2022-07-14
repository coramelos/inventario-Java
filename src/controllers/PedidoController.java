package controllers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import classes.Cliente;
import classes.Producto;
import services.PedidoService;

public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void realizarPedido(HashMap<String, Cliente> clientes, HashMap<String, Producto> productos) {

        System.out.println("Selecciona el cliente, que desea realizar el pedido");

        Cliente clienteSeleccionado = seleccionarCliente(clientes);
        if (clienteSeleccionado != null) {
            Producto productoSeleccionado = seleccionarProducto(productos);
            if (productoSeleccionado != null) {
                int cantidad = pedirCantidadProducto();
                boolean hayStock = hayCantidadDeProductos(productoSeleccionado, cantidad);
                if(hayStock)
                { 
                    this.pedidoService.realizarPedido(clienteSeleccionado, productoSeleccionado, cantidad);
                   
                }else{
                    System.out.println("Ha superado el límite máximo permitido");
                }  
               
            }
        }

        // crear peido en la base de datos asociado al cliente

        // actualizar stock del producto

    }

    public Producto seleccionarProducto(HashMap<String, Producto> productos) {

        if (!productos.isEmpty()) {
            mostrarProductos(productos);
            String idProducto = pedirProducto();
            boolean existeProducto = SiExisteProducto(productos, idProducto);
            if (existeProducto) {
                return productos.get(idProducto);

            } else {
                System.out.println("El producto introducido no existe");
                seleccionarProducto(productos);
            }
            System.out.println("La lista de productos está vacia en estos momentos");

        }
        return null;
    }

    public boolean SiExisteProducto(HashMap<String, Producto> productos, String idProducto) {
        if (productos.containsKey(idProducto)) {
            return true;
        }
        return false;
    }

    public boolean hayCantidadDeProductos(Producto producto, int cantidad) {        

        if (producto.getStock() >= cantidad) {
            return true;
        }
        return false;
    }

    public int pedirCantidadProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos desea comprar?");
        return scanner.nextInt();

    }

    public String pedirProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador del producto");
        return scanner.nextLine();
    }

    public Cliente seleccionarCliente(HashMap<String, Cliente> clientes) {

        if (!clientes.isEmpty()) {
            mostrarClientes(clientes);
            String idCliente = pedirDniCliente();
            String contrasenia = pedirContraseniaCliente();

            if (clientes.containsKey(idCliente) && clientes.get(idCliente).getContrasenia().equals(contrasenia)) {

                return clientes.get(idCliente);
            }else{
            System.out.println("Error: introducta los datos correctamente");
            seleccionarCliente(clientes);
            }

        } else {
            System.out.println("No hay clientes en la base de datos");
        }
        return null;
    }

    public void mostrarProductos(HashMap<String, Producto> productos) {
        for (Entry<String, Producto> producto : productos.entrySet()) {
            System.out.println(producto.getValue().toString());
        }
    }

    public void mostrarClientes(HashMap<String, Cliente> clientes) {
        for (Entry<String, Cliente> cliente : clientes.entrySet()) {
            System.out.println(cliente.getValue().toString());
        }
    }

    public String pedirDniCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el dni del cliente");
        return scanner.nextLine();
    }

    public String pedirContraseniaCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la contrasenia del cliente");
        return scanner.nextLine();
    }

}
