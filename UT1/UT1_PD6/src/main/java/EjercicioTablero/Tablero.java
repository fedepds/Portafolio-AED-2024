package EjercicioTablero;

import java.util.Scanner;

public class Tablero {
    int ancho;
    int alto;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    public static void imprimirTablero(int ancho, int alto) {
        String tablero = "";
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                tablero += "#";
            }
            tablero += "\n";
        }
        System.out.println(tablero);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ancho del tablero:");
        int ancho = scanner.nextInt();
        System.out.println("Ingrese el alto del tablero:");
        int alto = scanner.nextInt();
        Tablero tablero = new Tablero(ancho, alto);
        tablero.imprimirTablero(ancho, alto);
    }
}