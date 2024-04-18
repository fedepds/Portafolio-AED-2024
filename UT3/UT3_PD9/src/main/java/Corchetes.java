import java.util.ArrayDeque;
import java.util.Deque;

public class Corchetes {

    /*
     * Dado un String que solamente contiene los caracteres '(', ')', '{', '}', '[' y ']',
     * implementa un algoritmo para determinar si es válido.
     *
     * Ejemplo 1:
     *  Input: "([]){}"
     *  Output: true
     *
     * Ejemplo 2:
     *  Input: "({)}"
     *  Output: false
     */

        public boolean controlCorchetes(String listaDeEntrada) {
            Deque<Character> stack = new ArrayDeque<Character>();

            for (char c : listaDeEntrada.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(getOpposite(c));
                } else {
                    if (stack.isEmpty() || stack.pop() != c) return false;
                }
            }

            return stack.isEmpty();
        }

        private char getOpposite(char c) {
            if (c == '(') return ')';
            if (c == '{') return '}';
            if (c == '[') return ']';

            return '0';
        }

    public static void main(String[] args) {
        Corchetes corchetes = new Corchetes();
        System.out.println(corchetes.controlCorchetes("([]){}"));
        System.out.println(corchetes.controlCorchetes("({)}"));
    }

}
