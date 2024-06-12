public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // cargar grafo con actores y relaciones
        TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("src/actores.csv", "src/en_pelicula.csv", false,
                TGrafoNoDirigido.class);

        // invocar a numBacon como indica la letra y mostrar en consola el resultado
        System.out.println(grafo.numBacon("John_Goodman"));
        System.out.println(grafo.numBacon("Tom_Cruise"));
        System.out.println(grafo.numBacon("Jason_Statham"));
        System.out.println(grafo.numBacon("Lukas_Haas"));
        System.out.println(grafo.numBacon("Djimon_Hounsou"));

        String[] bacon = { String.valueOf(grafo.numBacon("John_Goodman")),
                String.valueOf(grafo.numBacon("Tom_Cruise")),
                String.valueOf(grafo.numBacon("Jason_Statham")),
                String.valueOf(grafo.numBacon("Lukas_Haas")),
                String.valueOf(grafo.numBacon("Djimon_Hounsou")) };

        ManejadorArchivosGenerico.escribirArchivo("SALIDA", bacon);
    }

}
