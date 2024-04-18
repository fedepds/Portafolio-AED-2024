public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz != null) {
            return raiz.insertar(unElemento);
        }
        raiz = unElemento;
        return true;
    }

    public String preOrden() {
        if (raiz != null) {
            return raiz.preOrden();
        }
        return null;
    }

    public String inOrden() {
        if (raiz != null) {
            return raiz.inOrden();
        }
        return null;
    }

    public String postOrden() {
        if (raiz != null) {
            return raiz.postOrden();
        }
        return null;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

}
