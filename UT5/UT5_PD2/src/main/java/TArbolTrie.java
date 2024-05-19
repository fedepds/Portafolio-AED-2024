import java.util.*;

/**
 * La clase TArbolTrie implementa la interfaz IArbolTrie y representa un árbol Trie para el manejo eficiente de un conjunto de palabras.
 * Esta estructura de datos facilita la inserción, búsqueda y predicción de palabras basadas en prefijos.
 */
public class TArbolTrie implements IArbolTrie {

    /**
     * Nodo raíz del árbol Trie.
     */
    private TNodoTrie raiz;

    /**
     * Inserta una palabra en el árbol Trie. Si la raíz es nula, se crea un nuevo nodo raíz y se inserta la palabra a partir de este nodo.
     *
     * @param palabra La palabra a insertar en el árbol Trie.
     */
    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    /**
     * Imprime todas las palabras contenidas en el árbol Trie. Si la raíz no es nula, se delega la impresión al nodo raíz.
     */
    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    /**
     * Busca una palabra en el árbol Trie y devuelve la cantidad de comparaciones realizadas.
     * Si la raíz es nula, se devuelve 0, indicando que no se encontró la palabra.
     * Si la raíz no es nula, se delega la búsqueda al nodo raíz.
     *
     * @param palabra La palabra a buscar en el árbol Trie.
     * @return El número de comparaciones realizadas durante la búsqueda.
     */
    @Override
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    /**
     * Dado un prefijo, genera una lista de todas las palabras en el árbol Trie que comienzan con ese prefijo.
     * Si la raíz es nula o el prefijo es nulo o vacío, se devuelve una lista vacía.
     * Si no, se delega la operación de predicción al nodo raíz.
     *
     * @param prefijo El prefijo a utilizar para encontrar palabras que comiencen con él.
     * @return Una lista de palabras que comienzan con el prefijo dado.
     */
    @Override
    public List<String> predecir(String prefijo) {
        LinkedList<String> resultados = new LinkedList<>();
        if (raiz != null && prefijo != null && !prefijo.isEmpty()) {
            raiz.predecir(prefijo, resultados);
        }
        return resultados;
    }
}
