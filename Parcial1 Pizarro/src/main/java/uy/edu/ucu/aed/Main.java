package uy.edu.ucu.aed;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        LinkedList<Producto> lista = new LinkedList<>();
        TArbolDeProductos tienda = new TArbolDeProductos();
        String[] lineasProductos = ManejadorArchivosGenerico.leerArchivo("src/Parte 3 productos.txt");

        Producto producto;
        for (String l : lineasProductos) {
            String[] datos = l.split(",");
            producto = new Producto(Integer.valueOf(datos[0]), datos[1]);
            TElementoAB<Producto> nuevoNodo = new TElementoAB<>(producto.getIdentificador(), producto);
            tienda.insertarElemento(nuevoNodo);

        }
        System.out.println(tienda.longitudTrayectoriaInterna());
        String salida ="src/Parte 3 salida.txt";

        String[] datosComoCadenas ={
                String.valueOf(tienda.longitudTrayectoriaInterna()),
                String.valueOf(tienda.longitudTrayectoriaInternaMedia()),
                String.valueOf(tienda.getRaiz().obtenerAltura()),

        };

        ManejadorArchivosGenerico.escribirArchivo(salida, datosComoCadenas);


        System.out.println(tienda.longitudTrayectoriaInternaMedia());



    }
}
