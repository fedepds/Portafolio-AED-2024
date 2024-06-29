package uy.edu.ucu.aed;

import java.util.Collection;

@SuppressWarnings("rawtypes")
/**
 * Esta interfaz representa una estructura de datos de grafo no dirigido.
 * Proporciona métodos para realizar una búsqueda en amplitud (BEA), verificar si el grafo es conexo,
 * verificar si dos vértices están conectados, y ejecutar los algoritmos de Prim y Kruskal.
 *
 * @param <T> el tipo de los datos almacenados en el vértice
 */
public interface IGrafoNoDirigido<T> extends IGrafoDirigido<T> {

    /**
     * Realiza una búsqueda en amplitud (BEA) en el grafo.
     *
     * @return una colección de vértices en el orden en que fueron visitados
     */
    public Collection<IVertice<T>> bea();

    /**
     * Realiza una búsqueda en amplitud (BEA) en el grafo a partir de un vértice con una etiqueta dada.
     *
     * @param etiquetaOrigen la etiqueta del vértice de inicio
     * @return una colección de vértices en el orden en que fueron visitados
     */
    public Collection<IVertice<T>> bea(Comparable etiquetaOrigen);

    /**
     * Verifica si el grafo es conexo.
     *
     * @return true si el grafo es conexo, false en caso contrario
     */
    boolean esConexo();

    /**
     * Verifica si dos vértices están conectados.
     *
     * @param origen el vértice de origen
     * @param destino el vértice de destino
     * @return true si los vértices están conectados, false en caso contrario
     */
    public boolean conectados(IVertice<T> origen, IVertice<T> destino);

    /**
     * Ejecuta el algoritmo de Prim en el grafo para encontrar el árbol de expansión mínima.
     *
     * @return el árbol de expansión mínima del grafo
     */
    public IGrafoNoDirigido<T> Prim();

    /**
     * Ejecuta el algoritmo de Kruskal en el grafo para encontrar el árbol de expansión mínima.
     *
     * @return el árbol de expansión mínima del grafo
     */
    public IGrafoNoDirigido<T> Kruskal();
}
