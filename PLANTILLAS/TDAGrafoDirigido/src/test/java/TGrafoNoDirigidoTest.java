import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class TGrafoNoDirigidoTest {

    @Test
    void Prim_sinAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, new ArrayList<>());
        TGrafoNoDirigido result = grafo.Prim();
        assertNull(result);
    }

    @Test
    void Prim_conUnaArista() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido result = grafo.Prim();
        assertEquals(2, result.getVertices().size());
        assertEquals(2, result.getLasAristas().size());
    }

    @Test
    void Prim_conMultiplesAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        aristas.add(new TArista("B", "C", 2.0));
        aristas.add(new TArista("A", "C", 3.0));
        aristas.add(new TArista("B", "A", 4.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido result = grafo.Prim();
        assertEquals(3, result.getVertices().size());
        assertEquals(4, result.getLasAristas().size());
    }

    @Test
    void Kruskal_sinAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, new ArrayList<>());
        TGrafoNoDirigido result = grafo.Kruskal();
        assertNull(result);
    }

    @Test
    void Kruskal_conUnaArista() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido result = grafo.Kruskal();
        assertEquals(2, result.getVertices().size());
        assertEquals(2, result.getLasAristas().size());
    }

    @Test
    void Kruskal_conMultiplesAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        aristas.add(new TArista("B", "C", 2.0));
        aristas.add(new TArista("A", "C", 3.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido result = grafo.Kruskal();
        assertEquals(3, result.getVertices().size());


    }

    @Test
    void Kruskal2_sinAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, new ArrayList<>());
        assertThrows(IllegalStateException.class, grafo::Kruskal2);
    }

    @Test
    void Kruskal2_conUnaArista() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido result = grafo.Kruskal2();
        assertEquals(2, result.getVertices().size());
        assertEquals(2, result.getLasAristas().size());
    }

    @Test
    void Kruskal2_conMultiplesAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        aristas.add(new TArista("B", "C", 2.0));
        aristas.add(new TArista("A", "C", 3.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido result = grafo.Kruskal2();
        assertEquals(3, result.getVertices().size());
        assertEquals(4, result.getLasAristas().size());
    }

    @Test
    void bea_sinAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, new ArrayList<>());
        Collection<TVertice> result = grafo.bea("A");
        assertEquals(2, result.size());
    }

    @Test
    void bea_conUnaArista() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        Collection<TVertice> result = grafo.bea("A");
        assertEquals(2, result.size());
    }

    @Test
    void bea_conMultiplesAristas() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        aristas.add(new TArista("B", "C", 2.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        Collection<TVertice> result = grafo.bea("A");
        assertEquals(3, result.size());
    }

    @Test
    void bea_withDisconnectedVertices() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        Collection<TVertice> result = grafo.bea("A");
        assertEquals(3, result.size());
    }

    @Test
    void numBacon_withActorNotInGraph() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("Kevin_Bacon"));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, new ArrayList<>());
        int result = grafo.numBacon("NonExistentActor");
        assertEquals(-1, result);
    }

    @Test
    void numBacon_withActorIsKevinBacon() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("Kevin_Bacon"));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, new ArrayList<>());
        int result = grafo.numBacon("Kevin_Bacon");
        assertEquals(0, result);
    }

    @Test
    void numBacon_withOneDegreeSeparation() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("Kevin_Bacon"));
        vertices.add(new TVertice("Actor1"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("Kevin_Bacon", "Actor1", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        int result = grafo.numBacon("Actor1");
        assertEquals(1, result);
    }

    @Test
    void numBacon_withMultipleDegreesSeparation() {
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("Kevin_Bacon"));
        vertices.add(new TVertice("Actor1"));
        vertices.add(new TVertice("Actor2"));
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("Kevin_Bacon", "Actor1", 1.0));
        aristas.add(new TArista("Actor1", "Actor2", 1.0));
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        int result = grafo.numBacon("Actor2");
        assertEquals(2, result);
    }
}