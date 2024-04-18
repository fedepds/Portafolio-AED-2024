public class Ejercicio_1 {
    public static void main(String[] args) {
        String s = "1";
        while (s != "1000") {
            s += "0"; }

    }

}
/*El código proporcionado es un bucle infinito porque la condición de salida del bucle while nunca se cumple.
 En Java, cuando se comparan dos objetos String con != o ==, se está comparando si son exactamente el mismo objeto,
 no si tienen el mismo contenido. En este caso, s es un nuevo objeto String en cada iteración del bucle,
 por lo que nunca será el mismo objeto que el literal "1000".
 Para comparar el contenido de dos objetos String en Java, debes usar el método .equals().

 */