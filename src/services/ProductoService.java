package services;

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

}