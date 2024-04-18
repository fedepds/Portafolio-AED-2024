package EjercicioEntradaDeDatosYManejoDeStrings;

/*
 * EJERCICIO 3: Parte 1
 * El  teclado  T9  de  los  celulares  mapea  los  dígitos  a  letras.
 * Generalmente  se  encuentran agrupados  de  la  siguiente  forma:  ABC(2),
 * DEF(3),  GHI(4),  JKL(5),  MNO(6),  PQRS(7),  TUV(8), WXYZ(9), !espacio”(0),
 * !.”(1).
 * Escribe un programa Java que lea un archivo entrada.txt” y escriba en un
 * archivo salida.txt” los dígitos correspondientes al texto. Puedes asumir que
 * el texto de entrada no tiene ningún otro  caracter  más  que  los  nombrados
 * anteriormente.  Considera  letras  mayúsculas  y minúsculas.
 * Los archivos deben estar en la carpeta src del proyecto.
 * Creando  un  método  estático  llamado  “transformarTextoT9”  en  la  clase
 * “Principal”  del programa. La firma de este método será:
 * public static void transformarTextoT9(String rutaArchivo);
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TecladoT9 {
    public static void main(String[] args) {
        transformarTextoT9("/Users/federicopizarro/Desktop/array/src/main/java/EjercicioEntradaDeDatosYManejoDeStrings/entradaT9.txt");
    }

    public static void transformarTextoT9(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/federicopizarro/Desktop/array/src/main/java/EjercicioEntradaDeDatosYManejoDeStrings/salida.txt")))
        {

            String linea;
            while ((linea = br.readLine()) != null) {
                String textoT9 = convertirAT9(linea);
                bw.write(textoT9);
                bw.newLine();
            }
            System.out.println("La conversión se ha realizado con éxito.");

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertirAT9(String texto) {
        texto = texto.toUpperCase(); // Convertir a mayúsculas para asegurar la coincidencia de caracteres
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isAlphabetic(caracter)) {
                if (caracter >= 'A' && caracter <= 'C')
                    resultado.append("2");
                else if (caracter >= 'D' && caracter <= 'F')
                    resultado.append("3");
                else if (caracter >= 'G' && caracter <= 'I')
                    resultado.append("4");
                else if (caracter >= 'J' && caracter <= 'L')
                    resultado.append("5");
                else if (caracter >= 'M' && caracter <= 'O')
                    resultado.append("6");
                else if (caracter >= 'P' && caracter <= 'S')
                    resultado.append("7");
                else if (caracter >= 'T' && caracter <= 'V')
                    resultado.append("8");
                else if (caracter >= 'W' && caracter <= 'Z')
                    resultado.append("9");
            } else if (caracter == ' ')
                resultado.append("0");
            else if (caracter == '.')
                resultado.append("1");
        }
        return resultado.toString();
    }
}

