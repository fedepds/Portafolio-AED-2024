
import static java.lang.System.in;
import java.util.Collection;
import java.util.Iterator;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/aeropuertos.txt", "src/main/java/conexiones.txt",
                false, TGrafoDirigido.class);

        
        
       Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        Iterator<TVertice> iterador = recorrido_Asuncion.iterator();
        while(iterador.hasNext()){
            TVertice vertice = iterador.next();
            System.out.println(vertice.getEtiqueta());
        }

        
        
       TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");
        caminos.imprimirCaminosConsola();

    }
}
