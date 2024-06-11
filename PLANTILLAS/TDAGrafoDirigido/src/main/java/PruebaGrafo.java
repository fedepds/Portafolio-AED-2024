
import java.util.Collection;
import java.util.Iterator;

public class PruebaGrafo {

    public static void main(String[] args) {

        //Grafo dirigido

        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/aeropuertos.txt", "src/main/java/conexiones.txt",
                false, TGrafoDirigido.class);


        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        Iterator<TVertice> iterador = recorrido_Asuncion.iterator();
        while (iterador.hasNext()) {
            TVertice vertice = iterador.next();
            System.out.printf(" " + vertice.getEtiqueta());
        }


        System.out.println(" ");
        System.out.println(" ");
        TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");
        caminos.imprimirCaminosConsola();

        //Grafo no dirigido

        TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/verticesBEA.txt", "src/main/java/aristasBEA.txt",
                false, TGrafoNoDirigido.class);
        System.out.println("Grafo cargado en memoria");

        System.out.println("Busqueda en amplitud: Sin vertice especificado");
        Iterator<TVertice> it = grafo.bea().iterator();
        while (it.hasNext()) {
            TVertice v = it.next();
            System.out.println(v.getEtiqueta());

        }
    }
}

