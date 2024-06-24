package aed;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TClasificador clasificador = new TClasificador();
        Random random = new Random();
        int[] numeros = new int[10000];
        for (int i = 0; i < 10000; i++) {
            numeros[i] = random.nextInt(10000);
        }
        int[] resultado = clasificador.clasificar(numeros, TClasificador.METODO_CLASIFICACION_QUICKSORT, new TPivote1());
        for (int num : resultado) {
            System.out.println(num);
        }

        numeros = new int[300];
        for (int i = 0; i < 300; i++) {
            numeros[i] = random.nextInt(300);
        }
        resultado = clasificador.clasificar(numeros, TClasificador.METODO_CLASIFICACION_QUICKSORT, new TPivote1());
        for (int num : resultado) {
            System.out.println(num);
        }

        numeros = new int[10000];
        for (int i = 0; i < 10000; i++) {
            numeros[i] = i;
        }
        resultado = clasificador.clasificar(numeros, TClasificador.METODO_CLASIFICACION_QUICKSORT, new TPivote2());
        for (int num : resultado) {
            System.out.println(num);
        }

        numeros = new int[300];
        for (int i = 0; i < 300; i++) {
            numeros[i] = i;
        }
        resultado = clasificador.clasificar(numeros, TClasificador.METODO_CLASIFICACION_QUICKSORT, new TPivote2());
        for (int num : resultado) {
            System.out.println(num);
        }

        numeros = new int[300];
        for (int i = 300; i > 0; i--) {
            numeros[i-1] = i;
        }
        resultado = clasificador.clasificar(numeros, TClasificador.METODO_CLASIFICACION_QUICKSORT, new TPivote2());
        for (int num : resultado) {
            System.out.println(num);
        }

        
    }
}
