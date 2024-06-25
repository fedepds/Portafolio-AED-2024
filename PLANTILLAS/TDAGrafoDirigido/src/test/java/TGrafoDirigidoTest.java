import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;


class TGrafoDirigidoTest {
    // Test de ordenacionTopologica_lista
    @Test
    void ordenacionTopologica_lista_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        LinkedList<TVertice> result = graph.ordenacionTopologica_lista();
        assertTrue(result.isEmpty());
    }

    @Test
    void ordenacionTopologica_lista_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        LinkedList<TVertice> result = graph.ordenacionTopologica_lista();
        assertEquals(1, result.size());
        assertEquals("A", result.getFirst().getEtiqueta());
    }

    @Test
    void ordenacionTopologica_lista_withMultipleVertices() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        LinkedList<TVertice> result = graph.ordenacionTopologica_lista();
        assertEquals(3, result.size());
        // The exact order depends on the implementation of the DFS algorithm
    }

    @Test
    void ordenacionTopologica_lista_withCyclicGraph() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("C", "A", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        LinkedList<TVertice> result = graph.ordenacionTopologica_lista();
        // The result is undefined for cyclic graphs, so we cannot make any assertions about the result
    }

    //  Test de tieneCiclos
    @Test
    void tieneCiclos_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        assertFalse(graph.tieneCiclos());
    }

    @Test
    void tieneCiclos_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        assertFalse(graph.tieneCiclos());
    }

    @Test
    void tieneCiclos_withMultipleVerticesNoCycles() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        assertFalse(graph.tieneCiclos());
    }

    @Test
    void tieneCiclos_withMultipleVerticesWithCycles() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("C", "A", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        assertTrue(graph.tieneCiclos());
    }


    //Test de ordenacionTopologica

    @Test
    void ordenacionTopologica_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        Stack<TVertice> result = graph.ordenacionTopologica();
        assertTrue(result.isEmpty());
    }

    @Test
    void ordenacionTopologica_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Stack<TVertice> result = graph.ordenacionTopologica();
        assertEquals(1, result.size());
        assertEquals("A", result.pop().getEtiqueta());
    }


    //todos los caminos


    @Test
    void todosLosCaminos_withSinglePath() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        TCaminos result = graph.todosLosCaminos("A", "B");
        assertEquals(1, result.getCaminos().size());
    }

    @Test
    void todosLosCaminos_withMultiplePaths() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("C", "B", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        TCaminos result = graph.todosLosCaminos("A", "B");
        assertEquals(2, result.getCaminos().size());
    }


    //bpf

    @Test
    void bpf_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        Collection<TVertice> result = graph.bpf();
        assertTrue(result.isEmpty());
    }

    @Test
    void bpf_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Collection<TVertice> result = graph.bpf();
        assertEquals(1, result.size());
        assertEquals("A", result.iterator().next().getEtiqueta());
    }

    @Test
    void bpf_withMultipleVerticesNoCycles() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        Collection<TVertice> result = graph.bpf();
        assertEquals(3, result.size());
    }

    @Test
    void bpf_withMultipleVerticesWithCycles() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("C", "A", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        Collection<TVertice> result = graph.bpf();
        assertEquals(3, result.size());
    }

    //warshall
    @Test
    void warshall_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        boolean[][] result = graph.warshall();
        assertEquals(0, result.length);
    }

    @Test
    void warshall_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        boolean[][] result = graph.warshall();
        assertEquals(1, result.length);
        assertFalse(result[0][0]);
    }

    @Test
    void warshall_withMultipleVerticesNoEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        boolean[][] result = graph.warshall();
        assertEquals(2, result.length);
        assertFalse(result[0][0]);
        assertFalse(result[0][1]);
        assertFalse(result[1][0]);
        assertFalse(result[1][1]);
    }

    @Test
    void warshall_withMultipleVerticesWithEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        boolean[][] result = graph.warshall();
        assertEquals(2, result.length);
        assertFalse(result[0][0]);
        assertTrue(result[0][1]);
    }



    @Test
    void obtenerExcentricidad_withNonExistentVertex() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        Double result = graph.obtenerExcentricidad("A");
        assertNull(result);
    }





    @Test
    void obtenerExcentricidad_withMultipleVerticesWithEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        Double result = graph.obtenerExcentricidad("A");
        assertEquals(1.0, result);
    }
    @Test
    void centroDelGrafo_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        Comparable result = graph.centroDelGrafo();
        assertNull(result);
    }

    @Test
    void centroDelGrafo_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Comparable result = graph.centroDelGrafo();
        assertEquals("A", result);
    }
    @Test
    void floyd_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        Double[][] result = graph.floyd();
        assertEquals(0, result.length);
    }

    @Test
    void floyd_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Double[][] result = graph.floyd();
        assertEquals(1, result.length);
        assertEquals(0.0, result[0][0]);
    }

    @Test
    void floyd_withMultipleVerticesNoEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Double[][] result = graph.floyd();
        assertEquals(2, result.length);
        assertEquals(Double.MAX_VALUE, result[0][1]);
        assertEquals(Double.MAX_VALUE, result[1][0]);
    }

    @Test
    void floyd_withMultipleVerticesWithEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        Double[][] result = graph.floyd();
        assertEquals(2, result.length);
        assertEquals(1.0, result[0][1]);
    }

    @Test
    void floyd_predecesores_withEmptyGraph() {
        TGrafoDirigido graph = new TGrafoDirigido(new HashSet<>(), new HashSet<>());
        Double[][] result = graph.floyd_predecesores(null);
        assertEquals(0, result.length);
    }

    @Test
    void floyd_predecesores_withSingleVertex() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Double[][] result = graph.floyd_predecesores(null);
        assertEquals(1, result.length);
        assertEquals(0.0, result[0][0]);
    }

    @Test
    void floyd_predecesores_withMultipleVerticesNoEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, new HashSet<>());
        Double[][] result = graph.floyd_predecesores(null);
        assertEquals(2, result.length);
        assertEquals(Double.MAX_VALUE, result[0][1]);
        assertEquals(Double.MAX_VALUE, result[1][0]);
    }

    @Test
    void floyd_predecesores_withMultipleVerticesWithEdges() {
        Set<TVertice> vertices = new HashSet<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Set<TArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        TGrafoDirigido graph = new TGrafoDirigido(vertices, aristas);
        Double[][] result = graph.floyd_predecesores(null);
        assertEquals(2, result.length);
        assertEquals(1.0, result[0][1]);
    }

}



