/**
 * Esta clase representa una adyacencia en una estructura de datos de grafo.
 * Implementa la interfaz IAdyacencia y proporciona métodos para obtener la etiqueta, el costo y el vértice de destino de la adyacencia.
 *
 * @param <T> el tipo de los datos almacenados en el vértice
 */
@SuppressWarnings("rawtypes")
public class TAdyacencia<T> implements IAdyacencia<T> {

    private Comparable etiqueta;
    private double costo;
    private IVertice<T> destino;

    /**
     * Constructor de la clase TAdyacencia.
     * Inicializa la etiqueta, el costo y el vértice de destino de la adyacencia.
     *
     * @param costo el costo de la adyacencia
     * @param destino el vértice de destino de la adyacencia
     */
    public TAdyacencia(double costo, IVertice<T> destino) {
        this.etiqueta = destino.getEtiqueta();
        this.costo = costo;
        this.destino = destino;
    }

    /**
     * Devuelve la etiqueta de la adyacencia.
     *
     * @return la etiqueta de la adyacencia
     */
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Devuelve el costo de la adyacencia.
     *
     * @return el costo de la adyacencia
     */
    @Override
    public double getCosto() {
        return costo;
    }

    /**
     * Devuelve el vértice de destino de la adyacencia.
     *
     * @return el vértice de destino de la adyacencia
     */
    @Override
    public IVertice<T> getDestino() {
        return destino;
    }
}
