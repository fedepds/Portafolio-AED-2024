import java.util.Stack;
import java.io.*;

public class ControlCorchetes {


    public boolean esValido(String rutaArchivo) {
        Stack<Character> stack = new Stack<>();
        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            for (char c : linea.toCharArray()) {
                if (c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    else stack.pop();
                }
            }
            return stack.isEmpty();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            return false;
        }


    }


    public static void main(String[] args) {
        ControlCorchetes controlCorchetes = new ControlCorchetes();
        System.out.println(controlCorchetes.esValido("/Users/federicopizarro/Desktop/UT3_TA6/src/main/java/entradas.txt"));
    }
}
