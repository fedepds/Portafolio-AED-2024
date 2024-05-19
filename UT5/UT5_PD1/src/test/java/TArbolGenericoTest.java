import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class TArbolGenericoTest {
    private TNodoArbolGenerico<String> nodo;

    @BeforeEach
    void setUp() {
        nodo = new TNodoArbolGenerico<>("raiz");
        nodo.setHijo(new TNodoArbolGenerico<>("hijo1"));
        nodo.getHijo().setHermano(new TNodoArbolGenerico<>("hijo2"));
    }

    //Tests para buscar
    @Test
    void buscar_DevuelveNodoMismo_CuandoEtiquetaCoincide() {
        assertEquals(nodo, nodo.buscar("raiz"));
    }

    @Test
    void buscar_DevuelveHijo_CuandoEtiquetaHijoCoincide() {
        assertEquals(nodo.getHijo(), nodo.buscar("hijo1"));
    }

    @Test
    void buscar_DevuelveHermano_CuandoEtiquetaHermanoCoincide() {
        assertEquals(nodo.getHijo().getHermano(), nodo.buscar("hijo2"));
    }

    @Test
    void buscar_DevuelveNulo_CuandoEtiquetaNoCoincide() {
        assertNull(nodo.buscar("hijoNoExistente"));
    }
}