
/**
 * Interfaz que define la estructura de un nodo para una lista enlazada simple.
 * Cada nodo contiene un dato de un tipo genérico y una referencia al siguiente nodo.
 *
 * @param <T> El tipo de dato que se almacenará en el nodo.
 */
public interface INodo<T> {

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return El dato del nodo.
     */
    public T getDato();

    /**
     * Obtiene el siguiente nodo en la lista.
     *
     * @return El siguiente nodo.
     */
    public Nodo<T> getSiguiente();

    /**
     * Establece el siguiente nodo en la lista.
     *
     * @param nodo - El nodo que se establecerá como el siguiente.
     */
    public void setSiguiente(Nodo<T> nodo);

    /**
     * Imprime el dato almacenado en el nodo.
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo.
     */
    public void imprimirEtiqueta();

    /**
     * Obtiene la etiqueta del nodo.
     *
     * @return La etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Compara la etiqueta de este nodo con otra etiqueta.
     *
     * @param etiqueta - La etiqueta con la que se comparará la etiqueta de este nodo.
     * @return -1 si la etiqueta de este nodo es menor, 0 si son iguales, 1 si es mayor.
     */
    public int compareTo(Comparable etiqueta);
}