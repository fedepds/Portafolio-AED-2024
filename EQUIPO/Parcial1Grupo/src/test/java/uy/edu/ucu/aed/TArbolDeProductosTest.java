package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TArbolDeProductosTest {
    TArbolDeProductos arbolProductos = new TArbolDeProductos();
    TArbolDeProductos arbolProductos2 = new TArbolDeProductos();
    Producto producto1 = new Producto(1, null);
    Producto producto2 = new Producto(2, null);
    Producto producto3 = new Producto(3, null);

    @AfterEach
    public void tearDown() {
        // Release any resources or clean up after the tests
        arbolProductos.vaciar();
    }

    @Test
    public void longIntMedEmptyTreeReturnsNegative() {
        assertTrue(arbolProductos.longIntMed() < 0);
    }

    @Test
    public void longIntMedReturnsPositiveNumber() {
        arbolProductos.insertar("1", producto1);
        arbolProductos.insertar("2", producto2);
        arbolProductos.insertar("3", producto3);

        assertTrue(arbolProductos.longIntMed() > 0);

        arbolProductos.vaciar();
        arbolProductos.insertar("3", producto3);
        arbolProductos.insertar("2", producto2);
        arbolProductos.insertar("1", producto1);

        assertTrue(arbolProductos.longIntMed() > 0);

        arbolProductos.vaciar();
        arbolProductos.insertar("2", producto2);
        arbolProductos.insertar("3", producto3);
        arbolProductos.insertar("1", producto1);

        assertTrue(arbolProductos.longIntMed() > 0);
    }

    @Test
    public void treeStaysTheSame() {
        arbolProductos.insertar("1", producto1);
        arbolProductos.insertar("2", producto2);
        arbolProductos.insertar("3", producto3);
        arbolProductos2 = arbolProductos;

        arbolProductos.longIntMed();

        assertEquals(arbolProductos2, arbolProductos);   
    }

    @Test
    public void treeReturnsExpectedResult(){
        arbolProductos.insertar("2", producto2);
        arbolProductos.insertar("1", producto1);
        arbolProductos.insertar("3", producto3);

        double expectedResult = 0.6666666666666666;

        assertEquals(expectedResult, arbolProductos.longIntMed());
    
        arbolProductos.vaciar();
        arbolProductos.insertar("1", producto1);
        arbolProductos.insertar("2", producto2);
        arbolProductos.insertar("3", producto3);

        double expectedResult2 = 1.0;
        
        assertEquals(expectedResult2, arbolProductos.longIntMed());
    }

    @Test
    public void oneElementTreeReturnsCero(){
        arbolProductos.insertar("1", producto1);
        
        double expectedResult = 0.0;

        assertEquals(expectedResult, arbolProductos.longIntMed());
    }
}
