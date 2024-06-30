public class Main {
    public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] datos = gdg.generarDatosAleatorios(10);
        System.out.println("Datos aleatorios: ");
        System.out.println("Datos generados: ");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
        System.out.println("Datos ordenados: ");
        int[] datosOrdenados = clasificador.ordenarPorInsercion(datos);
        for (int i = 0; i < datosOrdenados.length; i++) {
            System.out.print(datosOrdenados[i] + " ");
        }
        System.out.println();
        System.out.println("¿Está ordenado? " + clasificador.estaOrdenado(datosOrdenados, true));



        TClasificador clasificador2 = new TClasificador();
        GeneradorDatosGenericos gdg2 = new GeneradorDatosGenericos();

        // Datos aleatorios;


        // Datos ascendentes
        int[] datosAscendentes = gdg2.generarDatosAscendentes(10);


        // Datos descendentes
        int[] datosDescendentes = gdg2.generarDatosDescendentes(10);


        System.out.println();
        System.out.println("Datos  ascendentes: ");
        for (int i = 0; i < datosAscendentes.length; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
        System.out.println("Datos ordenados: ");
        int[] datosOrdenados2 = clasificador2.ordenarPorInsercion(datos);
        for (int i = 0; i < datosOrdenados2.length; i++) {
            System.out.print(datosOrdenados2[i] + " ");
        }
        System.out.println();
        System.out.println("¿Está ordenado? " + clasificador2.estaOrdenado(datosOrdenados, true));
        System.out.println();

        System.out.println("Datos  descendentes: ");
        for (int i = 0; i < datosAscendentes.length; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
        System.out.println("Datos ordenados: ");
        int[] datosOrdenados3 = clasificador2.ordenarPorInsercion(datos);
        for (int i = 0; i < datosOrdenados3.length; i++) {
            System.out.print(datosOrdenados3[i] + " ");
        }
        System.out.println();
        System.out.println("¿Está ordenado? " + clasificador2.estaOrdenado(datosOrdenados, true));
        System.out.println();

        // Datos ascendentes
        int[] datosAscendentes2 = gdg2.generarDatosAscendentes(10);

// Datos descendentes
        int[] datosDescendentes2 = gdg2.generarDatosDescendentes(10);

        System.out.println();
        System.out.println("Datos  ascendentes: ");
        for (int i = 0; i < datosAscendentes.length; i++) {
            System.out.print(datosAscendentes[i] + " ");
        }
        System.out.println();
        System.out.println("Datos ordenados: ");
        int[] datosOrdenados5 = clasificador2.ordenarPorShell(datosAscendentes2);
        for (int i = 0; i < datosOrdenados5.length; i++) {
            System.out.print(datosOrdenados5[i] + " ");
        }
        System.out.println();
        System.out.println("¿Está ordenado? " + clasificador2.estaOrdenado(datosOrdenados5, true));
        System.out.println();

        System.out.println("Datos  descendentes: ");
        for (int i = 0; i < datosDescendentes.length; i++) {
            System.out.print(datosDescendentes[i] + " ");
        }
        System.out.println();
        System.out.println("Datos ordenados: ");
        int[] datosOrdenados4 = clasificador2.ordenarPorShell(datosDescendentes2);
        for (int i = 0; i < datosOrdenados4.length; i++) {
            System.out.print(datosOrdenados4[i] + " ");
        }
        System.out.println();
        System.out.println("¿Está ordenado? " + clasificador2.estaOrdenado(datosOrdenados4, true));
        System.out.println();
    }
}
