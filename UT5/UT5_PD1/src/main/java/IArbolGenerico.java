/**
 * Esta es una interfaz genérica para una estructura de datos de árbol.
 * @param <T> el tipo de los elementos almacenados en el árbol
 */
public interface IArbolGenerico<T> {

    /**
     * Inserta un nuevo elemento en el árbol.
     * @param unaEtiqueta la etiqueta del nuevo elemento
     * @param etiquetaPadre la etiqueta del elemento padre
     */
    void insertar(T unaEtiqueta, T etiquetaPadre);

    /**
     * Imprime los elementos del árbol.
     */
    void imprimir();

    /**
     * Imprime los elementos del árbol con sangría para representar la estructura del árbol.
     */
    void imprimirIndentado();

    /**
     * Busca un elemento en el árbol.
     * @param unaEtiqueta la etiqueta del elemento a buscar
     * @return el nodo que contiene el elemento buscado, o null si el elemento no se encuentra
     */
    TNodoArbolGenerico<T> buscar(T unaEtiqueta);

    /**
     * Elimina un elemento del árbol.
     * @param unaEtiqueta la etiqueta del elemento a eliminar
     */
    void eliminar(T unaEtiqueta);

    /**
     * Devuelve el nivel del árbol.
     * @return el nivel del árbol
     */
    int obtenerNivel();
}