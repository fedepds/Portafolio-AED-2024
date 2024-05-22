import java.util.TreeMap;
/**
 * This class extends the abstract class Medible and provides a concrete implementation
 * for measuring the performance of a TreeMap data structure.
 */
public class MedicionBuscarTreeMap extends Medible {

    // Instance variable for the TreeMap data structure
    private TreeMap treeMap;

    /**
     * Constructor for the MedicionBuscarTreeMap class.
     * @param treeMap The TreeMap data structure to be used for performance measurement.
     */
    public MedicionBuscarTreeMap(TreeMap treeMap) {
        this.treeMap = treeMap;
    }

    /**
     * Overrides the abstract method ejecutar in the Medible class.
     * This method performs a search operation on the TreeMap for a given number of repetitions and words.
     * @param params Varargs parameter that takes in the number of repetitions as an Integer and the words to be searched as a String array.
     */
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                treeMap.containsKey(palabra);
            }
        }
    }

    /**
     * Overrides the abstract method getObjetoAMedirMemoria in the Medible class.
     * This method returns the TreeMap data structure that is used for performance measurement.
     * @return The TreeMap data structure.
     */
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.treeMap;
    }
}
