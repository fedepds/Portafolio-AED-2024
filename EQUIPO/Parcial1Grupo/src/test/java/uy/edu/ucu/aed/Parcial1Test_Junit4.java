package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for implemented methods.
 */
public class Parcial1Test_Junit4 
{
    String instanceVariable;

    @Before
    public void setUp() {
        // Initialize any resources or objects needed for the tests
        instanceVariable = "Value before test";
    }

    @After
    public void tearDown() {
        // Release any resources or clean up after the tests
        instanceVariable = null;
    }

    /**
     * Sample test in JUnit 4
     */
    @Test
    public void shouldAnswerWithTrueInJUnit4Test()
    {
        assertTrue(instanceVariable != null);
    }
}
