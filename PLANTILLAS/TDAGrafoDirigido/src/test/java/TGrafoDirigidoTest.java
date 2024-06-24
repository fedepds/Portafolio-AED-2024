import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TGrafoDirigidoTest {

    TGrafoDirigido grafo = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/aeropuertos.txt", "src/main/java/conexiones.txt",
            false, TGrafoDirigido.class);
    Comparable aux;

    @BeforeEach
    void setUp() {


    }

    @Test
    void centroDelGrafo() {
        // Llama al método centroDelGrafo
        Comparable centro = grafo.centroDelGrafo();

        // Verifica si el centro es el esperado
        // Reemplaza "EtiquetaCentro" con la etiqueta del vértice que esperas que sea el centro
        assertEquals("Montevideo", centro);
    }

    @Test
    void floyd() {
    }

    @Test
    void testFloyd() {
    }

    @Test
    void obtenerExcentricidad() {
    }

    @Test
    void warshall() {
    }

    @Test
    void bpf() {
    }

    @Test
    void testBpf() {
    }

    @Test
    void testBpf1() {
    }

    @Test
    void todosLosCaminos() {
    }

    @Test
    void ordenacionTopologica() {
    }

    @Test
    void todasLasOrdenacionesTopologicas() {
    }

    @Test
    void tieneCiclos() {
    }
}