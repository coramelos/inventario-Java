package controllers;

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
        String numeroRreferencia = pedirReferencia();
        String nombre = pedirNomre();
        float precio = pedirPrecio();
        int stock = pedirStock();
        productoService.crearProducto(numeroRreferencia, nombre, precio, stock);
    }


    public String pedirReferencia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero de referencia del producto");
        return scanner.nextLine();

    }

    public String pedirNomre(){
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
}
