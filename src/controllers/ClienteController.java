package controllers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import classes.Cliente;
import services.ClienteService;

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }






    public void modificarCliente(){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Cliente> clientes = clienteService.obtenerClientes();


        System.out.println("Introduce el identificador del cliente que deseas modificar");
        mostrarClientes();
        String idClienteSelect = scanner.nextLine();

        if(clientes.containsKey(idClienteSelect)){

            String emailNuevo = pedirEmailCliente();
            String nombreNuevo = pedirNombreCliente();
            String apellidosNuevos = pedirApellidosCliente();
            String contraseniaNueva = pedirContraseniaCliente();
            boolean activacionNueva = activarCliente();

            clienteService.setDatosCliente(clientes, idClienteSelect, emailNuevo, nombreNuevo, apellidosNuevos,
             contraseniaNueva, activacionNueva);


        }else{
            System.out.println("El cliente no existe");
            modificarCliente();
        }
    }

    

    


    public boolean activarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseas activar el cliente?");
        String activacion = scanner.nextLine();

        if(activacion.toLowerCase().equals("si"))
        return true;
        else
        return false;
    }


    public void mostrarClientesActivos() {
        for (Entry<String, Cliente> cliente : this.clienteService.obtenerClientes().entrySet()) {

            if (cliente.getValue().isActivo()) {
                System.out.println(cliente.getValue().toString());
            }
        }

    }

    public void mostrarClientes() {

        // for(Entry<String, Cliente> cliente : clientes.entrySet())
        for (Entry<String, Cliente> cliente : this.clienteService.obtenerClientes().entrySet()) {
            System.out.println(cliente.getValue().toString());
        }
    }

    public String pedirNombreCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el nombre del cliente: ");
        return scanner.nextLine();
    }

    public String pedirApellidosCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca los apellidos del cliente: ");
        return scanner.nextLine();
    }

    public String pedirContraseniaCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca la contraseña del cliente: ");
        return scanner.nextLine();
    }

    public String pedirDNICliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el DNI del cliente: ");
        return scanner.nextLine();
    }

    public String pedirEmailCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el email del cliente: ");
        return scanner.nextLine();
    }

    public void crearCliente() {
        String dni = pedirDNICliente();
        String email = pedirEmailCliente();
        String nombre = pedirNombreCliente();
        String apellidos = pedirApellidosCliente();
        String contrasenia = pedirContraseniaCliente();

        HashMap<String, Cliente> clientes = clienteService.obtenerClientes();
        if (!clientes.containsKey(dni)) {
            clienteService.crearCliente(dni, email, nombre, apellidos, contrasenia);
        } else
            System.out.println("El cliente ya existe");
    }

}
