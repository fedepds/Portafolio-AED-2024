import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TVerticeTest {

    @Test
    void todosLosCaminos_withNoPaths() {
        TVertice vertice = new TVertice("A");
        TCamino caminoPrevio = new TCamino(vertice);
        TCaminos todosLosCaminos = new TCaminos();
        TCaminos result = vertice.todosLosCaminos("B", caminoPrevio, todosLosCaminos);
        assertTrue(result.getCaminos().isEmpty());
    }

    @Test
    void todosLosCaminos_withOnePath() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        TCamino caminoPrevio = new TCamino(verticeA);
        TCaminos todosLosCaminos = new TCaminos();
        TCaminos result = verticeA.todosLosCaminos("B", caminoPrevio, todosLosCaminos);
        assertEquals(1, result.getCaminos().size());
    }

    @Test
    void todosLosCaminos_withMultiplePaths() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeA.insertarAdyacencia(1.0, verticeC);
        verticeB.insertarAdyacencia(1.0, verticeC);
        TCamino caminoPrevio = new TCamino(verticeA);
        TCaminos todosLosCaminos = new TCaminos();
        TCaminos result = verticeA.todosLosCaminos("C", caminoPrevio, todosLosCaminos);
        assertEquals(2, result.getCaminos().size());
    }
    @Test
    void bea_withNoAdjacentVertices() {
        TVertice vertice = new TVertice("A");
        Collection<TVertice> visitados = new ArrayList<>();
        vertice.bea(visitados);
        assertEquals(1, visitados.size());
        assertTrue(visitados.contains(vertice));
    }

    @Test
    void bea_withOneAdjacentVertex() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        Collection<TVertice> visitados = new ArrayList<>();
        verticeA.bea(visitados);
        assertEquals(2, visitados.size());
        assertTrue(visitados.contains(verticeA));
        assertTrue(visitados.contains(verticeB));
    }

    @Test
    void bea_withMultipleAdjacentVertices() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeA.insertarAdyacencia(1.0, verticeC);
        Collection<TVertice> visitados = new ArrayList<>();
        verticeA.bea(visitados);
        assertEquals(3, visitados.size());
        assertTrue(visitados.contains(verticeA));
        assertTrue(visitados.contains(verticeB));
        assertTrue(visitados.contains(verticeC));
    }
    @Test
    void numBacon_withNoAdjacentVertices() {
        TVertice vertice = new TVertice("A");
        vertice.numBacon();
        assertEquals(0, vertice.getBacon());
    }

    @Test
    void numBacon_withOneAdjacentVertex() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeA.numBacon();
        assertEquals(0, verticeA.getBacon());
        assertEquals(1, verticeB.getBacon());
    }

    @Test
    void numBacon_withMultipleAdjacentVertices() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeB.insertarAdyacencia(1.0, verticeC);
        verticeA.numBacon();
        assertEquals(0, verticeA.getBacon());
        assertEquals(1, verticeB.getBacon());
        assertEquals(2, verticeC.getBacon());
    }
    @Test
    void ordenacionTopologicaDFS_withNoAdjacentVertices() {
        TVertice vertice = new TVertice("A");

        Stack<TVertice> pila = new Stack<>();
        vertice.ordenacionTopologicaDFS( pila);
        assertEquals(1, pila.size());
        assertTrue(pila.contains(vertice));
    }

    @Test
    void ordenacionTopologicaDFS_withOneAdjacentVertex() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);

        Stack<TVertice> pila = new Stack<>();
        verticeA.ordenacionTopologicaDFS( pila);
        assertEquals(2, pila.size());
        assertTrue(pila.contains(verticeA));
        assertTrue(pila.contains(verticeB));
    }

    @Test
    void ordenacionTopologicaDFS_withMultipleAdjacentVertices() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeB.insertarAdyacencia(1.0, verticeC);

        Stack<TVertice> pila = new Stack<>();
        verticeA.ordenacionTopologicaDFS(pila);
        assertEquals(3, pila.size());
        assertTrue(pila.contains(verticeA));
        assertTrue(pila.contains(verticeB));
        assertTrue(pila.contains(verticeC));
    }
    @Test
    void dfsCiclo_withNoCycle() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        Map<Comparable, Boolean> visitados = new HashMap<>();
        Map<Comparable, Boolean> enPila = new HashMap<>();
        Map<Comparable, TVertice> vertices = new HashMap<>();
        vertices.put(verticeA.getEtiqueta(), verticeA);
        vertices.put(verticeB.getEtiqueta(), verticeB);
        assertFalse(verticeA.dfsCiclo(enPila, vertices));
    }

    @Test
    void dfsCiclo_withCycle() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeB.insertarAdyacencia(1.0, verticeA);
        Map<Comparable, Boolean> enPila = new HashMap<>();
        Map<Comparable, TVertice> vertices = new HashMap<>();
        vertices.put(verticeA.getEtiqueta(), verticeA);
        vertices.put(verticeB.getEtiqueta(), verticeB);
        assertTrue(verticeA.dfsCiclo(enPila, vertices));
    }

    @Test
    void ordenacionTopologicaDFS_Lista_withNoAdjacentVertices() {
        TVertice vertice = new TVertice("A");
        LinkedList<TVertice> lista = new LinkedList<>();
        vertice.ordenacionTopologicaDFS_Lista(lista);
        assertEquals(1, lista.size());
        assertTrue(lista.contains(vertice));
    }

    @Test
    void ordenacionTopologicaDFS_Lista_withOneAdjacentVertex() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        LinkedList<TVertice> lista = new LinkedList<>();
        verticeA.ordenacionTopologicaDFS_Lista(lista);
        assertEquals(2, lista.size());
        assertTrue(lista.contains(verticeA));
        assertTrue(lista.contains(verticeB));
    }

    @Test
    void ordenacionTopologicaDFS_Lista_withMultipleAdjacentVertices() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeB.insertarAdyacencia(1.0, verticeC);
        LinkedList<TVertice> lista = new LinkedList<>();
        verticeA.ordenacionTopologicaDFS_Lista(lista);
        assertEquals(3, lista.size());
        assertTrue(lista.contains(verticeA));
        assertTrue(lista.contains(verticeB));
        assertTrue(lista.contains(verticeC));
    }
    @Test
    void conectadoCon_withNoAdjacentVertices() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        assertFalse(verticeA.conectadoCon(verticeB));
    }

    @Test
    void conectadoCon_withOneAdjacentVertex() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        verticeA.insertarAdyacencia(1.0, verticeB);
        assertTrue(verticeA.conectadoCon(verticeB));
    }

    @Test
    void conectadoCon_withMultipleAdjacentVertices() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeB.insertarAdyacencia(1.0, verticeC);
        assertTrue(verticeA.conectadoCon(verticeC));
    }

    @Test
    void conectadoCon_withNonAdjacentVertex() {
        TVertice verticeA = new TVertice("A");
        TVertice verticeB = new TVertice("B");
        TVertice verticeC = new TVertice("C");
        verticeA.insertarAdyacencia(1.0, verticeB);
        assertFalse(verticeA.conectadoCon(verticeC));
    }



}