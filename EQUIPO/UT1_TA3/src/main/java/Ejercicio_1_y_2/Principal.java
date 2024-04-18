package Ejercicio_1_y_2;

import Ejercicio_3.Ejercicio_3;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        String frase = "Si piensas que tu profesor es exigente ,... espera a conocer a tu jefe A!";

        ContadorPalabra cp = new ContadorPalabra();
        cp.cantidadPalabras(frase);
        cp.agruparLetras(frase);
        Ejercicio_3 ejercicio3= new  Ejercicio_3();

        String archivo= "/Users/federicopizarro/Desktop/UT1_TA3/src/main/java/Ejercicio_3/UT1_TA3_ARCHIVO_EJEMPLO.txt";
        ArrayList<String> var= ejercicio3.leerArchivo(archivo);
        int totalPalabras = 0;
        for (int cont = 0; cont < var.size(); cont++){
            System.out.println("La linea");
            System.out.println(cont);
            System.out.println("tiene lineas:");
            int palabrasLinea = cp.cantidadPalabras(var.get(cont));
            totalPalabras += palabrasLinea;
        }
        System.out.println("La cantidad total de palabras es: " + totalPalabras);
    }
}