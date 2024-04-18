public class Conjunto<T> implements IConjunto {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    /**
     * Constructor de la clase Lista.
     * Precondiciones: Ninguna.
     * Postcondiciones: Se crea una instancia de Lista con los atributos primero, ultimo y tamanio inicializados.
     */
    public Conjunto(){
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
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

    @Override
    public Object getDato() {
        return null;
    }

    @Override
    public Nodo getSiguiente() {
        return null;
    }

    @Override
    public void setSiguiente(Nodo nodo) {

    }

    /**
     * Imprime las etiquetas de los nodos en la lista separadas por un espacio.
     * Precondiciones: Ninguna.
     * Postcondiciones: Retorna un String con las etiquetas de los nodos en la lista separadas por un espacio.
     *
     * @return
     */
    @Override
    public String imprimir() {
        return this.imprimir(" ");
    }

    @Override
    public void imprimirEtiqueta() {

    }

    @Override
    public Comparable getEtiqueta() {
        return null;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return 0;
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
    /**
     * Realiza la operación de unión entre la lista actual y otra lista proporcionada.
     *
     * Precondiciones:
     * 1. `otraLista` no debe ser null. Es decir, se debe proporcionar una lista válida como argumento.
     * 2. Las listas (la lista actual y `otraLista`) deben estar ordenadas. Esto es necesario para que el algoritmo funcione correctamente.
     * 3. Las listas (la lista actual y `otraLista`) deben ser listas de nodos donde cada nodo tiene una etiqueta y un dato. La etiqueta se utiliza para comparar los nodos.
     *
     * Postcondiciones:
     * 1. El método devuelve una nueva lista que es la unión de la lista actual y `otraLista`. La unión de dos listas contiene todos los elementos de ambas listas, sin duplicados.
     * 2. La lista devuelta está ordenada.
     * 3. Las listas originales (la lista actual y `otraLista`) no se modifican.
     *
     * @param otroConjunto La otra lista con la que se realizará la operación de unión.
     * @return Una nueva lista que es la unión de la lista actual y `otraLista`.
     *Tiene un Tiempo de ejecucion  de O(n+m) donde n es la cantidad de elementos de la lista actual y m es la cantidad de elementos de la otra lista.
     */
    public Conjunto union(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo nodo1 = this.primero;
        Nodo nodo2 = otroConjunto.primero;

        while (nodo1 != null && nodo2 != null) {
            int comparacion = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());

            if (comparacion == 0) {
                resultado.insertar(new Nodo(nodo1.getEtiqueta(), nodo1.getDato()));
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            } else if (comparacion < 0) {
                resultado.insertar(new Nodo(nodo1.getEtiqueta(), nodo1.getDato()));
                nodo1 = nodo1.getSiguiente();
            } else {
                resultado.insertar(new Nodo(nodo2.getEtiqueta(), nodo2.getDato()));
                nodo2 = nodo2.getSiguiente();
            }
        }

        while (nodo1 != null) {
            resultado.insertar(new Nodo(nodo1.getEtiqueta(), nodo1.getDato()));
            nodo1 = nodo1.getSiguiente();
        }

        while (nodo2 != null) {
            resultado.insertar(new Nodo(nodo2.getEtiqueta(), nodo2.getDato()));
            nodo2 = nodo2.getSiguiente();
        }

        return resultado;
    }
    /**
     * Realiza la operación de intersección entre la lista actual y otra lista proporcionada.
     * <p>
     * Precondiciones:
     * 1. `otraLista` no debe ser null. Es decir, se debe proporcionar una lista válida como argumento.
     * 2. Las listas (la lista actual y `otraLista`) deben estar ordenadas. Esto es necesario para que el algoritmo funcione correctamente.
     * 3. Las listas (la lista actual y `otraLista`) deben ser listas de nodos donde cada nodo tiene una etiqueta y un dato. La etiqueta se utiliza para comparar los nodos.
     * <p>
     * Postcondiciones:
     * 1. El método devuelve una nueva lista que es la intersección de la lista actual y `otraLista`. La intersección de dos listas contiene solo los elementos que están presentes en ambas listas.
     * 2. La lista devuelta está ordenada.
     * 3. Las listas originales (la lista actual y `otraLista`) no se modifican.
     *
     * @param otroConjunto La otra lista con la que se realizará la operación de intersección.
     * @return Una nueva lista que es la intersección de la lista actual y `otraLista`.
     * Tiempo de ejecución:
     * El tiempo de ejecución es O(n + m), donde n es la cantidad de elementos en la lista actual y m es la cantidad de elementos en `otraLista`.
     */

    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo nodo1 = this.primero;
        Nodo nodo2 = otroConjunto.primero;

        while (nodo1 != null && nodo2 != null) {
            int comparacion = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());

            if (comparacion == 0) {
                resultado.insertar(new Nodo(nodo1.getEtiqueta(), nodo1.getDato()));
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            } else if (comparacion < 0) {
                nodo1 = nodo1.getSiguiente();
            } else {
                nodo2 = nodo2.getSiguiente();
            }
        }

        return resultado;
    }
    /*
        * Realiza la operación de diferencia entre la lista actual y otra lista proporcionada.
        * <p>
        * Precondiciones: 1. `otraLista` no debe ser null. Es decir, se debe proporcionar una lista válida como argumento.
        * 2. Las listas (la lista actual y `otraLista`) deben estar ordenadas. Esto es necesario para que el algoritmo funcione correctamente.
        * 3. Las listas (la lista actual y `otraLista`) deben ser listas de nodos donde cada nodo tiene una etiqueta y un dato. La etiqueta se utiliza para comparar los nodos.
        * <p>
        * Postcondiciones: 1. El método devuelve una nueva lista que es la diferencia entre la lista actual y `otraLista`. La diferencia de dos listas contiene solo los elementos que están presentes en la lista actual y no en `otraLista`.
        * 2. La lista devuelta está ordenada.
        * 3. Las listas originales (la lista actual y `otraLista`) no se modifican.
        * <p>
        * @param otroConjunto La otra lista con la que se realizará la operación de diferencia.
        * @return Una nueva lista que es la diferencia entre la lista actual y `otraLista`.
        * Tiempo de ejecución: El tiempo de ejecución es O(n + m), donde n es la cantidad de elementos en la lista actual y m es la cantidad de elementos en `otraLista`.

    */
    public Conjunto diferenciaSimetrica(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo nodo1 = this.primero;
        Nodo nodo2 = otroConjunto.primero;
        while (nodo1 != null && nodo2 != null) {
            int comparacion = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());
            if (comparacion == 0) {
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            } else if (comparacion < 0) {
                resultado.insertar(new Nodo(nodo1.getEtiqueta(), nodo1.getDato()));
                nodo1 = nodo1.getSiguiente();
            } else {
                resultado.insertar(new Nodo(nodo2.getEtiqueta(), nodo2.getDato()));
                nodo2 = nodo2.getSiguiente();
            }
        }

        return resultado;
    }

    /*
        * Realiza el complemento de un conjunto con respecto a otro conjunto universal.
        * <p>
        * Precondiciones: 1. `conjuntoUniversal` no debe ser null. Es decir, se debe proporcionar un conjunto universal válido como argumento.
        * 2. Las listas (la lista actual y `conjuntoUniversal`) deben estar ordenadas. Esto es necesario para que el algoritmo funcione correctamente.
        *  <p>
        * Postcondiciones: 1. El método devuelve una nueva lista que es el complemento de la lista actual con respecto a `conjuntoUniversal`. El complemento de un conjunto con respecto a otro conjunto universal contiene los elementos que están presentes en el conjunto universal pero no en el conjunto actual.
        * 2. La lista devuelta está ordenada.
        * 3. Las listas originales (la lista actual y `conjuntoUniversal`) no se modifican.
        * <p>
        * @param conjuntoUniversal El conjunto universal con respecto al cual se realizará el complemento.
        * @return Una nueva lista que es el complemento de la lista actual con respecto a `conjuntoUniversal`.
     */
    public Conjunto complemento(Conjunto universalConjunto){
        Conjunto resultado = new Conjunto();
        Nodo nodo1 = this.primero;
        Nodo nodo2 = universalConjunto.primero;
        while (nodo1 != null && nodo2 != null) {
            int comparacion = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());
            if (comparacion == 0) {
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            } else if (comparacion < 0) {
                resultado.insertar(new Nodo(nodo1.getEtiqueta(), nodo1.getDato()));
                nodo1 = nodo1.getSiguiente();
            } else {
                nodo2 = nodo2.getSiguiente();
            }
        }

        // Agregar los nodos restantes de conjuntoUniversal.primero al resultado
        while (nodo2 != null) {
            resultado.insertar(new Nodo(nodo2.getEtiqueta(), nodo2.getDato()));
            nodo2 = nodo2.getSiguiente();
        }

        return resultado;
    }


}
