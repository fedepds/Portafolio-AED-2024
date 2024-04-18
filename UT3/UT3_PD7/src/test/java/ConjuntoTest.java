import static org.junit.jupiter.api.Assertions.*;

class ConjuntoTest {

    @org.junit.jupiter.api.Test
    void unionWithNonEmptySets() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        conjunto1.insertar(1, 1);
        conjunto1.insertar(2, 2);

        Conjunto<Integer> conjunto2 = new Conjunto<>();
        conjunto2.insertar(2, 2);
        conjunto2.insertar(3, 3);

        IConjunto<Integer> union = conjunto1.union(conjunto2);

        assertEquals(3, union.cantElementos());
        assertNotNull(union.buscar(1));
        assertNotNull(union.buscar(2));
        assertNotNull(union.buscar(3));
    }

    @org.junit.jupiter.api.Test
    void unionWithEmptySet() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        conjunto1.insertar(1, 1);
        conjunto1.insertar(2, 2);

        Conjunto<Integer> conjunto2 = new Conjunto<>();

        IConjunto<Integer> union = conjunto1.union(conjunto2);

        assertEquals(2, union.cantElementos());
        assertNotNull(union.buscar(1));
        assertNotNull(union.buscar(2));
    }

    @org.junit.jupiter.api.Test
    void unionWithBothSetsEmpty() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();

        IConjunto<Integer> union = conjunto1.union(conjunto2);

        assertEquals(0, union.cantElementos());
    }

    @org.junit.jupiter.api.Test
    void interseccionWithNonEmptySets() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        conjunto1.insertar(1, 1);
        conjunto1.insertar(2, 2);

        Conjunto<Integer> conjunto2 = new Conjunto<>();
        conjunto2.insertar(2, 2);
        conjunto2.insertar(3, 3);

        IConjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);

        assertEquals(1, interseccion.cantElementos());
        assertNotNull(interseccion.buscar(2));
    }

    @org.junit.jupiter.api.Test
    void interseccionWithEmptySet() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        conjunto1.insertar(1, 1);
        conjunto1.insertar(2, 2);

        Conjunto<Integer> conjunto2 = new Conjunto<>();

        IConjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);

        assertEquals(0, interseccion.cantElementos());
    }

    @org.junit.jupiter.api.Test
    void interseccionWithBothSetsEmpty() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        Conjunto<Integer> conjunto2 = new Conjunto<>();

        IConjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);

        assertEquals(0, interseccion.cantElementos());
    }

    @org.junit.jupiter.api.Test
    void interseccionWithNoCommonElements() {
        Conjunto<Integer> conjunto1 = new Conjunto<>();
        conjunto1.insertar(1, 1);
        conjunto1.insertar(2, 2);

        Conjunto<Integer> conjunto2 = new Conjunto<>();
        conjunto2.insertar(3, 3);
        conjunto2.insertar(4, 4);

        IConjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);

        assertEquals(0, interseccion.cantElementos());
    }


}