package controllers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import classes.Producto;
import services.ProductoService;

public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    


    public void mostrarProductos(){

        for(Entry<String, Producto> producto : this.productoService.obtenerProductos().entrySet()){

            System.out.println(producto.getValue().toString());
        }

    }

    public void crearProducto() {
        String numeroReferencia = pedirReferencia();
        String nombre = pedirNombre();
        float precio = pedirPrecio();
        int stock = pedirStock();
        productoService.crearProducto(numeroReferencia, nombre, precio, stock);
    }


    public String pedirReferencia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero de referencia del producto");
        return scanner.nextLine();

    }

    public String pedirNombre(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del producto");
        return scanner.nextLine();
    }

    public float pedirPrecio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el precio del producto");
        return scanner.nextFloat();

    }
    
    public int pedirStock(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el stock del producto");
        return scanner.nextInt();
    }




    public void modificarProducto() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Producto> productos = productoService.obtenerProductos();

        System.out.println("Introduce el identificador del producto que deseas modificar");
        mostrarProductos();
        String idProductoSelect = scanner.nextLine();

        if(productos.containsKey(idProductoSelect)){

            String nombreNuevo = pedirNombre();
            float precioNuevo = pedirPrecio();
            int stockNuevo = pedirStock();

            this.productoService.settearDatosProducto(productos, idProductoSelect, nombreNuevo, precioNuevo, stockNuevo);

            System.out.println("El producto ha sido modificado correctamente");

        }else{
            System.out.println("El producto no existe");
            modificarProducto();

        }
    }






}
