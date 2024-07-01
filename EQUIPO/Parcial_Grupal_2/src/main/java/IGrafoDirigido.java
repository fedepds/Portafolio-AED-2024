import java.util.Collection;
import java.util.Map;

/**
 * Esta interfaz representa una estructura de datos de grafo dirigido.
 * Proporciona métodos para búsqueda en profundidad y amplitud, encontrar el centro del grafo,
 * eliminar e insertar vértices y aristas, verificar la existencia de vértices y aristas,
 * ejecutar los algoritmos de Floyd y Warshall, y más.
 *
 * @param <T> el tipo de los datos almacenados en el vértice
 */
@SuppressWarnings("rawtypes")
public interface IGrafoDirigido<T> {

    /**
     * Realiza una búsqueda en profundidad (BPF) en el grafo.
     *
     * @return una colección de vértices en el orden en que fueron visitados
     */
    Collection<IVertice<T>> bpf();

    /**
     * Realiza una búsqueda en amplitud (BEA) en el grafo.
     *
     * @return una colección de vértices en el orden en que fueron visitados
     */
    Collection<IVertice<T>> bea();

    /**
     * Realiza una búsqueda en profundidad (BPF) en el grafo a partir de un vértice dado.
     *
     * @param vertice el vértice de inicio
     * @return una colección de vértices en el orden en que fueron visitados
     */
    Collection<IVertice<T>> bpf(IVertice<T> vertice);

    /**
     * Realiza una búsqueda en profundidad (BPF) en el grafo a partir de un vértice con una etiqueta dada.
     *
     * @param etiquetaOrigen la etiqueta del vértice de inicio
     * @return una colección de vértices en el orden en que fueron visitados
     */
    Collection<IVertice<T>> bpf(Comparable etiquetaOrigen);

    /**
     * Devuelve la etiqueta del centro del grafo.
     *
     * @return la etiqueta del centro del grafo
     */
    Comparable centroDelGrafo();

    /**
     * Elimina una arista dada por un origen y destino. Si la arista no existe o las etiquetas son inválidas,
     * retorna falso.
     *
     * @param nomVerticeOrigen etiqueta del vértice origen
     * @param nomVerticeDestino etiqueta del vértice destino
     * @return true si la arista se eliminó con éxito, false en caso contrario
     */
    boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino);

    /**
     * Elimina un vértice en el grafo. Si el vértice no existe o la etiqueta es inválida, retorna falso.
     *
     * @param nombreVertice etiqueta del vértice a eliminar
     * @return true si el vértice se eliminó con éxito, false en caso contrario
     */
    boolean eliminarVertice(Comparable nombreVertice);

    /**
     * Verifica la existencia de una arista. Las etiquetas pasadas por parámetro deben ser válidas.
     *
     * @param etiquetaOrigen etiqueta del vértice origen
     * @param etiquetaDestino etiqueta del vértice destino
     * @return true si la arista existe, false en caso contrario
     */
    boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    /**
     * Verifica la existencia de un vértice dentro del grafo.
     *
     * @param unaEtiqueta etiqueta del vértice a buscar
     * @return true si el vértice existe, false en caso contrario
     */
    boolean existeVertice(Comparable unaEtiqueta);

    /**
     * Ejecuta el algoritmo de Floyd en el grafo, para hallar los caminos mínimos entre todos los pares de vértices.
     *
     * @return una matriz de n x n (n = cantidad de vértices del grafo) con los costos de los caminos mínimos
     */
    Double[][] floyd();

    /**
     * Inserta una arista en el grafo (con un cierto costo), dado su vértice origen y destino.
     * Para que la arista sea válida, se deben cumplir los siguientes casos:
     * 1) Las etiquetas pasadas por parámetros son válidas.
     * 2) Los vértices (origen y destino) existen dentro del grafo.
     * 3) No es posible ingresar una arista ya existente.
     * 4) El costo debe ser mayor que 0.
     *
     * @param arista la arista a insertar
     * @return true si se pudo insertar la arista, false en caso contrario
     */
    boolean insertarArista(IArista arista);

    /**
     * Inserta un vértice en el grafo. No pueden ingresarse vértices con la misma etiqueta.
     *
     * @param vertice el vértice a insertar
     * @return true si se pudo insertar el vértice, false en caso contrario
     */
    boolean insertarVertice(IVertice<T> vertice);

    /**
     * Obtiene la excentricidad de un vértice.
     *
     * @param etiquetaVertice etiqueta del vértice
     * @return la excentricidad del vértice
     */
    Comparable obtenerExcentricidad(Comparable etiquetaVertice);

    /**
     * Ejecuta el algoritmo de Warshall para hallar la cerradura transitiva del grafo.
     *
     * @return una matriz de n x n (n = cantidad de vértices del grafo) en la que sus celdas indican si hay (true) o no (false) conectividad entre cada par de vértices
     */
    boolean[][] warshall();

    /**
     * Obtiene los vértices del grafo.
     *
     * @return un mapa de vértices del grafo
     */
    Map<Comparable, IVertice<T>> getVertices();

    /**
     * Desmarca todos los vértices del grafo como no visitados.
     */
    void desvisitarVertices();

    /**
     * Obtiene todos los caminos entre dos vértices.
     *
     * @param etiquetaOrigen etiqueta del vértice origen
     * @param etiquetaDestino etiqueta del vértice destino
     * @return todos los caminos entre los dos vértices
     */
    TCaminos<T> todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    /**
     * Verifica si un camino tiene un ciclo.
     *
     * @param camino el camino a verificar
     * @return true si el camino tiene un ciclo, false en caso contrario
     */
    boolean tieneCiclo(TCamino<T> camino);

    /**
     * Verifica si existe un ciclo a partir de un vértice.
     *
     * @param etiquetaOrigen etiqueta del vértice origen
     * @return true si existe un ciclo, false en caso contrario
     */
    boolean tieneCiclo(Comparable etiquetaOrigen);

    /**
     * Verifica si el grafo tiene un ciclo.
     *
     * @return true si el grafo tiene un ciclo, false en caso contrario
     */
    boolean tieneCiclo();
}
