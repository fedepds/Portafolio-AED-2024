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
        String[] lineasProductos = ManejadorArchivosGenerico.leerArchivo("/Users/federicopizarro/Desktop/Parcial1/src/main/java/uy/edu/ucu/aed/Parte 3 productos.txt");

        Producto producto;
        for (String l : lineasProductos) {
            String[] datos = l.split(",");
            producto = new Producto(Integer.valueOf(datos[0]), datos[1]);
            TElementoAB<Producto> nuevoNodo = new TElementoAB<>(producto.getIdentificador(), producto);
            tienda.insertarElemento(nuevoNodo);

        }

        String salida ="/Users/federicopizarro/Desktop/Parcial1/src/main/java/uy/edu/ucu/aed/salida.txt";

        int[] datos = new int[10];
        datos[0]= tienda.longitudTrayectoriaInterna();
        datos[1]= tienda.longitudTrayectoriaInterna();
        datos[2]= tienda.getRaiz().obtenerAltura();



        String[] datosComoCadenas = new String[datos.length];
        for (int i = 0; i < datos.length; i++) {
            datosComoCadenas[i] = String.valueOf(datos[i]);
        }

        ManejadorArchivosGenerico.escribirArchivo(salida, datosComoCadenas);


        System.out.println(tienda.longitudTrayectoriaInternaMedia());


    }
}
