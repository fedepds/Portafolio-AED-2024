import java.util.HashMap;
import java.util.LinkedList;

/**
 * Esta clase extiende la clase abstracta Medible y proporciona una implementación concreta
 * para medir el rendimiento de una estructura de datos HashMap.
 */
public class MedicionPredecirHashMap extends Medible{

    // Variable de instancia para la estructura de datos HashMap
    private HashMap hashMap;

    /**
     * Constructor para la clase MedicionPredecirHashMap.
     * @param hashMap La estructura de datos HashMap que se utilizará para la medición del rendimiento.
     */
    public MedicionPredecirHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    /**
     * Sobrescribe el método abstracto ejecutar en la clase Medible.
     * Este método realiza una operación de predicción en el HashMap para un número dado de repeticiones y palabras.
     * @param params Parámetro varargs que toma el número de repeticiones como un Integer y las palabras a predecir como un String.
     */
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        for (int i = 0; i < repeticion; i++) {
            predecir(params[1].toString(), new LinkedList<String>());
        }
    }

    /**
     * Este método realiza una operación de predicción en el HashMap para un prefijo dado y una lista de palabras.
     * @param prefijo El prefijo para la predicción.
     * @param palabras La lista de palabras para la predicción.
     */
    public void predecir(String prefijo, LinkedList<String> palabras) {
        for (Object key : hashMap.keySet()) {
            String s = key.toString();
            if (s.startsWith(prefijo)){
                palabras.add(s);
            }
        }
    }

    /**
     * Sobrescribe el método abstracto getObjetoAMedirMemoria en la clase Medible.
     * Este método devuelve null ya que no se está midiendo la memoria en esta implementación.
     * @return null.
     */
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }
}
