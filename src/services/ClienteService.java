package services;

import java.util.HashMap;
import java.util.Map.Entry;
import classes.Cliente;
import repositories.ClienteRepository;

public class ClienteService {

    ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
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
