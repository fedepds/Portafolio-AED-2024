import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GeneradorDatosGenericosTest {

    @Test
    void generarDatosAscendentes_DeberiaRetornarArrayEnOrdenAscendente_CuandoRecibeTamanioPositivo() {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] result = gdg.generarDatosAscendentes(5);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, result);
    }

    @Test
    void generarDatosAscendentes_DeberiaRetornarArrayVacio_CuandoRecibeTamanioCero() {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] result = gdg.generarDatosAscendentes(0);
        assertArrayEquals(new int[]{}, result);
    }
    @Test
    void generarDatosDescendentes_DeberiaRetornarArrayVacio_CuandoRecibeTamanioCero() {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] result = gdg.generarDatosDescendentes(0);
        assertArrayEquals(new int[]{}, result);
    }
    @Test
    void generarDatosDescendentes_DeberiaRetornarArrayEnOrdenDescendente_CuandoRecibeTamanioPositivo() {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] result = gdg.generarDatosDescendentes(5);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result);
    }
    @Test
    void generarDatosAleatorios_DeberiaRetornarArrayConValoresUnicos_CuandoRecibeTamanioPositivo() {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] result = gdg.generarDatosAleatorios(5);
        assertTrue(verificarValoresUnicos(result));
    }
    private boolean verificarValoresUnicos(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
    @Test
    void generarDatosAleatorios_DeberiaRetornarArrayVacio_CuandoRecibeTamanioCero() {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] result = gdg.generarDatosAleatorios(0);
        assertArrayEquals(new int[]{}, result);
    }
}