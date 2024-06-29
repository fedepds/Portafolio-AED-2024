package uy.edu.ucu.aed;

/**
 * Esta interfaz representa una arista en una estructura de datos de grafo.
 * Proporciona métodos para obtener y establecer el costo de la arista, las etiquetas de los vértices de destino y origen,
 * y para obtener la inversa de la arista.
 *
 * @param <T> el tipo de los datos almacenados en el vértice
 */
@SuppressWarnings("rawtypes")
public interface IArista {

    /**
     * Devuelve el costo de la arista.
     *
     * @return el costo de la arista
     */
    double getCosto();

    /**
     * Devuelve la etiqueta del vértice de destino de la arista.
     *
     * @return la etiqueta del vértice de destino
     */
    Comparable getEtiquetaDestino();

    /**
     * Devuelve la etiqueta del vértice de origen de la arista.
     *
     * @return la etiqueta del vértice de origen
     */
    Comparable getEtiquetaOrigen();

    /**
     * Devuelve la inversa de la arista.
     *
     * @return la inversa de la arista
     */
    IArista aristaInversa();

    /**
     * Establece el costo de la arista.
     *
     * @param costo el nuevo costo de la arista
     */
    void setCosto(double costo);

    /**
     * Establece la etiqueta del vértice de destino de la arista.
     *
     * @param etiquetaDestino la nueva etiqueta del vértice de destino
     */
    void setEtiquetaDestino(Comparable etiquetaDestino);

    /**
     * Establece la etiqueta del vértice de origen de la arista.
     *
     * @param etiquetaOrigen la nueva etiqueta del vértice de origen
     */
    void setEtiquetaOrigen(Comparable etiquetaOrigen);
}
