package services;

import java.util.HashMap;

import classes.Cliente;
import repositories.ClienteRepository;

public class ClienteService {

    ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }







    public void setDatosCliente(HashMap<String,Cliente>clientes, String idCliente, String email, String nombre,
    String apellidos, String contrasenia, boolean activo){

        clientes.get(idCliente).setEmail(email);
        clientes.get(idCliente).setNombre(nombre);
        clientes.get(idCliente).setApellidos(apellidos);
        clientes.get(idCliente).setContrasenia(contrasenia);
        clientes.get(idCliente).setActivo(activo);

        this.clienteRepository.actualizarCliente(clientes.get(idCliente));

    }


    

    public void crearCliente(String dni, String email, String nombre,
            String apellidos, String contrasenia) {

        Cliente cliente = new Cliente(dni, email, nombre, apellidos, contrasenia);
        this.clienteRepository.insertarCLiente(cliente);
    }

    public HashMap<String, Cliente> obtenerClientes() {

        return this.clienteRepository.obtenerClientes();
    }

}
