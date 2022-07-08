package repositories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import classes.Producto;

public class ProductoRepository {
    
    private final String URL = "jdbc:mysql://localhost:3306/pchardware";
    private final String USER = "root";
    private final String PASSWORD = "Cocomelo13";

    
    public void insertarProducto(Producto producto){
        try {

            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            //('numeroRreferencia', 'nombre', precio, stock)

            String sqlSentencia = "INSERT INTO productos VALUES ('" + producto.getNumeroReferencia() + "\',\'" + producto.getNombre() +
            "\'," + producto.getPrecio() + "," + producto.getNombre() + ");"; 

            
            System.out.println("x");
            sentencia.executeUpdate(sqlSentencia);
            conexion.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            
        }

    }



}
