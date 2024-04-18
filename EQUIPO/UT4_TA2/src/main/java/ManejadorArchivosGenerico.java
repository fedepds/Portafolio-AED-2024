import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ManejadorArchivosGenerico {
    /**
     * @param nombreCompletoArchivo
     * @param listaLineasArchivo lista con las lineas del archivo
     * @throws IOException
     */
    public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
        FileWriter fw;
        try {
            fw = new FileWriter(nombreCompletoArchivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < listaLineasArchivo.length; i++){
                String lineaActual = listaLineasArchivo[i];
                bw.write(lineaActual);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        }
    }
    
    public static String[] leerArchivo(String nombreCompletoArchivo){
        FileReader fr;
        ArrayList<String> listaLineasArchivo = new ArrayList<String>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null){
                listaLineasArchivo.add(lineaActual);
                lineaActual = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");

        return listaLineasArchivo.toArray (new String [0]);
    }
    
    /**
	 * Metodo encargado de filtrar un texto, dejando solamente letras validas.-
	 * @param unaPalabra Palabra a evaluar
	 * @return Cadena de caracteres limpia
	 */
	public static String filtrarPalabra(String unaPalabra) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < unaPalabra.length(); i++) {
			char caracter = unaPalabra.charAt(i);
			if ((caracter >= 'A' && caracter <= 'Z') ||
					(caracter >= 'a' && caracter <= 'z'))
				sb.append(caracter);
		}
		
		return sb.toString();
	}
	
	/**
	    * Lee una string y devuelve las palabras que se encuentren dentro.
	    * @param strLine Línea a procesar
	    * @return Listado de palabras procesadas
	    */
	public static String[] palabrasPorLinea(String strLine) {
			StringTokenizer st = new StringTokenizer(strLine);
		    ArrayList<String> words = new ArrayList<String>();
		    while(st.hasMoreTokens()){
			    String temp = st.nextToken();
			    String word = temp.replaceAll("á", "a");
			    word = word.replaceAll("é", "e");
			    word = word.replaceAll("í", "i");
			    word = word.replaceAll("ó", "o");
			    word = word.replaceAll("ú", "u");
			    word = word.replaceAll("ñ", "n");
			    word = word.replaceAll("\\W+", "");
			    if (word.compareTo("") != 0){
			    	words.add(word);
				    //System.out.println(word);
			    }			    
		    }
		    return words.toArray(new String [0]);
		 }	
}
