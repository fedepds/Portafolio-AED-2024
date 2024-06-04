import java.util.Arrays;
import java.util.Random;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        int capacidadInicial = 100;
        THashComparaciones tablaHash = new THashComparaciones(capacidadInicial);
        Random random = new Random();
        int[] claves = new int[capacidadInicial];

        for (int i = 0; i < capacidadInicial; i++) {
            claves[i] = random.nextInt(10000);
            tablaHash.insertar(claves[i]);
        }

        double[] factoresCarga = {0.70, 0.75, 0.80, 0.85, 0.90};
        for (int i = 91; i <= 99; i++) {
            factoresCarga = Arrays.copyOf(factoresCarga, factoresCarga.length + 1);
            factoresCarga[factoresCarga.length - 1] = i / 100.0;
        }

        System.out.println("Factor de carga\tComparaciones Insercion\tComparaciones Busqueda Exitosa\tComparaciones Busqueda Sin Exito");

        for (double factor : factoresCarga) {
            int cantidadClaves = (int) (factor * capacidadInicial);
            tablaHash = new THashComparaciones(capacidadInicial);
            tablaHash.resetComparaciones();

            for (int i = 0; i < cantidadClaves; i++) {
                tablaHash.insertar(claves[i]);
            }

            int totalComparacionesInsercion = tablaHash.getComparacionesInsercion();
            int totalComparacionesBusquedaExitosa = 0;
            int totalComparacionesBusquedaSinExito = 0;

            for (int i = 0; i < cantidadClaves; i++) {
                tablaHash.buscar(claves[i]);
            }
            totalComparacionesBusquedaExitosa = tablaHash.getComparacionesBusquedaExitosa();

            for (int i = cantidadClaves; i < capacidadInicial; i++) {
                tablaHash.buscar(claves[i]);
            }
            totalComparacionesBusquedaSinExito = tablaHash.getComparacionesBusquedaSinExito();

            int promedioComparacionesInsercion = totalComparacionesInsercion / cantidadClaves;
            int promedioComparacionesBusquedaExitosa = totalComparacionesBusquedaExitosa / cantidadClaves;
            int promedioComparacionesBusquedaSinExito = totalComparacionesBusquedaSinExito / (capacidadInicial - cantidadClaves);

            System.out.println(factor + "\t" + promedioComparacionesInsercion + "\t" + promedioComparacionesBusquedaExitosa + "\t" + promedioComparacionesBusquedaSinExito);
        }
    }
}
