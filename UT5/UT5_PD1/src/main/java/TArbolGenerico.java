/**
 * Esta es una clase genérica que implementa una estructura de datos de árbol.
 * @param <T> el tipo de los elementos almacenados en el árbol
 */
public class TArbolGenerico<T> implements IArbolGenerico<T> {
    private TNodoArbolGenerico<T> raiz;

    /**
     * Constructor de la clase.
     * @param raiz el nodo raíz del árbol
     */
    public TArbolGenerico(TNodoArbolGenerico<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Inserta un nuevo elemento en el árbol.
     * @param unaEtiqueta la etiqueta del nuevo elemento
     * @param etiquetaPadre la etiqueta del elemento padre
     */
    @Override
    public void insertar(T unaEtiqueta, T etiquetaPadre) {
        raiz.insertar(unaEtiqueta, etiquetaPadre);
    }

    /**
     * Imprime los elementos del árbol.
     */
    @Override
    public void imprimir() {
        raiz.imprimir();
    }

    /**
     * Imprime los elementos del árbol con sangría para representar la estructura del árbol.
     */
    @Override
    public void imprimirIndentado() {
        raiz.imprimirIndentado(0);
    }

    /**
     * Busca un elemento en el árbol.
     * @param unaEtiqueta la etiqueta del elemento a buscar
     * @return el nodo que contiene el elemento buscado, o null si el elemento no se encuentra
     */
    @Override
    public TNodoArbolGenerico<T> buscar(T unaEtiqueta) {
        return raiz.buscar(unaEtiqueta);
    }

    /**
     * Elimina un elemento del árbol.
     * @param unaEtiqueta la etiqueta del elemento a eliminar
     */
    @Override
    public void eliminar(T unaEtiqueta) {
        raiz.eliminar(unaEtiqueta);
    }

    /**
     * Obtiene el nivel del árbol.
     * @return el nivel del árbol
     */
    @Override
    public int obtenerNivel() {
        return raiz.obtenerNivel();
    }
}