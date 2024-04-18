public class Lista implements ILista{
    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    /**
     * Constructor de la clase Lista.
     * Precondiciones: Ninguna.
     * Postcondiciones: Se crea una instancia de Lista con los atributos primero, ultimo y tamanio inicializados.
     */
    public Lista(){

    }
    /**
     * Inserta un nodo al final de la lista.
     * Precondiciones: El nodo a insertar no debe ser null.
     * Postcondiciones: El nodo se agrega al final de la lista y se incrementa el tamaño de la lista.
     */

    @Override
    public void insertar(Nodo nodo) {
        if (this.primero == null) {
            this.primero = nodo;
            this.ultimo = nodo;
        } else {
            this.ultimo.setSiguiente(nodo);
            this.ultimo = nodo;
        }
        this.tamanio++;
    }

    /**
     * Crea un nuevo nodo con la etiqueta y dato proporcionados e inserta el nodo en la lista.
     * Precondiciones: La etiqueta y el dato no deben ser null.
     * Postcondiciones: Se crea un nuevo nodo y se inserta en la lista. Se incrementa el tamaño de la lista.
     */
    @Override
    public void insertar(Comparable etiqueta, Object dato) {
        Nodo nodo = new Nodo(etiqueta, dato);
        this.insertar(nodo);
    }
    /**
     * Busca un nodo en la lista por su etiqueta.
     * Precondiciones: La etiqueta no debe ser null.
     * Postcondiciones: Retorna el nodo con la etiqueta proporcionada. Si no se encuentra, retorna null.
     */
    @Override
    public Nodo buscar(Comparable clave) {
        Nodo nodoActual = this.primero;
        while (nodoActual != null) {
            if (nodoActual.getEtiqueta().compareTo(clave) == 0) {
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }
    /**
     * Elimina un nodo de la lista por su etiqueta.
     * Precondiciones: La etiqueta no debe ser null.
     * Postcondiciones: Si el nodo con la etiqueta proporcionada se encuentra en la lista, se elimina y se decrementa el tamaño de la lista. Retorna true si el nodo se eliminó, false en caso contrario.
     */
    @Override
    public boolean eliminar(Comparable clave) {
        Nodo nodoActual = this.primero;
        Nodo nodoAnterior = null;
        while (nodoActual != null) {
            if (nodoActual.getEtiqueta().compareTo(clave) == 0) {
                if (nodoAnterior == null) {
                    this.primero = nodoActual.getSiguiente();
                } else {
                    nodoAnterior.setSiguiente(nodoActual.getSiguiente());
                }
                this.tamanio--;
                return true;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }
    /**
     * Imprime las etiquetas de los nodos en la lista separadas por un espacio.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna un String con las etiquetas de los nodos en la lista separadas por un espacio.
     */
    @Override
    public String imprimir() {
        return this.imprimir(" ");
    }
    /**
     * Imprime las etiquetas de los nodos en la lista separadas por el separador proporcionado.
     * Precondiciones: El separador no debe ser null.
     * Postcondiciones: Retorna un String con las etiquetas de los nodos en la lista separadas por el separador proporcionado.
     */

    @Override
    public String imprimir(String separador) {
        String resultado = "";
        Nodo nodoActual = this.primero;
        while (nodoActual != null) {
            resultado += nodoActual.getEtiqueta().toString() + separador;
            nodoActual = nodoActual.getSiguiente();
        }
        return resultado;
    }
    /**
     * Retorna la cantidad de elementos en la lista.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna el número de elementos en la lista.
     */
    @Override
    public int cantElementos() {
        return this.tamanio;
    }
    /**
     * Indica si la lista está vacía o no.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna true si la lista está vacía, false en caso contrario.
     */
    @Override
    public boolean esVacia() {
        return this.primero == null;
    }
    /**
     * Establece el primer nodo de la lista.
     * Precondiciones: El nodo no debe ser null.
     * Postcondiciones: El primer nodo de la lista se establece en el nodo proporcionado.
     */
    @Override
    public void setPrimero(Nodo unNodo) {
        this.primero = unNodo;
    }

    /**
     * Imprime los datos de todos los nodos en la lista.
     * Precondiciones: Ninguna.
     * Postcondiciones: Los datos de todos los nodos en la lista se imprimen en la consola.
     */
    public void listar() {
        Nodo nodoActual = this.primero;
        while (nodoActual != null) {
            nodoActual.imprimir();
            nodoActual = nodoActual.getSiguiente();
        }
    }


}
