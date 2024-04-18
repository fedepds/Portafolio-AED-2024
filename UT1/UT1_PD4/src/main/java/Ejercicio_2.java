import java.awt.*;

public class Ejercicio_2 {
    /*
    1) Indica qué es lo que está mal en el siguiente programa:
       public class SomethingIsWrong {
           public static void main(String[] args) {
               Rectangle myRect;
               myRect.width = 40;
               myRect.height = 50;
               System.out.println("myRect's area is " + myRect.area());
} }
    R: No se ha inicializado la variable myRect, por lo que no se puede acceder a sus atributos. Ademas myRect.area() no es un metodo de la clase Rectangle.

    2) Repara el error, ejecuta el programa y verifica que la salida es correcta.
*/


        public static void main(String[] args) {
            Rectangle myRect = new Rectangle();
            myRect.width = 40;
            myRect.height = 50;
            int area = myRect.width * myRect.height;
            System.out.println("myRect's area is " + area);

        }

    }
