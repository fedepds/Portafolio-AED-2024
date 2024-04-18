package Ejercicio_3;

public class StringDemo {
    String palindrome = "Dot saw I was Tod";
    int len = palindrome.length();

    public static void main(String[] args) {
        String palindrome = "A cavar a Caravaca.";

        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] =
                    palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] =
                    tempCharArray[len - 1 - j];
        }

        String reversePalindrome =
                new String(charArray);
        System.out.println(reversePalindrome);
    }
}
/* Este codigo al invertir el string palidrome, tambien invierte los signos de puntuacion ya que al estrear entre comilla
son considerados como char y por lo tanto tambien se invierten.
 */