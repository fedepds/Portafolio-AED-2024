
import java.util.*;

public class PruebaGrafo {

    public static void main(String[] args) {

        // Crear los vértices
        TVertice vertice1 = new TVertice("1");
        TVertice vertice2 = new TVertice("2");
        TVertice vertice3 = new TVertice("3");

        // Crear las aristas
        TArista arista1 = new TArista("1", "2", 1);
        TArista arista2 = new TArista("2", "3", 1);
        TArista arista3 = new TArista("3", "1", 1);

        // Crear las colecciones de vértices y aristas
        Collection<TVertice> verticesCiclicas = new ArrayList<>();
        verticesCiclicas.add(vertice1);
        verticesCiclicas.add(vertice2);
        verticesCiclicas.add(vertice3);

        Collection<TArista> aristasCiclicas = new ArrayList<>();
        aristasCiclicas.add(arista1);
        aristasCiclicas.add(arista2);
        aristasCiclicas.add(arista3);

        // Crear el grafo
        TGrafoDirigido grafoCiclicas = new TGrafoDirigido(verticesCiclicas, aristasCiclicas);
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

        //EJERCICIO 1
        // Verificar si el grafo tiene ciclos
        boolean tieneCiclos = grafo.tieneCiclos();
        boolean tieneCiclos2 = grafoCiclicas.tieneCiclos();
        System.out.println("El grafo tiene ciclos: " + tieneCiclos);
        System.out.println("El grafo tiene ciclos: " + tieneCiclos2);
        System.out.println();
        System.out.println();
        System.out.println();




        //EJERCICIO 2



        // Realizar la ordenación topológica
        Stack<TVertice> ordenTopologico = grafo.ordenacionTopologica();

        // Imprimir la ordenación topológica
        while (!ordenTopologico.isEmpty()) {
            System.out.println(ordenTopologico.pop().getEtiqueta());
        }
        // Obtener todas las ordenaciones topológicas
        List<List<TVertice>> todasLasOrdenaciones = grafo.todasLasOrdenacionesTopologicas();

        // Imprimir todas las ordenaciones topológicas
        for (List<TVertice> ordenacion : todasLasOrdenaciones) {
            for (TVertice vertice : ordenacion) {
                System.out.print(vertice.getEtiqueta() + " ");
            }
            System.out.println();
        }


    }
}

