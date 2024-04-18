package Primo;

public class Primo {
    // Método para verificar si un número es primo
    public static boolean isPrime(long n) {
        boolean prime = true;
        // Comprobamos si el número es divisible por cualquier número hasta su raíz cuadrada
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        // Si el número es primo y mayor que 2, o si es 2, imprimimos todos los números pares hasta n y su suma
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            int aux = 0;
            int suma= 0;
            while (aux<=n){
                if (aux%2 == 0){
                    System.out.println(aux);
                    suma+=aux;
                }
                aux++;
            }
            System.out.println(suma);
            return true;
        } else {
            // Si el número no es primo, imprimimos todos los números impares hasta n y su suma
            int aux = 0;
            int suma= 0;
            while (aux<=n){
                if (aux%2 != 0){
                    System.out.println(aux);
                    suma+=aux;
                }
                aux++;
            }
            System.out.println(suma);
            return false;
        }

    }

    // Método principal para probar la función isPrime
    public static void main(String[] args) {
        System.out.println(isPrime(8));
    }

}