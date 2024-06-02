import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Esta clase extiende HashMap y se utiliza para contar la frecuencia de las palabras en un texto.
 */
public class frecuenciasPalabras extends HashMap<String, Integer>{

    // Un HashMap para almacenar las palabras y sus frecuencias
    private HashMap<String, Integer> frecuenciasPalabras;

    /**
     * Constructor de la clase. Inicializa el HashMap frecuenciasPalabras.
     */
    public frecuenciasPalabras() {
        this.frecuenciasPalabras = new HashMap<>();
    }

    /**
     * Este método cuenta la frecuencia de cada palabra en un texto dado.
     *
     * @param texto El texto en el que se contarán las palabras.
     */
    public void contarFrecuenciasPalabras(String texto) {
        StringTokenizer tokenizer = new StringTokenizer(texto);
        while (tokenizer.hasMoreTokens()) {
            String palabra = tokenizer.nextToken().toLowerCase();
            this.frecuenciasPalabras.put(palabra, this.frecuenciasPalabras.getOrDefault(palabra, 0) + 1);
        }
    }

    /**
     * Este método devuelve el HashMap de palabras y sus frecuencias.
     *
     * @return Un HashMap de palabras y sus frecuencias.
     */
    public HashMap<String, Integer> getFrecuenciasPalabras() {
        return this.frecuenciasPalabras;
    }
}