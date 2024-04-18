

public interface ILista<T> {

    /**
     * Agrega un nuevo nodo al final de la lista.
     *
     * @param dato - El valor que se almacenará en el nuevo nodo.
     * @param clave - La clave única que identificará al nuevo nodo.
     */
    public void insertar(T dato, Comparable clave);

    /**
     * Busca un nodo en la lista utilizando su clave.
     *
     * @param clave - La clave del nodo a buscar.
     * @return El valor del nodo si se encuentra, null en caso contrario.
     */
    public T buscar(Comparable clave);

    /**
     * Elimina un nodo de la lista utilizando su clave.
     *
     * @param clave - La clave del nodo a eliminar.
     * @return True si el nodo fue eliminado con éxito, false en caso contrario.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Genera una representación en cadena de las claves de los nodos en la lista.
     *
     * @return Una cadena que contiene las claves de todos los nodos en la lista.
     */
    public String imprimir();

    /**
     * Genera una representación en cadena de las claves de los nodos en la lista, separadas por un separador específico.
     *
     * @param separador - El caracter o cadena que se utilizará para separar las claves en la cadena resultante.
     * @return Una cadena que contiene las claves de todos los nodos en la lista, separadas por el separador proporcionado.
     */
    public String imprimir(String separador);

    /**
     * Obtiene la cantidad de nodos en la lista.
     *
     * @return El número de nodos en la lista. Si la lista está vacía, retorna 0.
     */
    public int cantElementos();

    /**
     * Determina si la lista está vacía o no.
     *
     * @return True si la lista no contiene nodos, false en caso contrario.
     */
    public boolean esVacia();

    /**
     * Establece el primer nodo de la lista.
     *
     * @param unNodo - El nodo que se establecerá como el primero en la lista.
     */
    public void setPrimero( Nodo<T> unNodo);

}