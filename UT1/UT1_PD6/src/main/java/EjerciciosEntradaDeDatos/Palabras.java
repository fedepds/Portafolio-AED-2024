package EjerciciosEntradaDeDatos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Palabras {
    public static void leerEntradaArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            int entero = Integer.parseInt(reader.readLine());
            double flotante = Double.parseDouble(reader.readLine());
            String cadena = reader.readLine();

            System.out.println("El entero leído es: " + entero);
            System.out.println("El número de punto flotante es: " + flotante);
            System.out.println("La cadena leída es: " + cadena);
            System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + flotante + " es " + (entero + flotante) + ".");
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + ((int) flotante / entero) + " y su resto es " + (flotante % entero) + ".");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        leerEntradaArchivo("src/main/java/Ejercicios_2/entrada.txt");
    }
}