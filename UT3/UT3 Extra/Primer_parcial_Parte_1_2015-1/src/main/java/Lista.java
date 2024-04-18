
public class Lista<T> implements ILista<T> {

    public Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public boolean insertar (Comparable etiqueta, T dato ){
        Nodo<T> unNodo = new Nodo<T>(etiqueta,dato);
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> aux = primero;
            if (aux.getEtiqueta().compareTo(etiqueta) > 0) {
                unNodo.setSiguiente(aux);
                primero = unNodo;
                return true;
            }
            while (aux.getSiguiente() != null) {
                if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) > 0) {
                    unNodo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(unNodo);
                    return true;
                }
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
        return true;
    }

    /*
     * Busca un nodo en la lista a partir de la etiqueta - "clave"
     * La etiqueta puede ser de cualquier tipo que implemente la interfaz "comparable"
     */
    @Override
    public T buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> aux = primero;
        while (aux != null) {
            if (aux.getEtiqueta().compareTo(clave) == 0) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }

        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo<T> aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
    /*
    * Elimina los nodos duplicados de la lista
    * El tiempo de ejecucion de este metodo es O(n^2)
     */
    public void eliminarDuplicados() {
        if (!esVacia()) {
            Nodo<T> aux = primero;
            while (aux != null) {
                Nodo<T> temp = aux;
                while (temp.getSiguiente() != null) {
                    if (aux.getEtiqueta().compareTo(temp.getSiguiente().getEtiqueta()) == 0) {
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                    } else {
                        temp = temp.getSiguiente();
                    }
                }
                aux = aux.getSiguiente();
            }
        }
    }
}
