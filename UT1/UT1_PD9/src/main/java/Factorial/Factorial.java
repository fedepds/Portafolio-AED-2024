package Factorial;

public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("debe ser un numero mayor igual a 0");
        }

        if (n == 0) {
            return 1;
        }
        for (int i = n - 1; i > 0; i--) {
            n *= i;
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));

    }
}

