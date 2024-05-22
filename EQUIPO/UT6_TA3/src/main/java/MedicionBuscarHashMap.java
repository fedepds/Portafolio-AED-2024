import java.util.HashMap;
/**
 * Esta clase extiende la clase abstracta Medible y proporciona una implementación concreta
 * para medir el rendimiento de una estructura de datos HashMap.
 */
public class MedicionBuscarHashMap extends Medible {

    // Variable de instancia para la estructura de datos HashMap
    private HashMap hashMap;

    /**
     * Constructor para la clase MedicionBuscarHashMap.
     * @param hashMap La estructura de datos HashMap que se utilizará para la medición del rendimiento.
     */
    public MedicionBuscarHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    /**
     * Sobrescribe el método abstracto ejecutar en la clase Medible.
     * Este método realiza una operación de búsqueda en el HashMap para un número dado de repeticiones y palabras.
     * @param params Parámetro varargs que toma el número de repeticiones como un Integer y las palabras a buscar como un array de String.
     */
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                hashMap.containsKey(palabra);
            }
        }
    }

    /**
     * Sobrescribe el método abstracto getObjetoAMedirMemoria en la clase Medible.
     * Este método devuelve la estructura de datos HashMap que se utiliza para la medición del rendimiento.
     * @return La estructura de datos HashMap.
     */
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }
}