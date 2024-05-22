import java.util.HashMap;
import java.util.LinkedList;

public class MedicionPredecirHashMap extends Medible{
    private HashMap hashMap;

    public MedicionPredecirHashMap(HashMap hashMap) {
         this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(Object... params) {

            int repeticion = (int) params[0];
            for (int i = 0; i < repeticion; i++) {
                predecir(params[1].toString(), new LinkedList<String>());
            }


    }
    public void predecir(String prefijo, LinkedList<String> palabras) {
        for (Object key : hashMap.keySet()) {
            String s = key.toString();
            if (s.startsWith(prefijo)){
                palabras.add(s);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return null;
    }
}
