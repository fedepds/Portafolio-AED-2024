
/**
 * Esta es una interfaz genérica para un nodo de una estructura de datos de árbol.
 * @param <T> el tipo de los elementos almacenados en el nodo del árbol
 */
public interface INodoArbolGenerico<T> {

    /**
     * Inserta un nuevo elemento en el nodo del árbol.
     * @param unaEtiqueta la etiqueta del nuevo elemento
     * @param etiquetaPadre la etiqueta del elemento padre
     * @return true si la inserción fue exitosa, false en caso contrario
     */
    boolean insertar(T unaEtiqueta, T etiquetaPadre);

    /**
     * Imprime los elementos del nodo.
     */
    void imprimir();

    /**
     * Imprime los elementos del nodo con sangría para representar la estructura del árbol.
     * @param nivel el nivel de indentación
     */
    void imprimirIndentado(int nivel);

    /**
     * Obtiene el dato almacenado en el nodo.
     * @return el dato almacenado en el nodo
     */
    T getDato();

    /**
     * Establece el dato almacenado en el nodo.
     * @param unaEtiqueta el nuevo dato para el nodo
     */
    void setDato(T unaEtiqueta);

    /**
     * Busca un elemento en el nodo.
     * @param unaEtiqueta la etiqueta del elemento a buscar
     * @return el nodo que contiene el elemento buscado, o null si el elemento no se encuentra
     */
    TNodoArbolGenerico<T> buscar(T unaEtiqueta);

    /**
     * Establece el hijo del nodo.
     * @param nodo el nuevo nodo hijo
     */
    void setHijo(TNodoArbolGenerico<T> nodo);

    /**
     * Obtiene el hermano del nodo.
     * @return el nodo hermano
     */
    TNodoArbolGenerico<T> getHermano();

    /**
     * Obtiene el hijo del nodo.
     * @return el nodo hijo
     */
    TNodoArbolGenerico<T> getHijo();

    /**
     * Elimina un elemento del nodo.
     * @param unaEtiqueta la etiqueta del elemento a eliminar
     */
    void eliminar(T unaEtiqueta);

    /**
     * Obtiene el nivel del nodo.
     * @return el nivel del nodo
     */
    int obtenerNivel();
}