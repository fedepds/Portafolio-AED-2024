/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {
    public ListaOrdenada() {
        super();
    }
    @Override
    public String imprimir() {
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return "";
    }

/*
El orden de ejecucuin de mezclarCon es O(n+m) siendo n la cantidad de elementos de la lista actual y m la cantidad de elementos de la otra lista.
 */
    public ListaOrdenada<T> mezclarCon(ListaOrdenada<T> otraLista) {
        ListaOrdenada<T> listaMezclada = new ListaOrdenada<>();
        Nodo<T> nodo1 = this.getPrimero();
        Nodo<T> nodo2 = otraLista.getPrimero();

        while (nodo1 != null && nodo2 != null) {
            if (nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta()) <= 0) {
                listaMezclada.insertar(nodo1.getEtiqueta(), nodo1.getDato());
                nodo1 = nodo1.getSiguiente();
            } else {
                listaMezclada.insertar(nodo2.getEtiqueta(), nodo2.getDato());
                nodo2 = nodo2.getSiguiente();
            }
        }

        while (nodo1 != null) {
            listaMezclada.insertar(nodo1.getEtiqueta(), nodo1.getDato());
            nodo1 = nodo1.getSiguiente();
        }

        while (nodo2 != null) {
            listaMezclada.insertar(nodo2.getEtiqueta(), nodo2.getDato());
            nodo2 = nodo2.getSiguiente();
        }

        return listaMezclada;
    }
}
