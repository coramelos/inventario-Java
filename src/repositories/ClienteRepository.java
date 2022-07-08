package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import classes.Cliente;

public class ClienteRepository {

    private final String URL = "jdbc:mysql://localhost:3306/pchardware";
    private final String USER = "root";
    private final String PASSWORD = "Cocomelo13";

    private HashMap<String, Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new HashMap<>();
    }

    public void insertarCLiente(Cliente cliente) {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            // "INSERT INTO clientes VALUES ('25176515W','emi','Michel','Cuartero','123')";
            String sqlSentencia = "INSERT INTO clientes (dniCliente,emailCliente,nombreCliente,apellidosCliente,contraseniaCliente) VALUES ('"
                    + cliente.getDNI() + "\',\'" + cliente.getEmail() + "\',\'" + cliente.getNombre() + "\',\'"
                    + cliente.getApellidos() +
                    "\',\'" + cliente.getContrasenia() + "\');";

            sentencia.executeUpdate(sqlSentencia);
            conexion.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public HashMap<String, Cliente> obtenerClientes(){

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();


            String sqlSentencia = "SELECT * FROM clientes";

            ResultSet result = sentencia.executeQuery(sqlSentencia);

            while(result.next()){
               String dni = result.getString(1);
               String email = result.getString(2);
               String nombre = result.getString (3);
               String apellidos = result.getString (4);
               String contrasenia = result.getString (5);
               boolean activo = result.getBoolean (6);

               Cliente cliente = new Cliente (dni, email, nombre, apellidos, contrasenia, activo);
               this.clientes.put(cliente.getDNI(), cliente);
            }

            conexion.close();
            return this.clientes;


        } catch (SQLException exception) {            
            System.out.println(exception.getMessage());
        }
        return this.clientes;

    }

}
