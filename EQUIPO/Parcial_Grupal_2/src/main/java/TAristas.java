import java.util.Collection;
import java.util.LinkedList;

/**
 * Esta clase representa una lista de aristas en una estructura de datos de grafo.
 * Extiende la clase LinkedList de Java y proporciona métodos para buscar aristas y insertar aristas en ambos sentidos.
 */
@SuppressWarnings("rawtypes")
public class TAristas extends LinkedList<IArista> {

    /**
     * Busca dentro de la lista de aristas una arista que conecte a etOrigen con etDestino.
     *
     * @param etOrigen la etiqueta del vértice de origen
     * @param etDestino la etiqueta del vértice de destino
     * @return la arista que conecta a etOrigen con etDestino, o null si no se encuentra
     */
    public IArista buscar(Comparable etOrigen, Comparable etDestino) {
        for (IArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                return laa;
            }
        }
        return null;
    }

    /**
     * Busca la arista de menor costo que conecte a cualquier nodo de VerticesU con cualquier otro de VerticesV.
     *
     * @param VerticesU - Lista de etiquetas de vértices U
     * @param VerticesV - Lista de etiquetas de vértices V
     * @return la arista de menor costo que conecta a cualquier nodo de VerticesU con cualquier otro de VerticesV, o null si no se encuentra
     */
    public IArista buscarMin(Collection<Comparable> VerticesU, Collection<Comparable> VerticesV) {
        IArista tempArista;
        IArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;

        for (Comparable u : VerticesU) {
            for (Comparable v : VerticesV) {
                tempArista = buscar(u, v);
                if (tempArista != null) {
                    if (tempArista.getCosto() < costoMin) {
                        costoMin = tempArista.getCosto();
                        tAMin = tempArista;
                    }
                }
            }
        }
        return tAMin;
    }

    /**
     * Imprime todas las aristas de la lista en el siguiente formato: ORIGEN - DESTINO - COSTO.
     *
     * @return una cadena de texto con todas las aristas de la lista, o null si la lista está vacía
     */
    public String imprimirEtiquetas() {
        if (this.isEmpty()) {
            return null;
        }
        StringBuilder salida = new StringBuilder();
        for (IArista arista : this) {
            salida.append(arista.getEtiquetaOrigen()).append(" - ").append(arista.getEtiquetaDestino()).append(" - ").append(arista.getCosto()).append("\n");
        }
        return salida.toString();
    }

    /**
     * Inserta en la lista todas las aristas de la colección dada y sus inversas.
     *
     * @param aristas una colección de aristas
     */
    void insertarAmbosSentidos(Collection<IArista> aristas) {
        for (IArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }
}
