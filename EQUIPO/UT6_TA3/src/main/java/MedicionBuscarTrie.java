/**
 * This class extends the abstract class Medible and provides a concrete implementation
 * for measuring the performance of a Trie data structure.
 */
public class MedicionBuscarTrie extends Medible{

    // Instance variable for the Trie data structure
    private TArbolTrie trie;

    /**
     * Constructor for the MedicionBuscarTrie class.
     * @param trie The Trie data structure to be used for performance measurement.
     */
    public MedicionBuscarTrie(TArbolTrie trie) {
        this.trie = trie;
    }

    /**
     * Overrides the abstract method ejecutar in the Medible class.
     * This method performs a search operation on the Trie for a given number of repetitions and words.
     * @param params Varargs parameter that takes in the number of repetitions as an Integer and the words to be searched as a String array.
     */
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

    /**
     * Overrides the abstract method getObjetoAMedirMemoria in the Medible class.
     * This method returns the Trie data structure that is used for performance measurement.
     * @return The Trie data structure.
     */
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.trie;
    }
}