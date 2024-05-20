import java.io.Serializable;

public abstract class Medible implements Serializable {

    public Medicion medir(Object... params){
        long init = System.nanoTime();
        ejecutar(params);
        long fin = System.nanoTime();
        return new Medicion(this.getClass().getSimpleName(),ObjectSizeFetcher.getObjectSize(getObjetoAMedirMemoria()), fin-init);
    }
    
    abstract public void ejecutar(Object... params);
    
    abstract public Object getObjetoAMedirMemoria();
    
}
