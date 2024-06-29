package uy.edu.ucu.aed;

/**
 * Esta interfaz representa una adyacencia en una estructura de datos de grafo.
 * Proporciona métodos para obtener el costo de la adyacencia, el vértice de destino y la etiqueta de la adyacencia.
 *
 * @param <T> el tipo de los datos almacenados en el vértice
 */
@SuppressWarnings("rawtypes")
public interface IAdyacencia<T> {

    /**
     * Devuelve el costo de la adyacencia.
     *
     * @return el costo de la adyacencia
     */
    double getCosto();

    /**
     * Devuelve el vértice de destino de la adyacencia.
     *
     * @return el vértice de destino de la adyacencia
     */
    IVertice<T> getDestino();

    /**
     * Devuelve la etiqueta de la adyacencia.
     *
     * @return la etiqueta de la adyacencia
     */
    Comparable getEtiqueta();
}
