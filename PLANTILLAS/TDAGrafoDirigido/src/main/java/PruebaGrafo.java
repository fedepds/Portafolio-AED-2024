
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

        // cargar grafo con actores y relaciones
        TGrafoNoDirigido grafo2 = UtilGrafos.cargarGrafo("src/actores.csv", "src/en_pelicula.csv", false,
                TGrafoNoDirigido.class);

        // invocar a numBacon como indica la letra y mostrar en consola el resultado
        System.out.println(grafo2.numBacon("John_Goodman"));
        System.out.println(grafo2.numBacon("Tom_Cruise"));
        System.out.println(grafo2.numBacon("Jason_Statham"));
        System.out.println(grafo2.numBacon("Lukas_Haas"));
        System.out.println(grafo2.numBacon("Djimon_Hounsou"));

        String[] bacon = { String.valueOf(grafo2.numBacon("John_Goodman")),
                String.valueOf(grafo2.numBacon("Tom_Cruise")),
                String.valueOf(grafo2.numBacon("Jason_Statham")),
                String.valueOf(grafo2.numBacon("Lukas_Haas")),
                String.valueOf(grafo2.numBacon("Djimon_Hounsou")) };

        ManejadorArchivosGenerico.escribirArchivo("SALIDA", bacon);
    }
}

