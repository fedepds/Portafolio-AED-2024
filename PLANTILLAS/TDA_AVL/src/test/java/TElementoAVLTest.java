import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TElementoAVLTest {
    private TElementoAVL<Integer> root;

    @BeforeEach
    void setUp() {
        root = new TElementoAVL<>(10, 10);
        root.insertar(new TElementoAVL<>(5, 5));
        root.insertar(new TElementoAVL<>(15, 15));
    }
    @Test
    void buscarReturnsCorrectNodeWhenNodeExists() {
        TElementoAVL<Integer> foundNode = root.buscar(5);
        assertNotNull(foundNode);
        assertEquals(5, foundNode.getEtiqueta());
    }


    @Test
    void buscar() {
    }

    @Test
    void insertar() {
    }
    @Test
    void insertarAddsElementInCorrectPosition() {
        TElementoAVL<Integer> newNode = new TElementoAVL<>(7, 7);
        root.insertar(newNode);
        assertEquals(newNode, root.buscar(7));
        assertEquals(newNode, root.getHijoIzq().getHijoDer());
    }
    @Test
    void insertarAddsElementWhenTreeIsNotEmpty() {
        TElementoAVL<Integer> newNode = new TElementoAVL<>(20, 20);
        root.insertar(newNode);
        assertEquals(newNode, root.buscar(20));
    }
    @Test
    void insertarDoesNotAddElementWhenElementAlreadyExists() {
        TElementoAVL<Integer> duplicateNode = new TElementoAVL<>(10, 10);
        TElementoAVL<Integer> result = root.insertar(duplicateNode);
        assertEquals(root, result);
    }


    @Test
    void eliminar() {
    }

    @Test
    void eliminarRemovesNodeWhenNodeExists() {
        TElementoAVL<Integer> removedNode = root.eliminar(5);
        assertNull(root.buscar(5));
        assertNotNull(removedNode);
    }
    @Test
    void eliminarReturnsNullWhenElementDoesNotExist() {
        TElementoAVL<Integer> removedNode = root.eliminar(100); // 100 is a value that does not exist in the tree
        assertNull(removedNode);
    }

    @Test
    void preOrden() {
    }

    @Test
    void inOrden() {
    }

    @Test
    void postOrden() {
    }

    @Test
    void obtenerAltura() {
        int altura = root.obtenerAltura();
        assertEquals(2, altura);

    }

    @Test
    void obtenerCantidadHojas() {
        int numeroHojas = root.obtenerCantidadHojas();
        assertEquals(2, numeroHojas);

    }

    @Test
    void obtenerTamanio() {
        int size = root.obtenerTamanio();
        assertEquals(3, size);
    }

    @Test
    void obtenerMenorClave() {
    }

    @Test
    void obtenerMayorClave() {
    }

    @Test
    void obtenerCantidadNodosNivel() {
    }

    @Test
    void listarHojasConNivel() {
    }

    @Test
    void listar() {

    }
}