import java.util.LinkedList;
/**
 * Esta clase extiende la clase abstracta Medible y proporciona una implementación concreta
 * para medir el rendimiento de una estructura de datos LinkedList.
 */
public class MedicionBuscarLinkedList extends Medible {

    // Variable de instancia para la estructura de datos LinkedList
    private LinkedList linkedList;

    /**
     * Constructor para la clase MedicionBuscarLinkedList.
     * @param linkedList La estructura de datos LinkedList que se utilizará para la medición del rendimiento.
     */
    public MedicionBuscarLinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * Sobrescribe el método abstracto ejecutar en la clase Medible.
     * Este método realiza una operación de búsqueda en la LinkedList para un número dado de repeticiones y palabras.
     * @param params Parámetro varargs que toma el número de repeticiones como un Integer y las palabras a buscar como un array de String.
     */
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                linkedList.contains(palabra);
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