public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null)
                return hijoIzq.buscar(unaEtiqueta);
            else
                return null;
        } else {
            if (hijoDer != null)
                return hijoDer.buscar(unaEtiqueta);
            else
                return null;
        }
    }

    public boolean insertar(TElementoAB elemento) {
        if (elemento.etiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null)
                return hijoIzq.insertar(elemento);
            else {
                hijoIzq = elemento;
                return true;
            }
        } else if (elemento.etiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null)
                return hijoDer.insertar(elemento);
            else {
                hijoDer = elemento;
                return true;
            }
        }
        return false;
    }

    public String preOrden() {
        String res = datos.toString() + " ";
        if (hijoIzq != null) {
            res += hijoIzq.preOrden() + " ";
        }
        if (hijoDer != null) {
            res += hijoDer.preOrden() + " ";
        }
        return res;
    }

    public String inOrden() {
        String res = "";
        if (hijoIzq != null) {
            res += hijoIzq.inOrden() + " ";
        }
        res += datos.toString() + " ";
        if (hijoDer != null) {
            res += hijoDer.inOrden() + " ";
        }
        return res;
    }

    public String postOrden() {
        String res = "";
        if (hijoIzq != null) {
            res += hijoIzq.postOrden() + " ";
        }
        if (hijoDer != null) {
            res += hijoDer.postOrden() + " ";
        }
        res += datos.toString() + " ";
        return res;
    }

    public T getDatos() {
        return datos;
    }

    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        return null;
    }
    // public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
    // if (etiqueta.compareTo(unaEtiqueta)<0) {
    // return hijoIzq.eliminar(unaEtiqueta);
    // }
    // else if (etiqueta.compareTo(unaEtiqueta) > 0) {
    // return hijoDer.eliminar(unaEtiqueta);
    // }
    // else {
    // if (hijoIzq!=null) {
    // TElementoAB<T> aux = hijoIzq;
    // while (aux.hijoDer!=null) {
    // aux = aux.hijoDer;
    // }

    // }
    // }
    // }

}
