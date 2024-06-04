import java.util.LinkedList;
import java.util.List;

public class TArbolTrieHashMap implements IArbolTrie{
    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    @Override
    public List<String> predecir(String prefijo) {
        LinkedList<String> resultados = new LinkedList<>();
        if (raiz != null && prefijo != null && !prefijo.isEmpty()) {
            raiz.predecir(prefijo, resultados);
        }
        return resultados;
    }
}
