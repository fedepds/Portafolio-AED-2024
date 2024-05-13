package uy.edu.ucu.aed;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        // Crear una nueva LinkedList de Productos
        LinkedList<Producto> lista = new LinkedList<>();
        // Crear un nuevo TArbolDeProductos
        TArbolDeProductos tienda = new TArbolDeProductos();
        // Leer el archivo "src/Parte 3 productos.txt" y almacenar cada línea en un array
        String[] lineasProductos = ManejadorArchivosGenerico.leerArchivo("src/Parte 3 productos.txt");

        Producto producto;
        // Recorrer cada línea en el archivo
        for (String l : lineasProductos) {
            // Dividir la línea en un array de strings usando la coma como delimitador
            String[] datos = l.split(",");
            // Crear un nuevo Producto usando el primer y segundo elemento del array
            producto = new Producto(Integer.valueOf(datos[0]), datos[1]);
            // Crear un nuevo TElementoAB usando el identificador del Producto y el Producto en sí
            TElementoAB<Producto> nuevoNodo = new TElementoAB<>(producto.getIdentificador(), producto);
            // Insertar el TElementoAB en el TArbolDeProductos
            tienda.insertarElemento(nuevoNodo);

        }
        // Imprimir la longitud de la trayectoria interna del TArbolDeProductos
        System.out.println(tienda.longitudTrayectoriaInterna());
        // Definir la ruta del archivo de salida
        String salida ="src/Parte 3 salida.txt";

        // Crear un array de strings que contenga la longitud de la trayectoria interna, la longitud media de la trayectoria interna y la altura del TArbolDeProductos
        String[] datosComoCadenas ={
                String.valueOf(tienda.longitudTrayectoriaInterna()),
                String.valueOf(tienda.longitudTrayectoriaInternaMedia()),
                String.valueOf(tienda.obtenerAltura()),

        };

        // Escribir el array de strings en el archivo de salida
        ManejadorArchivosGenerico.escribirArchivo(salida, datosComoCadenas);

        // Imprimir la longitud media de la trayectoria interna del TArbolDeProductos
        System.out.println(tienda.longitudTrayectoriaInternaMedia());
    }
}
