import java.util.Arrays;

public class THashComparaciones implements IHash {
    private int[] tabla;
    private int size;
    private static final double FACTOR_CARGA_INICIAL = 0.7;
    private int comparacionesInsercion;
    private int comparacionesBusquedaExitosa;
    private int comparacionesBusquedaSinExito;

    public THashComparaciones(int capacidadInicial) {
        tabla = new int[capacidadInicial];
        Arrays.fill(tabla, -1);  // -1 indica un espacio vacío
        size = 0;
        comparacionesInsercion = 0;
        comparacionesBusquedaExitosa = 0;
        comparacionesBusquedaSinExito = 0;
    }

    @Override
    public int buscar(int unaClave) {
        int indice = funcionHashing(unaClave);
        int comparaciones = 0;
        while (tabla[indice] != -1) {
            comparaciones++;
            if (tabla[indice] == unaClave) {
                comparacionesBusquedaExitosa += comparaciones;
                return indice;
            }
            indice = (indice + 1) % tabla.length;  // Siguiente índice
        }
        comparacionesBusquedaSinExito += comparaciones + 1; // +1 para contar la comparación con -1
        return -1;  // No se encontró la clave
    }

    @Override
    public int insertar(int unaClave) {
        if (size >= FACTOR_CARGA_INICIAL * tabla.length) {
            redimensionar();
        }
        int indice = funcionHashing(unaClave);
        int comparaciones = 0;
        while (tabla[indice] != -1) {
            comparaciones++;
            indice = (indice + 1) % tabla.length;  // Siguiente índice
        }
        tabla[indice] = unaClave;
        size++;
        comparacionesInsercion += comparaciones + 1; // +1 para la comparación que encontró el -1
        return indice;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % tabla.length;
    }

    private void redimensionar() {
        int[] tablaAntigua = tabla;
        tabla = new int[2 * tablaAntigua.length];
        Arrays.fill(tabla, -1);
        size = 0;
        for (int clave : tablaAntigua) {
            if (clave != -1) {
                insertar(clave);
            }
        }
    }

    public void resetComparaciones() {
        comparacionesInsercion = 0;
        comparacionesBusquedaExitosa = 0;
        comparacionesBusquedaSinExito = 0;
    }

    public int getComparacionesInsercion() {
        return comparacionesInsercion;
    }

    public int getComparacionesBusquedaExitosa() {
        return comparacionesBusquedaExitosa;
    }

    public int getComparacionesBusquedaSinExito() {
        return comparacionesBusquedaSinExito;
    }
}

