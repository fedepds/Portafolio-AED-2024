import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaTest {
    @Test
    void insertar() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        assertEquals(1, lista.cantElementos());
    }

    @Test
    void testInsertar() {
        Lista lista = new Lista();
        lista.insertar(1, 100);
        assertEquals(1, lista.cantElementos());
    }

    @Test
    void buscar() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        Nodo nodo = lista.buscar(1);
        assertNotNull(nodo);
        assertEquals(100, nodo.getDato());
    }

    @Test
    void eliminar() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        boolean eliminado = lista.eliminar(1);
        assertTrue(eliminado);
        assertEquals(0, lista.cantElementos());
    }

    @Test
    void imprimir() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        lista.insertar(new Nodo<Integer>(2, 200));
        String resultado = lista.imprimir();
        assertEquals("1 2 ", resultado);
    }

    @Test
    void testImprimir() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        lista.insertar(new Nodo<Integer>(2, 200));
        String resultado = lista.imprimir(", ");
        assertEquals("1, 2, ", resultado);
    }

    @Test
    void cantElementos() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        lista.insertar(new Nodo<Integer>(2, 200));
        assertEquals(2, lista.cantElementos());
    }

    @Test
    void esVacia() {
        Lista lista = new Lista();
        assertTrue(lista.esVacia());
        lista.insertar(new Nodo<Integer>(1, 100));
        assertFalse(lista.esVacia());
    }

    @Test
    void setPrimero() {
        Lista lista = new Lista();
        Nodo<Integer> nodo = new Nodo<Integer>(1, 100);
        lista.setPrimero(nodo);
        assertEquals(nodo, lista.buscar(1));
    }

    @Test
    void listar() {
        Lista lista = new Lista();
        lista.insertar(new Nodo<Integer>(1, 100));
        lista.insertar(new Nodo<Integer>(2, 200));
        lista.listar(); // Este método imprime en la consola, por lo que no se puede verificar con un assert
    }
}