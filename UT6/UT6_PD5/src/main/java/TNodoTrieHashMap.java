import java.util.HashMap;

public class TNodoTrieHashMap {
    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    public HashMap<Character, TNodoTrieHashMap> getHijos() {
        return hijos;
    }

    public boolean esPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }
}
