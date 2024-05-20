public class MedicionBuscarTrie extends Medible{

    private TArbolTrie trie;
    public MedicionBuscarTrie(TArbolTrie trie) {
        this.trie = trie;
    }


    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                trie.buscar(palabra);
            }
        }

    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.trie;
    }
}
