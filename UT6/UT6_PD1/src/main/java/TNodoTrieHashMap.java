import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TNodoTrieHashMap implements INodoTrie{
    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (char c : unaPalabra.toCharArray()) {
            nodo.hijos.putIfAbsent(c, new TNodoTrieHashMap());
            nodo = nodo.hijos.get(c);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (char c : nodo.hijos.keySet()) {
                imprimir(s + c, nodo.hijos.get(c));
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (char c : s.toCharArray()) {
            if (!nodo.hijos.containsKey(c)) {
                return null;
            }
            nodo = nodo.hijos.get(c);
        }
        return nodo;
    }

    @Override
    public int buscar(String s) {
        TNodoTrieHashMap nodo = this;
        int comparaciones = 0;
        for (char c : s.toCharArray()) {
            nodo = nodo.hijos.get(c);
            comparaciones++;
            if (nodo == null) {
                return comparaciones;
            }
        }
        return nodo.esPalabra ? comparaciones : 0;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (char c : nodo.hijos.keySet()) {
                predecir(s + c, palabras, nodo.hijos.get(c));
            }
        }
    }

    @Override
    public void predecir(String prefijo, List<String> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, (LinkedList<String>) palabras, nodo);
        }
    }
}
