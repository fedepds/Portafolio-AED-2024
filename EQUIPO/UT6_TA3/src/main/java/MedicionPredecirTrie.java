/**
 * Esta clase extiende la clase abstracta Medible y proporciona una implementación concreta
 * para medir el rendimiento de una estructura de datos Trie.
 */
public class MedicionPredecirTrie extends Medible{
    // Variable de instancia para la estructura de datos Trie
    private TArbolTrie trie;

    /**
     * Constructor para la clase MedicionPredecirTrie.
     * @param trie La estructura de datos Trie que se utilizará para la medición del rendimiento.
     */
    public MedicionPredecirTrie(TArbolTrie trie) {
        this.trie = trie;
    }

    /**
     * Sobrescribe el método abstracto ejecutar en la clase Medible.
     * Este método realiza una operación de predicción en el Trie para un número dado de repeticiones y palabras.
     * @param params Parámetro varargs que toma el número de repeticiones como un Integer y las palabras a predecir como un String.
     */
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];

        for (int i = 0; i < repeticion; i++) { trie.predecir(params[1].toString());}
    }

    /**
     * Sobrescribe el método abstracto getObjetoAMedirMemoria en la clase Medible.
     * Este método devuelve la estructura de datos Trie que se utiliza para la medición del rendimiento.
     * @return La estructura de datos Trie.
     */
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.trie;
    }
}