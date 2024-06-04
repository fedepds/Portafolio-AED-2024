import java.util.ArrayList;
import java.util.HashMap;

public class TTrieHashMap {
    private TNodoTrieHashMap raiz;

    public TTrieHashMap() {
        raiz = new TNodoTrieHashMap();
    }

    public TNodoTrieHashMap getRaiz() {
        return raiz;
    }

    public void insertar(String palabra) {
        TNodoTrieHashMap nodoActual = raiz;
        for (char c : palabra.toCharArray()) {
            nodoActual.getHijos().putIfAbsent(c, new TNodoTrieHashMap());
            nodoActual = nodoActual.getHijos().get(c);
        }
        nodoActual.setEsPalabra(true);
    }

    public boolean buscar(String palabra) {
        TNodoTrieHashMap nodoActual = raiz;
        for (char c : palabra.toCharArray()) {
            nodoActual = nodoActual.getHijos().get(c);
            if (nodoActual == null) {
                return false;
            }
        }
        return nodoActual.esPalabra();
    }

    public boolean predecir(String prefijo) {
        TNodoTrieHashMap nodoActual = raiz;
        for (char c : prefijo.toCharArray()) {
            nodoActual = nodoActual.getHijos().get(c);
            if (nodoActual == null) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> autocompletar(String prefijo) {
        ArrayList<String> resultados = new ArrayList<>();
        TNodoTrieHashMap nodoActual = raiz;
        for (char c : prefijo.toCharArray()) {
            nodoActual = nodoActual.getHijos().get(c);
            if (nodoActual == null) {
                return resultados;
            }
        }
        encontrarPalabras(nodoActual, prefijo, resultados);
        return resultados;
    }

    private void encontrarPalabras(TNodoTrieHashMap nodo, String prefijo, ArrayList<String> resultados) {
        if (nodo.esPalabra()) {
            resultados.add(prefijo);
        }
        for (char c : nodo.getHijos().keySet()) {
            encontrarPalabras(nodo.getHijos().get(c), prefijo + c, resultados);
        }
    }

    public ArrayList<Integer> buscarPatron(String texto, String patron) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i <= texto.length() - patron.length(); i++) {
            if (buscar(patron, texto.substring(i))) {
                posiciones.add(i);
            }
        }
        return posiciones;
    }

    private boolean buscar(String patron, String texto) {
        TNodoTrieHashMap nodoActual = raiz;
        for (char c : texto.toCharArray()) {
            nodoActual = nodoActual.getHijos().get(c);
            if (nodoActual == null) {
                return false;
            }
        }
        return true;
    }
}
