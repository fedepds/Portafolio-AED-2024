package uy.edu.ucu.aed;

import java.util.LinkedList;

/**
 * Interfaz para el elemento de un árbol binario.
 *
 * @param <T> Tipo de los datos almacenados en el elemento.
 */
@SuppressWarnings({"rawtypes"})
public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @param elemento Elemento a asignar como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @param elemento Elemento a asignar como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento);

    /**
     * Busca un elemento dentro del árbol con la etiqueta indicada.
     *
     * @param unaEtiqueta Etiqueta del nodo a buscar.
     * @return Elemento encontrado. Si no se encuentra, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento en el árbol.
     *
     * @param elemento Elemento a insertar.
     * @return Éxito de la operación.
     */
    public boolean insertar(TElementoAB<T> elemento);

    /**
     * Agrega las etiquetas del recorrido en preorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void preOrden(LinkedList<T> unaLista);
    
    /**
     * Agrega las etiquetas del recorrido en inorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void inOrden(LinkedList<T> unaLista);
    
    /**
     * Agrega las etiquetas del recorrido en postorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void postOrden(LinkedList<T> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return Los datos del elemento.
     */
    public T getDatos();
   
    /**
     * Elimina un elemento dado una etiqueta.
     *
     * @param unaEtiqueta Etiqueta del elemento a eliminar.
     * @return Elemento que fue eliminado. Si no se encuentra, retorna nulo.
     */
    public TElementoAB<T> eliminar(Comparable unaEtiqueta);
    
    /**
     * Obtiene el tamaño del árbol (número de elementos).
     *
     * @return Tamaño del árbol.
     */
    public int obtenerTamaño();
}