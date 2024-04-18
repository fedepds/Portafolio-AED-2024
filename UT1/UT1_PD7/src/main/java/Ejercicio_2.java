public class Ejercicio_2 {
    public static void main(String[] args) {
        String s1 = "Hola"; String s2 = "Hola"; if ( s1 == s2 ) {
            System.out.println( "True" ); } else {
            System.out.println( "False" ); }

        String s3 = new String("Hola"); String s4 = "Hola";
        if ( s3 == s4 ) {
            System.out.println( "True" ); } else {
            System.out.println( "False" ); }
    }
}
/*¿Qué sentencia se ejecuta como resultado del If en cada caso y por qué?
Busca en internet referencias que te permitan explicar las respuestas a las preguntas anteriores.
Asegúrate que las mismas sean autoritativas y cítalas adecuadamente en tu respuesta.
Propone una versión correcta del código del Ejercicio #1.


En el primer caso, la sentencia que se ejecuta es "True" ya que las dos variables apuntan a la misma dirección de memoria.
En el segundo caso, la sentencia que se ejecuta es "False" ya que las dos variables apuntan a direcciones de memoria distintas.
public class Ejercicio_1 {
    public static void main(String[] args) {
        String s = "1";
        while (!s.equals("1000")) {
            s += "0";
        }
    }
}
 */