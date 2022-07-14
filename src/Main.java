import java.util.HashMap;
import java.util.Scanner;

import classes.Cliente;
import classes.Producto;
import controllers.ClienteController;
import controllers.PedidoController;
import controllers.ProductoController;
import services.ClienteService;
import services.PedidoService;
import services.ProductoService;

public class Main {
    private static final int NUEVO_CLIENTE = 1;
    private static final int NUEVO_PRODUCTO = 2;
    private static final int MOSTRAR_CLIENTES_ACTIVOS = 3;
    private static final int MOSTAR_TODOS_CLIENTES = 4;
    private static final int MOSTRAR_TODOS_PRODUCTOS = 5;
    private static final int MODIFICAR_CLIENTE = 6;
    private static final int MODIFICAR_PRODUCTO = 7;
    private static final int REALIZAR_PEDIDO = 8;
    private static final int SALIR = 9;

    private static ClienteController clienteController;
    private static ClienteService clienteService;
    private static ProductoController productoController;
    private static ProductoService productoService;
    private static PedidoController pedidoController;
    private static PedidoService pedidoService;

    public static void main(String[] args) throws Exception {

        int opcion = 0;
        iniciarServices();

        do {
            opcion = menu();
            realizarMenu(opcion);
        } while (opcion != SALIR);

    }

    public static void iniciarServices() {
        clienteService = new ClienteService();
        clienteController = new ClienteController(clienteService);
        productoService = new ProductoService();
        productoController = new ProductoController(productoService);
        pedidoService = new PedidoService();
        pedidoController = new PedidoController(pedidoService);

    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. - Nuevo cliente");
        System.out.println("2. - Nuevo producto ");
        System.out.println("3. - Mostrar todos clientes activos");
        System.out.println("4. - Mostrar todos clientes");
        System.out.println("5. - Mostrar todos productos");
        System.out.println("6. - Modificar cliente");
        System.out.println("7. - Modificar producto");
        System.out.println("8. - Realizar un pedido");
        System.out.println("9. - Salir ");
        return scanner.nextInt();
    }

    public static void realizarMenu(int opcion) {

        switch (opcion) {
            case NUEVO_CLIENTE:
                clienteController.crearCliente();
                break;

            case NUEVO_PRODUCTO:
                productoController.crearProducto();
                break;

            case MOSTRAR_CLIENTES_ACTIVOS:
                clienteController.mostrarClientesActivos();
                break;

            case MOSTAR_TODOS_CLIENTES:
                clienteController.mostrarClientes();
                break;

            case MOSTRAR_TODOS_PRODUCTOS:
                productoController.mostrarProductos();
                break;

            case MODIFICAR_CLIENTE:
            clienteController.modificarCliente();        
                break;

            case MODIFICAR_PRODUCTO:
            productoController.modificarProducto();
                break;

            case REALIZAR_PEDIDO:
            HashMap<String, Cliente> clientes = clienteService.obtenerClientes();
            HashMap<String, Producto> productos = productoService.obtenerProductos();
            pedidoController.realizarPedido(clientes, productos);
            
                break;

            case SALIR:
                System.out.println("¡Hasta la próxima¡");
                break;

            default:
                System.out.println(" Error:debes introducir un número del 1 al 9");
                break;
        }

    }
}
