package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for implemented methods.
 */
public class Parcial1Test_Junit5
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

    @Test
    public void longitudTrayectoriaInternaAuxReturnsZeroForNullNode() {
        TArbolDeProductos tree = new TArbolDeProductos();
        assertEquals(0, tree.longitudTrayectoriaInternaAux(null, 0));
    }

    @Test
    public void longitudTrayectoriaInternaAuxReturnsCorrectValueForSingleNode() {
        TArbolDeProductos tree = new TArbolDeProductos();
        TElementoAB<Producto> node = new TElementoAB<>("1", new Producto(1, "Product 1"));
        assertEquals(0, tree.longitudTrayectoriaInternaAux(node, 0));
    }

    @Test
    public void longitudTrayectoriaInternaAuxReturnsCorrectValueForNodeWithOneChild() {
        TArbolDeProductos tree = new TArbolDeProductos();
        TElementoAB<Producto> node = new TElementoAB<>("1", new Producto(1, "Product 1"));
        node.setHijoIzq(new TElementoAB<>("2", new Producto(2, "Product 2")));
        assertEquals(1, tree.longitudTrayectoriaInternaAux(node, 0));
    }




}
