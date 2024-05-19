import java.util.*;

public class TNodoTrie implements INodoTrie {
    private final static int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList();
    }

    public LinkedList<Integer> getPaginas() {
        return this.paginas;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = getIndice(unaPalabra.charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private int getIndice(char c) {
        return  c - 'a';
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndice(s.charAt(c));
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    /**
     * Busca una palabra en el trie y devuelve la cantidad de comparaciones realizadas durante la búsqueda.
     *
     * @param s La palabra a buscar dentro del trie.
     * @return El número de comparaciones realizadas para determinar si la palabra está o no en el trie.
     */
    @Override
    public int buscar(String s) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndice(s.charAt(c));
            nodo = nodo.hijos[indice];
            comparaciones++;
            if (nodo == null) {
                return comparaciones;
            }
        }
        return nodo.esPalabra ? comparaciones : -1;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), palabras, nodo.hijos[c]);
                }
            }
        }
    }

    /**
     * Genera una lista de todas las palabras que contienen el prefijo dado.
     * Las palabras encontradas se agregan a la lista 'palabras'.
     *
     * @param prefijo El prefijo que se utilizará para buscar palabras en el trie.
     * @param palabras Lista de strings donde se almacenarán las palabras encontradas que coinciden con el prefijo dado.
     */
    @Override
    public void predecir(String prefijo, List<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, (LinkedList<String>) palabras, nodo);
        }
    }

    public LinkedList<Integer> buscarPaginas(String palabra) {
        palabra = palabra.toLowerCase();
        TNodoTrie nodoActual = this;
        for (int i = 0; i < palabra.length(); i++) {
            int indice = palabra.charAt(i) - 'a';
            if (nodoActual.hijos[indice] == null) {
                throw new NoSuchElementException("La palabra no se encuentra en el trie");
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if(nodoActual.esPalabra){
            return nodoActual.getPaginas();
        }
        return null;
    }
}
