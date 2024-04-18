package EjerciciosEntradaDeDatos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Circunferencia {
    private double radio;

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public static void leerEntradaStdin(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            int num =Integer.parseInt(reader.readLine());
            Circunferencia circunferencia = new Circunferencia(num);
            System.out.println("El área de la circunferencia es: " + circunferencia.calcularArea());
            System.out.println("El perímetro de la circunferencia es: " + circunferencia.calcularPerimetro());

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    leerEntradaStdin("/Users/federicopizarro/Desktop/array/src/main/java/Ejercicios_2/entradaCircunferencia.txt");
    }
}
