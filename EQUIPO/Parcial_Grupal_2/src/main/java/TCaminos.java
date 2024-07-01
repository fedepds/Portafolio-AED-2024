import java.util.Collection;
import java.util.LinkedList;

/**
 * Esta clase representa una colección de caminos.
 * Cada camino es una instancia de la clase TCamino.
 */
public class TCaminos<T> {

    private Collection<TCamino<T>> caminos;

    /**
     * Constructor de la clase TCaminos.
     * Inicializa la colección de caminos como una lista vacía.
     */
    public TCaminos() {
        this.caminos = new LinkedList<>();
    }

    /**
     * Genera una cadena de texto con las etiquetas de los vértices de cada camino en la colección.
     *
     * @return una cadena de texto con las etiquetas de los vértices de cada camino en la colección
     */
    public String imprimirCaminos() {
        StringBuilder sb = new StringBuilder();
        for (TCamino<T> camino : caminos) {
            sb.append(camino.imprimirEtiquetas());
            sb.append(" - Costo: ");
            sb.append(camino.getCostoTotal());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Imprime en la consola las etiquetas de los vértices de cada camino en la colección.
     */
    public void imprimirCaminosConsola() {
        System.out.println(imprimirCaminos());
    }

    /**
     * Devuelve la colección de caminos.
     *
     * @return la colección de caminos
     */
    public Collection<TCamino<T>> getCaminos() {
        return caminos;
    }
}
