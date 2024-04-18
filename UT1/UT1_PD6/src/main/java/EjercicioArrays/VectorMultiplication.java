package EjercicioArrays;

public class VectorMultiplication {
    public static int[] multiplyVectors(int[] vector1, int[] vector2) {
        if (vector1.length != vector2.length) {
            System.out.println("Los vectores no se pueden multiplicar. Deben tener la misma longitud.");
            return null;
        }

        int[] result = new int[vector1.length];
        for (int i = 0; i < vector1.length; i++) {
            result[i] = vector1[i] * vector2[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] vector1 = {1, 8, 3};
        int[] vector2 = {4, 5, 6};

        int[] result = multiplyVectors(vector1, vector2);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }
}
/*Para que esta operación sea posible, ambos vectores deben tener la misma longitud.
Si los vectores no tienen la misma longitud, no es posible realizar una multiplicación elemento por elemento,
ya que no habría un correspondiente en el otro vector para algunos de los elementos.
 */