
public class Nodo<T> implements INodo<T>{
    private Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente;
    /**
     * Constructor de la clase Nodo.
     * Precondiciones: La etiqueta y el dato no deben ser null.
     * Postcondiciones: Se crea una instancia de Nodo con los atributos etiqueta, dato y siguiente inicializados.
     */
    public Nodo(Comparable etiqueta, T dato){
        this.etiqueta = etiqueta;
        this.dato = dato;
        this.siguiente = null;
    }
    /**
     * Retorna el dato del nodo.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna el dato del nodo.
     */
    @Override
    public T getDato(){
        return this.dato;
    }
    /**
     * Retorna el siguiente nodo.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna el siguiente nodo.
     */
    @Override
    public Nodo<T> getSiguiente(){
        return this.siguiente;
    }
    /**
     * Establece el siguiente nodo.
     * Precondiciones: El nodo no debe ser null.
     * Postcondiciones: El siguiente nodo se establece en el nodo proporcionado.
     */
    @Override
    public void setSiguiente(Nodo<T> nodo){
        this.siguiente = nodo;
    }
    /**
     * Imprime el dato del nodo.
     * Precondiciones: Ninguna.
     * Postcondiciones: El dato del nodo se imprime en la consola.
     */
    @Override
    public void imprimir(){
        System.out.println(this.dato);
    }
    /**
     * Imprime la etiqueta del nodo.
     * Precondiciones: Ninguna.
     * Postcondiciones: La etiqueta del nodo se imprime en la consola.
     */
    @Override
    public void imprimirEtiqueta(){
        System.out.println(this.etiqueta);
    }
    /**
     * Retorna la etiqueta del nodo.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna la etiqueta del nodo.
     */
    @Override
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }
    /**
     * Compara la etiqueta del nodo con la etiqueta proporcionada.
     * Precondiciones: La etiqueta no debe ser null.
     * Postcondiciones: Retorna un valor negativo si la etiqueta del nodo es menor que la etiqueta proporcionada, 0 si son iguales, y un valor positivo si la etiqueta del nodo es mayor.
     */
    @Override
    public int compareTo(Comparable etiqueta){
        return this.etiqueta.compareTo(etiqueta);
    }


}
