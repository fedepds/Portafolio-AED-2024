import java.util.Iterator;
import java.util.LinkedList;

/**
 * Esta clase extiende la clase abstracta Medible y proporciona una implementación concreta
 * para medir el rendimiento de una estructura de datos LinkedList.
 */
public class MedicionPredecirLinkedList extends Medible {
    // Variable de instancia para la estructura de datos LinkedList
    private LinkedList linkedList;

    /**
     * Constructor para la clase MedicionPredecirLinkedList.
     * @param linkedList La estructura de datos LinkedList que se utilizará para la medición del rendimiento.
     */
    public MedicionPredecirLinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * Sobrescribe el método abstracto ejecutar en la clase Medible.
     * Este método realiza una operación de predicción en el LinkedList para un número dado de repeticiones y palabras.
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
     * Este método realiza una operación de predicción en el LinkedList para un prefijo dado y una lista de palabras.
     * @param prefijo El prefijo para la predicción.
     * @param palabras La lista de palabras para la predicción.
     */
    public void predecir(String prefijo, LinkedList<String> palabras) {
        Iterator<String> iterator= this.linkedList.iterator();

        while(iterator.hasNext()){
            String s = iterator.next();
            if (s.startsWith(prefijo)){
                palabras.add(s);
            }
        }
    }

    /**
     * Sobrescribe el método abstracto getObjetoAMedirMemoria en la clase Medible.
     * Este método devuelve la estructura de datos LinkedList que se utiliza para la medición del rendimiento.
     * @return La estructura de datos LinkedList.
     */
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
}
