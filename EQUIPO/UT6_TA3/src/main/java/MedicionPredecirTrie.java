import java.util.LinkedList;
import java.io.Serializable;


public class MedicionPredecirTrie extends Medible{
    private TArbolTrie trie;
    public MedicionPredecirTrie(TArbolTrie trie) {
        this.trie = trie;
    }


    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];

        for (int i = 0; i < repeticion; i++) { trie.predecir(params[1].toString());}
    }


    @Override
    public Object getObjetoAMedirMemoria() {
        return this.trie;
    }
}
