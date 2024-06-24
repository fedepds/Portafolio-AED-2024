
import java.util.*;

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
        System.out.println(gd.centroDelGrafo());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");
        caminos.imprimirCaminosConsola();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");


        // Crear los vértices
        TVertice v1 = new TVertice("1");
        TVertice v2 = new TVertice("2");
        TVertice v3 = new TVertice("3");
        TVertice v4 = new TVertice("4");
        TVertice v5 = new TVertice("5");

        // Crear las aristas
        TArista a12 = new TArista("1", "2", 1);
        TArista a13 = new TArista("1", "3", 1);
        TArista a24 = new TArista("2", "4", 1);
        TArista a35 = new TArista("3", "5", 1);
        TArista a45 = new TArista("4", "5", 1);

        // Crear listas de vértices y aristas
        List<TVertice> vertices = Arrays.asList(v1, v2, v3, v4, v5);
        List<TArista> aristas = Arrays.asList(a12, a13, a24, a35, a45);

        // Crear el grafo dirigido
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        // Realizar la ordenación topológica
        Stack<TVertice> ordenTopologico = grafo.ordenacionTopologica();

        // Imprimir la ordenación topológica
        while (!ordenTopologico.isEmpty()) {
            System.out.println(ordenTopologico.pop().getEtiqueta());
        }

        //Grafo no dirigido

        TGrafoNoDirigido grafoNoDirigido = UtilGrafos.cargarGrafo("src/main/java/verticesBEA.txt", "src/main/java/aristasBEA.txt",
                false, TGrafoNoDirigido.class);
        System.out.println("Grafo cargado en memoria");

        System.out.println("Busqueda en amplitud: Sin vertice especificado");
        Iterator<TVertice> it = grafoNoDirigido.bea().iterator();
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

