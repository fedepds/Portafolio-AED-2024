package uy.edu.ucu.aed;

import java.util.List;
import java.util.LinkedList;

@SuppressWarnings({"rawtypes"})
/**
 * Clase que representa un árbol binario de búsqueda (ABB). En un ABB, para cualquier nodo, todos los elementos
 * en el subárbol izquierdo son menores que el elemento en el nodo y todos los elementos en el subárbol derecho
 * son mayores.
 *
 * @param <T> El tipo de los datos que contendrán los elementos del árbol.
 */
public class TArbolBB<T> implements IArbolBB<T> {

    /**
     * Nodo raíz del árbol binario de búsqueda.
     */
    protected TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista.
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    /**
     * Constructor por defecto de la clase TArbolBB. Crea un árbol vacío.
     */
    public TArbolBB() {
        raiz = null;
    }

    /**
     * Inserta un elemento en el árbol. Si el árbol no contiene un elemento con la
     * misma etiqueta, se inserta y retorna verdadero. Si ya existe, no se inserta y retorna falso.
     *
     * @param etiqueta Etiqueta del elemento a insertar.
     * @param unDato   Datos del elemento a insertar.
     * @return Verdadero si el elemento fue insertado correctamente, falso en caso contrario.
     */
    public boolean insertar(Comparable etiqueta, T unDato) {
        TElementoAB<T> unElemento = new TElementoAB<>(etiqueta, unDato);
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * Busca un elemento en el árbol utilizando su etiqueta.
     *
     * @param unaEtiqueta Etiqueta del elemento a buscar.
     * @return Los datos del elemento encontrado. Si no se encuentra, retorna nulo.
     */
    public T buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            TElementoAB<T> elemento = raiz.buscar(unaEtiqueta);
            if (elemento != null) {
                return elemento.getDatos();
            } else {
                return null;
            }
        }
    }

    /**
     * Verifica si el árbol está vacío (sin elementos).
     *
     * @return Verdadero si el árbol está vacío, falso en caso contrario.
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * Elimina todos los elementos del árbol.
     *
     * @return Verdadero si había elementos y el árbol fue vaciado, falso si el árbol ya estaba vacío.
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    /**
     * Devuelve una lista de los elementos del árbol en inorden (izquierda, raíz, derecha).
     *
     * @return Lista con los elementos del árbol en inorden.
     */
    @Override
    public List<T> inOrden() {
        LinkedList<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

    /**
     * Elimina un elemento del árbol dada su etiqueta.
     *
     * @param unaEtiqueta Etiqueta del elemento a eliminar.
     */
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * Devuelve una lista de los elementos del árbol en preorden (raíz, izquierda, derecha).
     *
     * @return Lista con los elementos del árbol en preorden.
     */
    @Override
    public List<T> preOrden() {
        LinkedList<T> listaPreOrden = null;
        if (!esVacio()) {
            listaPreOrden = new LinkedList<>();
            raiz.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    /**
     * Devuelve una lista de los elementos del árbol en postorden (izquierda, derecha, raíz).
     *
     * @return Lista con los elementos del árbol en postorden.
     */
    @Override
    public List<T> postOrden() {
        LinkedList<T> listaPostOrden = null;
        if (!esVacio()) {
            listaPostOrden = new LinkedList<>();
            raiz.postOrden(listaPostOrden);
        }
        return listaPostOrden;
    }

    /**
     * Obtiene el nodo raíz del árbol binario de búsqueda.
     *
     * @return El nodo raíz del árbol.
     */
    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    public int obtenerAltura() {
        if (esVacio()) {
            return 0;
        }
        return raiz.obtenerAltura();
    }
}