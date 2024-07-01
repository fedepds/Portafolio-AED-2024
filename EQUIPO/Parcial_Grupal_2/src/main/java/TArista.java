/**
 * Esta clase representa una arista en una estructura de datos de grafo.
 * Implementa la interfaz IArista y proporciona métodos para obtener y establecer la etiqueta de origen, la etiqueta de destino y el costo de la arista.
 * También proporciona un método para obtener una arista inversa.
 */
@SuppressWarnings("rawtypes")
public class TArista implements IArista {

    protected Comparable etiquetaOrigen;
    protected Comparable etiquetaDestino;
    protected double costo;

    /**
     * Constructor de la clase TArista.
     * Inicializa la etiqueta de origen, la etiqueta de destino y el costo de la arista.
     *
     * @param etiquetaOrigen la etiqueta de origen de la arista
     * @param etiquetaDestino la etiqueta de destino de la arista
     * @param costo el costo de la arista
     */
    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, double costo) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.costo = costo;
    }

    /**
     * Devuelve la etiqueta de origen de la arista.
     *
     * @return la etiqueta de origen de la arista
     */
    @Override
    public Comparable getEtiquetaOrigen() {
        return etiquetaOrigen;
    }

    /**
     * Establece la etiqueta de origen de la arista.
     *
     * @param etiquetaOrigen la nueva etiqueta de origen de la arista
     */
    @Override
    public void setEtiquetaOrigen(Comparable etiquetaOrigen) {
        this.etiquetaOrigen = etiquetaOrigen;
    }

    /**
     * Devuelve la etiqueta de destino de la arista.
     *
     * @return la etiqueta de destino de la arista
     */
    @Override
    public Comparable getEtiquetaDestino() {
        return etiquetaDestino;
    }

    /**
     * Establece la etiqueta de destino de la arista.
     *
     * @param etiquetaDestino la nueva etiqueta de destino de la arista
     */
    @Override
    public void setEtiquetaDestino(Comparable etiquetaDestino) {
        this.etiquetaDestino = etiquetaDestino;
    }

    /**
     * Devuelve el costo de la arista.
     *
     * @return el costo de la arista
     */
    @Override
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la arista.
     *
     * @param costo el nuevo costo de la arista
     */
    @Override
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Devuelve una nueva arista que es la inversa de esta arista.
     * La arista inversa tiene la misma etiqueta de destino y origen intercambiadas y el mismo costo.
     *
     * @return la arista inversa
     */
    public IArista aristaInversa() {
        return new TArista(this.getEtiquetaDestino(), this.getEtiquetaOrigen(), this.getCosto());
    }
}
