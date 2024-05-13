package uy.edu.ucu.aed;

import java.util.List;

@SuppressWarnings({"rawtypes"})
public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el árbol. Si ya existe un elemento con la clave
     * proporcionada en "etiqueta", retorna falso.
     *
     * @param etiqueta Clave del elemento a insertar.
     * @param unDato   Dato del elemento a insertar.
     * @return Verdadero si la inserción fue exitosa, falso en caso contrario.
     */
    public boolean insertar(Comparable etiqueta, T unDato);

    /**
     * Busca un elemento en el árbol utilizando la etiqueta como clave de búsqueda.
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return El elemento encontrado. Si no se encuentra, retorna nulo.
     */
    public T buscar(Comparable unaEtiqueta);

    /**
     * Elimina un elemento del árbol basado en su etiqueta.
     *
     * @param unaEtiqueta La etiqueta del elemento a eliminar.
     */
    public void eliminar(Comparable unaEtiqueta);

    /**
     * Realiza un recorrido en preorden del árbol.
     *
     * @return Una lista con los elementos del recorrido en preorden.
     */
    public List<T> preOrden();

    /**
     * Realiza un recorrido en inorden del árbol.
     *
     * @return Una lista con los elementos del recorrido en inorden.
     */
    public List<T> inOrden();
    
    /**
     * Realiza un recorrido en postorden del árbol.
     *
     * @return Una lista con los elementos del recorrido en postorden.
     */
    public List<T> postOrden();
}
