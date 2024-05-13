package uy.edu.ucu.aed;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase utilitaria para el manejo de archivos de texto.
 */
public class ManejadorArchivosGenerico {

    /**
     * Escribe una lista de líneas en un archivo de texto.
     * Si el archivo no existe, se crea; si ya existe, se escribe al final del mismo.
     *
     * @param nombreCompletoArchivo Ruta completa del archivo a escribir.
     * @param listaLineasArchivo    Arreglo de cadenas de texto con las líneas a escribir en el archivo.
     */
    public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
        try (FileWriter fw = new FileWriter(nombreCompletoArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String lineaActual : listaLineasArchivo) {
                bw.write(lineaActual);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
    }

    /**
     * Lee un archivo de texto y retorna su contenido en forma de un arreglo de líneas.
     *
     * @param nombreCompletoArchivo Ruta completa del archivo a leer.
     * @return Arreglo de cadenas de texto con las líneas leídas del archivo.
     */
    public static String[] leerArchivo(String nombreCompletoArchivo) {
        ArrayList<String> listaLineasArchivo = new ArrayList<>();
        try (FileReader fr = new FileReader(nombreCompletoArchivo);
             BufferedReader br = new BufferedReader(fr)) {
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                listaLineasArchivo.add(lineaActual);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leído satisfactoriamente");

        return listaLineasArchivo.toArray(new String[0]);
    }
}