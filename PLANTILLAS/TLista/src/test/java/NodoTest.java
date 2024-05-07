import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodoTest {
    @Test
    void getDato() {
        Nodo<Integer> nodo = new Nodo<Integer>(1, 100);
        assertEquals(100, nodo.getDato());
    }

    @Test
    void getSiguiente() {
        Nodo<Integer> nodo1 = new Nodo<Integer>(1, 100);
        Nodo<Integer> nodo2 = new Nodo<Integer>(2, 200);
        nodo1.setSiguiente(nodo2);
        assertEquals(nodo2, nodo1.getSiguiente());
    }

    @Test
    void setSiguiente() {
        Nodo<Integer> nodo1 = new Nodo<Integer>(1, 100);
        Nodo<Integer> nodo2 = new Nodo<Integer>(2, 200);
        nodo1.setSiguiente(nodo2);
        assertEquals(nodo2, nodo1.getSiguiente());
    }

    @Test
    void imprimir() {
        Nodo<Integer> nodo = new Nodo<Integer>(1, 100);
        nodo.imprimir(); // Este método imprime en la consola, por lo que no se puede verificar con un assert
    }

    @Test
    void imprimirEtiqueta() {
        Nodo<Integer> nodo = new Nodo<Integer>(1, 100);
        nodo.imprimirEtiqueta(); // Este método imprime en la consola, por lo que no se puede verificar con un assert
    }

    @Test
    void getEtiqueta() {
        Nodo<Integer> nodo = new Nodo<Integer>(1, 100);
        assertEquals(1, nodo.getEtiqueta());
    }

    @Test
    void compareTo() {
        Nodo<Integer> nodo = new Nodo<Integer>(1, 100);
        assertEquals(0, nodo.compareTo(1));
        assertTrue(nodo.compareTo(0) > 0);
        assertTrue(nodo.compareTo(2) < 0);
    }
}