import java.util.Iterator;
import java.util.LinkedList;

public class MedicionPredecirLinkedList extends Medible {
    private LinkedList linkedList;


    public MedicionPredecirLinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        for (int i = 0; i < repeticion; i++) {
            predecir(params[1].toString(), new LinkedList<String>());
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        Iterator<String> iterator= this.linkedList.iterator();

        while(iterator.hasNext()){
            String s = iterator.next();
            if (s.startsWith(prefijo)){
                palabras.add(s);
            }
        }
    }
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
}
