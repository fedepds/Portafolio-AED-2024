package Ejercicio_1_y_2;

public class ContadorPalabra {




    public int cantidadPalabras(String frase) {
        int finDeLinea = frase.length() - 1;
        int contador = 0;
        boolean esPalabra = false;
        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i)) && i != finDeLinea) {
                esPalabra = true;
            } else if ((frase.charAt(i) == ' ') && esPalabra) {
                contador++;
                esPalabra = false;
            }
        }
        if (esPalabra) contador++;
        return contador;
    }
    public void agruparLetras(String frase) {
        String fraseMin =frase.toLowerCase();
        int cont = 0;
        int cont_cons = 0;
        for (int i = 0; i < fraseMin.length(); i++) {
            if (fraseMin.charAt(i) == 'a' || fraseMin.charAt(i) == 'e' || fraseMin.charAt(i) == 'i' || fraseMin.charAt(i) == 'o' || fraseMin.charAt(i) == 'u') {
                cont++;
            } else if (Character.isLetter(fraseMin.charAt(i))) {
                cont_cons ++;

            }
        }
        System.out.println("El número de vocales en la frase es: " + cont);


    }

}