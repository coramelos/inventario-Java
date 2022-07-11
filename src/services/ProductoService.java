package services;

import java.util.HashMap;

import classes.Producto;
import repositories.ProductoRepository;

public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService() {
        this.productoRepository = new ProductoRepository();
    }

    public void crearProducto(String numeroRreferencia, String nombre,
            Float precio, int stock) {

        Producto producto = new Producto(numeroRreferencia, nombre, precio, stock);
        this.productoRepository.insertarProducto(producto);

    }

    public HashMap<String, Producto> obtenerProductos() {

        return this.productoRepository.obtenerProductos();
    }

    public void settearDatosProducto(HashMap<String, Producto> productos, String idProductoSelect, String nombreNuevo,
            float precioNuevo,
            int stockNuevo) {

        productos.get(idProductoSelect).setNombre(nombreNuevo);
        productos.get(idProductoSelect).setPrecio(precioNuevo);
        productos.get(idProductoSelect).setStock(stockNuevo);

        this.productoRepository.actualizarProducto(productos.get(idProductoSelect));

    }

}
