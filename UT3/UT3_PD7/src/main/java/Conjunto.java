public class Conjunto<T> implements IConjunto<T> {
    private ILista<T> lista;

    public Conjunto() {
        lista = new Lista<T>();
    }

    /*

     */

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        Conjunto<T> conjuntoUnion = new Conjunto<T>();
        Nodo<T> actual = lista.getPrimero();
        while (actual != null) {
            conjuntoUnion.insertar(actual.getEtiqueta(), actual.getDato());
            actual = actual.getSiguiente();
        }
        actual = otroConjunto.getPrimero();
        while (actual != null) {
            if (conjuntoUnion.buscar(actual.getEtiqueta()) == null) {
                conjuntoUnion.insertar(actual.getEtiqueta(), actual.getDato());
            }
            actual = actual.getSiguiente();
        }

        return conjuntoUnion;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        Conjunto<T> conjuntoInterseccion = new Conjunto<T>();
        Nodo<T> actual = lista.getPrimero();
        while (actual != null) {
            if (otroConjunto.buscar(actual.getEtiqueta()) != null) {
                conjuntoInterseccion.insertar(actual.getEtiqueta(), actual.getDato());
            }
            actual = actual.getSiguiente();
        }

        return conjuntoInterseccion;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (!existe(nodo.getEtiqueta())) {
            lista.insertar(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        if (!existe(etiqueta)) {
            lista.insertar(etiqueta, dato);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        return lista.buscar(clave);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return lista.eliminar(clave);
    }

    @Override
    public String imprimir() {
        return lista.imprimir();
    }

    @Override
    public String imprimir(String separador) {
        return lista.imprimir(separador);
    }

    @Override
    public int cantElementos() {
        return lista.cantElementos();
    }

    @Override
    public boolean esVacia() {
        return lista.esVacia();
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        lista.setPrimero(unNodo);
    }

    private boolean existe(Comparable etiqueta) {
        return lista.buscar(etiqueta) != null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return lista.getPrimero();
    }
}
