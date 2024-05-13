package uy.edu.ucu.aed;

public class TArbolDeProductos extends TArbolBB<Producto> {

    /* Como una medida posible que da una idea sobre la forma de un árbol binario, se define como "longitud de
       trayectoria interna" (LTI) de un árbol a la suma de los niveles de todos los nodos del árbol, y como
       "longitud de trayectoria interna media" (LTIM) a ese valor dividido por la cantidad de nodos del árbol
       (tamaño longitudTrayectoriaInterna() debe calcular la suma de los niveles de todos los nodos del árbol) */

    /**
     * Calcula la longitud de la trayectoria interna del árbol.
     *
     * @return La longitud de la trayectoria interna del árbol.
     */
    public int longitudTrayectoriaInterna() {
        return longitudTrayectoriaInternaAux(this.raiz, 0);
    }

    /**
     * Método auxiliar para calcular la longitud de la trayectoria interna del árbol.
     *
     * @param nodo El nodo actual.
     * @param nivel El nivel actual.
     * @return La longitud de la trayectoria interna del árbol.
     */
    public int longitudTrayectoriaInternaAux(TElementoAB<Producto> nodo, int nivel) {
        if (nodo == null) {
            return 0;
        } else {
            return nivel + longitudTrayectoriaInternaAux(nodo.getHijoIzq(), nivel + 1) + longitudTrayectoriaInternaAux(nodo.getHijoDer(), nivel + 1);
        }
    }

    /**
     * Calcula la longitud media de la trayectoria interna del árbol.
     *
     * @return La longitud media de la trayectoria interna del árbol.
     */
    public double longitudTrayectoriaInternaMedia() {
        if (this.raiz == null) {
            return 0;
        } else {
            return (double) longitudTrayectoriaInterna() / this.raiz.obtenerTamaño();
        }
    }
}

