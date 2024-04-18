package Ejercicio_1_y_2;

public class ContadorLetras {
    public int contarPalabras(String frase) {
        int contador = 0;
        boolean esPalabra = false;
        int finDeLinea = frase.length() - 1;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i)) && i != finDeLinea) {
                esPalabra = true;
            } else if (frase.charAt(i) == ' ') {
                if (esPalabra) {
                    contador++;
                    esPalabra = false;
                }
            }
        }
        if (esPalabra) {
            contador++;
        }

        return contador;
    }

    public void imprimirPalabrasLargas(String frase) {
        boolean esPalabra = false;
        String palabra = "";
        int cantidadDeLetras = 0;

        for (int i = 0; i < frase.length(); i++) {
            char caracterActual = frase.charAt(i);
            if (Character.isLetter(caracterActual)) {
                esPalabra = true;
                palabra += caracterActual;
                cantidadDeLetras++;
            } else if (caracterActual == ' ') {
                if (esPalabra && cantidadDeLetras > 3) {
                    System.out.println("La palabra '" + palabra + "' tiene " + cantidadDeLetras + " letras");
                }
                esPalabra = false;
                palabra = "";
                cantidadDeLetras = 0;
            }
        }
    }

    public static void main(String[] args) {
        String frase = "Si piensas que tu profesor es exigente ,... espera a conocer a tu jefe !";
        ContadorLetras contadorLetras = new ContadorLetras();

        int numeroPalabras = contadorLetras.contarPalabras(frase);
        System.out.println("El número de palabras en la frase es: " + numeroPalabras);

        contadorLetras.imprimirPalabrasLargas(frase);
    }
}