import java.util.Collection;
import java.util.LinkedList;

@SuppressWarnings("rawtypes")
/**
 * Esta interfaz representa un vértice en una estructura de datos de grafo.
 * Proporciona métodos para obtener y establecer la etiqueta y el estado de visitado del vértice,
 * obtener y manipular las adyacencias del vértice, y realizar búsquedas y recorridos en el grafo.
 *
 * @param <T> el tipo de los datos almacenados en el vértice
 */
public interface IVertice<T> {

    /**
     * Devuelve la etiqueta del vértice.
     *
     * @return la etiqueta del vértice
     */
    Comparable getEtiqueta();

    /**
     * Devuelve si el vértice ha sido visitado o no.
     *
     * @return true si el vértice ha sido visitado, false en caso contrario
     */
    boolean getVisitado();

    /**
     * Devuelve los datos almacenados en el vértice.
     *
     * @return los datos almacenados en el vértice
     */
    T getDatos();

    /**
     * Establece el estado de visitado del vértice.
     *
     * @param valor el nuevo estado de visitado
     */
    void setVisitado(boolean valor);

    /**
     * Devuelve la lista de adyacencias del vértice.
     *
     * @return la lista de adyacencias del vértice
     */
    LinkedList<IAdyacencia<T>> getAdyacentes();

    /**
     * Busca una adyacencia en el vértice que tiene como destino un vértice dado.
     *
     * @param verticeDestino el vértice de destino de la adyacencia
     * @return la adyacencia si se encuentra, null en caso contrario
     */
    IAdyacencia<T> buscarAdyacencia(IVertice<T> verticeDestino);

    /**
     * Busca una adyacencia en el vértice que tiene como destino un vértice con una etiqueta dada.
     *
     * @param etiquetaDestino la etiqueta del vértice de destino de la adyacencia
     * @return la adyacencia si se encuentra, null en caso contrario
     */
    IAdyacencia<T> buscarAdyacencia(Comparable etiquetaDestino);

    /**
     * Elimina una adyacencia del vértice que tiene como destino un vértice con una etiqueta dada.
     *
     * @param nomVerticeDestino la etiqueta del vértice de destino de la adyacencia
     * @return true si la adyacencia se elimina con éxito, false en caso contrario
     */
    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    /**
     * Inserta una adyacencia en el vértice con un costo y un vértice de destino dados.
     *
     * @param costo el costo de la adyacencia
     * @param verticeDestino el vértice de destino de la adyacencia
     * @return true si la adyacencia se inserta con éxito, false en caso contrario
     */
    boolean insertarAdyacencia(Double costo, IVertice<T> verticeDestino);

    /**
     * Obtiene el costo de una adyacencia en el vértice que tiene como destino un vértice dado.
     *
     * @param verticeDestino el vértice de destino de la adyacencia
     * @return el costo de la adyacencia si se encuentra, null en caso contrario
     */
    Double obtenerCostoAdyacencia(IVertice<T> verticeDestino);

    /**
     * Devuelve el primer vértice adyacente al vértice.
     *
     * @return el primer vértice adyacente al vértice
     */
    IVertice<T> primerAdyacente();

    /**
     * Devuelve el siguiente vértice adyacente al vértice después de un vértice dado.
     *
     * @param w el vértice después del cual se busca el siguiente vértice adyacente
     * @return el siguiente vértice adyacente al vértice después de w
     */
    IVertice<T> siguienteAdyacente(IVertice<T> w);

    /**
     * Realiza una búsqueda en profundidad (BPF) en el grafo a partir del vértice.
     *
     * @param visitados la colección de vértices visitados
     */
    void bpf(Collection<IVertice<T>> visitados);

    /**
     * Encuentra todos los caminos en el grafo que conducen a un vértice con una etiqueta dada a partir del vértice.
     *
     * @param etVertDest la etiqueta del vértice de destino
     * @param caminoPrevio el camino previo
     * @param todosLosCaminos la colección de todos los caminos encontrados
     * @return la colección de todos los caminos encontrados
     */
    TCaminos<T> todosLosCaminos(Comparable etVertDest, TCamino<T> caminoPrevio, TCaminos<T> todosLosCaminos);

    /**
     * Verifica si el vértice tiene un ciclo.
     *
     * @param camino el camino a verificar
     * @return true si el vértice tiene un ciclo, false en caso contrario
     */
    boolean tieneCiclo(LinkedList<Comparable> camino);

    /**
     * Realiza una búsqueda en amplitud (BEA) en el grafo a partir del vértice.
     *
     * @param visitados la colección de vértices visitados
     */
    void bea(Collection<IVertice<T>> visitados);

    /**
     * Verifica si el vértice está conectado con un vértice dado.
     *
     * @param destino el vértice con el que se verifica la conexión
     * @return true si el vértice está conectado con destino, false en caso contrario
     */
    boolean conectadoCon(IVertice<T> destino);
}