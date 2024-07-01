/**
 * Algoritmo y Estrucutras de Datos
 * Parcial 2 - Parte 3
 *
 */
public class MainParcial2 
{
    public static void main( String[] args )
    {
        // Cargar grafo a partir de archivos de entrada
        TGrafoDeLaRed grafo = UtilGrafos.cargarGrafo("./src/main/java/uy/edu/ucu/aed/parcial2/vertices.txt", "./src/main/java/uy/edu/ucu/aed/parcial2/aristas.txt", false, TGrafoDeLaRed.class, TVerticeDeLaRed.class);

        // Calculo de todos los caminos entre dos vertices
        TCaminos<TNodoDeLaRed> caminos = grafo.caminosDesdeHasta("Vertice_3", "Vertice_4");
        
        // Escribir archivo de salida con el resultado de la llamada anterior, con los caminos ordenados de menor a mayor costo, uno por línea.
        grafo.caminosDesdeHasta("Vertice_3","Vertice_4");


        TClasificador clasificador = new TClasificador();



        String[] salida = new String[]{ caminos.imprimirCaminos()};
        ManejadorArchivosGenerico.escribirArchivo("SALIDA",salida );

    }
}
