package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.parcial2.TGrafoDeLaRed;
import uy.edu.ucu.aed.parcial2.TVerticeDeLaRed;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for implemented methods.
 */
public class Parcial2Test_Junit5
{
    String instanceVariable;

    @BeforeEach
    public void setUp() {
        // Initialize any resources or objects needed for the tests
        instanceVariable = "Value before test";
    }

    @AfterEach
    public void tearDown() {
        // Release any resources or clean up after the tests
        instanceVariable = null;
    }

    /**
     * Sample test in JUnit 5
     */
    @Test
    public void shouldAnswerWithTrueInJUnit5Test()
    {
        assertTrue(instanceVariable != null);
    }
    /* @Test
   void caminosDesdeHasta_SinArcos() {
        Collection<TVerticeDeLaRed> vertices = new HashSet<>();
        vertices.add(new TVerticeDeLaRed("A_1","1"));
        vertices.add(new TVerticeDeLaRed("B_1","1"));
        Collection<IArista>aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "A", 1));
        TGrafoDeLaRed graph = new TGrafoDeLaRed(vertices, aristas);
        TCaminos result = graph.caminosDesdeHasta("A", "B");
        LinkedList<TVerticeDeLaRed> expected = null;
        assertEquals(expected, result.getCaminos());
    }*/
    @Test
    void caminosDesdeHasta_withMultiplePaths() {
        Set<TVerticeDeLaRed> vertices = new HashSet<>();
        vertices.add(new TVerticeDeLaRed("A_1","1"));
        vertices.add(new TVerticeDeLaRed("B_1","1"));
        vertices.add(new TVerticeDeLaRed("C_1","2"));
        Collection<IArista> aristas = new HashSet<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("C", "B", 1));
        aristas.add(new TArista("B", "A", 1));
        aristas.add(new TArista("C", "A", 1));
        aristas.add(new TArista("B", "C", 1));
        TGrafoDeLaRed graph = new TGrafoDeLaRed(vertices, aristas);
        TCaminos result = graph.caminosDesdeHasta("A", "B");
        assertEquals(1, result.getCaminos().size());
    }
}
