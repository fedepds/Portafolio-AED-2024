import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TGrafoDirigidoTest {

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
}