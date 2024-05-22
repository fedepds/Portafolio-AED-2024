import java.util.TreeMap;

public class MedicionBuscarTreeMap extends Medible {
    private TreeMap treeMap;

    public MedicionBuscarTreeMap(TreeMap treeMap) {
        this.treeMap = treeMap;
    }

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

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.treeMap;
    }
}
