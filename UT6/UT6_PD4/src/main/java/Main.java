import java.util.*;

public class Main {
    /**
     * Método principal de la aplicación.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Crea una instancia del contador de frecuencia de palabras
        frecuenciasPalabras palabras = new frecuenciasPalabras();

        // Lee las palabras del archivo
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/libro.txt");

        // Cuenta la frecuencia de cada palabra
        for (String p : palabrasclave) {
            palabras.contarFrecuenciasPalabras(p);
        }

        // Obtiene las frecuencias de las palabras
        HashMap<String, Integer> frecuencias = palabras.getFrecuenciasPalabras();

        // Ordena el HashMap en orden descendente por valor
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frecuencias.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Toma las primeras 10 entradas
        List<Map.Entry<String, Integer>> top10 = list.subList(0, Math.min(10, list.size()));

        // Imprime las 10 palabras más frecuentes y sus frecuencias
        for (Map.Entry<String, Integer> entry : top10) {
            System.out.println("Palabra: " + entry.getKey() + ", Frecuencia: " + entry.getValue());
        }
    }
}