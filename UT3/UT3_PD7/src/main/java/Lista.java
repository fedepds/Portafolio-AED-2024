public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;
    private short cantElementos;

    public Lista() {
        primero = null;
        cantElementos = 0;
    }

    public void insertar(Nodo<T> nodo) {
        Nodo<T> aux = primero;
        if (aux == null) {
            primero = nodo;
            cantElementos++;
            return;
        }
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nodo);
        cantElementos++;
    }

    public void insertar (Comparable etiqueta, T dato ) {
        Nodo<T> nuevo = new Nodo<T>(etiqueta, dato);

        Nodo<T> aux = primero;
        if (aux == null) {
            primero = nuevo;
            cantElementos++;
            return;
        }
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nuevo);
        cantElementos++;
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> aux = primero;
        while (aux != null) {
            if (aux.getEtiqueta().equals(clave)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().equals(clave)) {
            primero = primero.getSiguiente();
            cantElementos--;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                cantElementos--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        Nodo<T> aux = primero;
        String str = "";
        while (aux != null) {
            str += aux.getEtiqueta() + " ";
            aux = aux.getSiguiente();
        }
        return str;
    }

    @Override
    public String imprimir(String separador) {
        Nodo<T> aux = primero;
        String str = "";
        while (aux != null) {
            str += aux.getEtiqueta() + separador;
            aux = aux.getSiguiente();
        }
        return str;
    }

    @Override
    public int cantElementos() {
        return cantElementos;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        primero = unNodo;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public int getCantElementos() {
        return cantElementos;
    }



    // implementar los metodos indicados en la interfaz
}
