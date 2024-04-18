public class Ejercicio {
    public static void main(String[] args) {
    int aNumber = 3;
    if (aNumber >= 0)
    if (aNumber == 0)
    System.out.println("first string");
    else System.out.println("second string");
    System.out.println("third string");
    }
}
/*a) ¿Qué salida cree que producirá el código si aNumber es 3?
La salida será "second string" y "third string"


b) Cree un programa de prueba que contenga el código anterior; haga que aNumber valga 3. ¿Cuál
es la salida del programa? ¿Es la que usted predijo? Explique por qué la salida es la que es, o, en
otras palabras, ¿cuál es el flujo de control del código provisto?

La salida del programa es "second string" y "third string", la razón es que el flujo de control del código es el siguiente:
1. Se evalúa la condición aNumber >= 0, como es verdadera se evalúa la siguiente condición.
2. Se evalúa la condición aNumber == 0, como es falsa se imprime "second string".
3. Se imprime "third string" sin importar el resultado de las condiciones anteriores.


c) Utilizando sólo espacios y saltos de línea, reformatee el código para hacer que el flujo de control
sea más fácil de entender.
    public static void main(String[] args) {
        int aNumber = 3;
        if (aNumber >= 0)
            if (aNumber == 0)
                System.out.println("first string");
            else System.out.println("second string");
        System.out.println("third string");
    }


d) Utilice llaves, { y } para aclarar aún más el código.

    public static void main(String[] args) {
        int aNumber = 3;
        if (aNumber >= 0) {
            if (aNumber == 0) {
                System.out.println("first string");
            } else {
                System.out.println("second string");
            }
        }
        System.out.println("third string");
    }
 */
