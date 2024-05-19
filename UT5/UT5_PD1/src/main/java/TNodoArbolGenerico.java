/**
 * Esta clase representa un nodo de árbol genérico.
 * @param <T> el tipo de los datos almacenados en el nodo
 */

public class TNodoArbolGenerico<T> implements INodoArbolGenerico<T> {
    private T dato;
    private TNodoArbolGenerico<T> hijo;
    private TNodoArbolGenerico<T> hermano;

    /**
     * Constructor para el nodo de árbol genérico.
     * @param dato los datos a almacenar en el nodo
     */
    public TNodoArbolGenerico(T dato) {
        this.dato = dato;
        this.hijo = null;
        this.hermano = null;
    }


    /**
     * Establece el hijo del nodo actual.
     * @param nodo el nodo a establecer como hijo
     */

    @Override
    public void setHijo(TNodoArbolGenerico<T> nodo) {
        this.hijo = nodo;
    }

    /**
     * Establece el hermano del nodo actual.
     * @param nodo el nodo a establecer como hermano
     */

    public void setHermano(TNodoArbolGenerico<T> nodo) {
        this.hermano = nodo;
    }

    /**
     * Inserta un nuevo nodo en el árbol.
     * @param unaEtiqueta los datos del nuevo nodo
     * @param etiquetaPadre los datos del nodo padre
     * @return verdadero si la inserción fue exitosa, falso en caso contrario
     */
    @Override
    public boolean insertar(T unaEtiqueta, T etiquetaPadre) {
        TNodoArbolGenerico<T> nodo = new TNodoArbolGenerico<>(unaEtiqueta);
        TNodoArbolGenerico<T> padre = this.buscar(etiquetaPadre);
        if (padre != null) {
            if (padre.getHijo() == null) {
                padre.setHijo(nodo);
            } else {
                TNodoArbolGenerico<T> aux = padre.getHijo();
                while (aux.getHermano() != null) {
                    aux = aux.getHermano();
                }
                aux.setHermano(nodo);
            }
            return true;
        }
        return false;
    }
    /**
     * Imprime los datos del nodo actual y sus descendientes.
     */

    @Override
    public void imprimir() {
        System.out.println(this.dato);
        TNodoArbolGenerico<T> aux = this.hijo;
        while (aux != null) {
            aux.imprimir();
            aux = aux.getHermano();
        }
    }

    /**
     * Imprime los datos del nodo actual y sus descendientes, con sangría representando el nivel de cada nodo.
     * @param nivel el nivel de sangría
     */

    @Override
    public void imprimirIndentado(int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }
        System.out.println(this.dato);
        TNodoArbolGenerico<T> aux = this.hijo;
        while (aux != null) {
            aux.imprimirIndentado(nivel + 1);
            aux = aux.getHermano();
        }
    }
    /**
     * Devuelve los datos almacenados en el nodo actual.
     * @return los datos del nodo
     */

    @Override
    public T getDato() {
        return this.dato;
    }


    /**
     * Establece los datos del nodo actual.
     * @param unaEtiqueta los datos a establecer
     */
    @Override
    public void setDato(T unaEtiqueta) {
        this.dato = unaEtiqueta;
    }

    /**
     * Busca un nodo con los datos especificados.
     * @param unaEtiqueta los datos a buscar
     * @return el nodo si se encuentra, null en caso contrario
     */
    @Override
    public TNodoArbolGenerico<T> buscar(T unaEtiqueta) {
        if (this.dato.equals(unaEtiqueta)) {
            return this;
        }
        TNodoArbolGenerico<T> aux = this.hijo;
        while (aux != null) {
            TNodoArbolGenerico<T> nodo = aux.buscar(unaEtiqueta);
            if (nodo != null) {
                return nodo;
            }
            aux = aux.getHermano();
        }
        return null;

    }

    /**
     * Devuelve el hermano del nodo actual.
     * @return el hermano del nodo
     */

    @Override
    public TNodoArbolGenerico<T> getHermano() {
        return this.hermano;
    }

    /**
     * Devuelve el hijo del nodo actual.
     * @return el hijo del nodo
     */
    @Override
    public TNodoArbolGenerico<T> getHijo() {
        return this.hijo;
    }

    /**
     * Elimina un nodo con los datos especificados.
     * @param unaEtiqueta los datos del nodo a eliminar
     */
    @Override
    public void eliminar(T unaEtiqueta) {
        TNodoArbolGenerico<T> nodo = this.buscar(unaEtiqueta);
        if (nodo != null) {
            TNodoArbolGenerico<T> padre = this.buscarPadre(unaEtiqueta);
            if (padre != null) {
                if (padre.getHijo().getDato().equals(unaEtiqueta)) {
                    padre.setHijo(nodo.getHermano());
                } else {
                    TNodoArbolGenerico<T> aux = padre.getHijo();
                    while (!aux.getHermano().getDato().equals(unaEtiqueta)) {
                        aux = aux.getHermano();
                    }
                    aux.setHermano(nodo.getHermano());
                }
            }
        }
    }

    /**
     * Devuelve el nivel del nodo actual.
     * @return el nivel del nodo
     */
    @Override
    public int obtenerNivel() {
        int nivel = 0;
        TNodoArbolGenerico<T> aux = this;
        while (aux.getHermano() != null) {
            nivel++;
            aux = aux.getHermano();
        }
        return nivel;
    }
    /**
     * Devuelve el nivel del nodo actual.
     * @return el nivel del nodo
     */
    public int obtenerNivelNodo() {
        int nivel = 1;
        TNodoArbolGenerico<T> aux = this;
        while (aux.getHermano() != null) {
            nivel++;
            aux = aux.getHermano();
        }
        return nivel;
    }
    /**
     * Busca el padre de un nodo con los datos especificados.
     * @param unaEtiqueta los datos del nodo para encontrar al padre
     * @return el nodo padre si se encuentra, null en caso contrario
     */

    private TNodoArbolGenerico<T> buscarPadre(T unaEtiqueta) {
        if (this.hijo != null) {
            if (this.hijo.getDato().equals(unaEtiqueta)) {
                return this;
            } else {
                TNodoArbolGenerico<T> aux = this.hijo;
                while (aux.getHermano() != null) {
                    if (aux.getHermano().getDato().equals(unaEtiqueta)) {
                        return aux;
                    }
                    aux = aux.getHermano();
                }
            }
        }
        return null;
    }



}
