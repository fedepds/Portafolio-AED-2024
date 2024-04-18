package Ejercicio_3;
import java.io.*;
import java.util.ArrayList;

public class Ejercicio_3 {
    ArrayList<String> array1 = new ArrayList<>();

    public ArrayList<String> leerArchivo(String nombreCompletoArchivo){
        FileReader fr;
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null){
                System.out.println(lineaActual);
                array1.add(lineaActual);
                lineaActual = br.readLine();
            }
            return array1;
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");
        return array1;
    }
}