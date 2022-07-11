package repositories;

import java.sql.Statement;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Producto;

public class ProductoRepository {

    private final String URL = "jdbc:mysql://localhost:3306/pchardware";
    private final String USER = "root";
    private final String PASSWORD = "Cocomelo13";

    private HashMap<String, Producto> productos;

    public ProductoRepository() {
        this.productos = new HashMap<>();
    }

    public void insertarProducto(Producto producto) {
        try {

            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            // ('numeroRreferencia', 'nombre', precio, stock)

            String sqlSentencia = "INSERT INTO productos VALUES ('" + producto.getNumeroReferencia() + "\',\'"
                    + producto.getNombre() +
                    "\'," + producto.getPrecio() + "," + producto.getNombre() + ");";

            System.out.println("x");
            sentencia.executeUpdate(sqlSentencia);
            conexion.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }
    }

    public HashMap<String, Producto> obtenerProductos() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            String sqlSentencia = "SELECT * FROM productos";

            ResultSet result = sentencia.executeQuery(sqlSentencia);

            while (result.next()) {
                String numeroReferencia = result.getString(1);
                String nombre = result.getString(2);
                float precio = result.getFloat(3);
                int stock = result.getInt(4);

                Producto producto = new Producto(numeroReferencia, nombre, precio, stock);
                this.productos.put(producto.getNumeroReferencia(), producto);
            }

            conexion.close();
            return this.productos;

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return this.productos;

    }

    public void actualizarProducto(Producto producto) {


        try  {

            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            String sqlSentencia = "UPDATE productos SET nombre =\'" + producto.getNombre() + "\', precio = " + producto.getPrecio() +
            ", stock = " + producto.getStock() +
               " WHERE (numeroReferencia =\'" + producto.getNumeroReferencia() +"\');";
            
            
            sentencia.executeUpdate(sqlSentencia);
            conexion.close();

             } catch (SQLException exception) {
                System.out.println(exception.getMessage());

             }
    }
}
