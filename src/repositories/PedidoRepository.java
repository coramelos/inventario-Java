package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Cliente;
import classes.Producto;

public class PedidoRepository {

    private final String URL = "jdbc:mysql://localhost:3306/pchardware";
    private final String USER = "root";
    private final String PASSWORD = "Cocomelo13";



    public void insertarPedido(Cliente clienteSeleccionado, Producto productoSeleccionado, int cantidad) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
           
            String sqlSentencia = "INSERT INTO pedidos (cantidad,dniCliente,referenciaProducto) VALUES ("
                    + cantidad + ",\'" + clienteSeleccionado.getDNI() + "\',\'" + productoSeleccionado.getNumeroReferencia() + "\');";
                    


           int stockNuevo = productoSeleccionado.getStock() - cantidad;
               

            String sentenciaStock = "UPDATE productos SET stock = " + stockNuevo + " WHERE numeroReferencia =\'" 
             +  productoSeleccionado.getNumeroReferencia() +"\';";
    

            sentencia.executeUpdate(sqlSentencia);
            sentencia.executeUpdate(sentenciaStock);
            conexion.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

}
