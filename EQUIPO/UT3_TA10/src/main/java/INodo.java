public interface INodo<T> {

    
    /**
     * devuelve el dato del nodo
     * @return 
     */
    public T getDato();
    
    /**
     * devuelve el siguiente del nodo
     * @return 
     */
    public Nodo<T> getSiguiente();
    
    
    /**
     * "engancha" otro nodo a continuacion
     * 
     */
    public void setSiguiente(Nodo<T> nodo);
    
    /**
     * Imprime los datos del nodo
     */
    
    
    
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    
    public void imprimirEtiqueta();

    
    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo<E> unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
