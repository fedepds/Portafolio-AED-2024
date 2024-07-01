import java.lang.reflect.Constructor;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de utilidad para operaciones de grafos.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class UtilGrafos {

    /**
     * Este método obtiene la matriz de costos de un mapa de vértices.
     * @param vertices El mapa de vértices del que se obtendrá la matriz de costos.
     * @return Una matriz de Double que representa los costos entre los vértices.
     */
    public static <T> Double[][] obtenerMatrizCostos(Map<Comparable, IVertice<T>> vertices) {
        int cantidadVertices = vertices.size();
        Double[][] matrizCostos = new Double[cantidadVertices][cantidadVertices];

        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (i == j) {
                    matrizCostos[i][j] = -1d;
                } else {
                    matrizCostos[i][j] = Double.MAX_VALUE;
                }
            }
        }

        int i = 0;

        Set<Comparable> etiquetasVertices = vertices.keySet();
        Object[] VerticesIArr = etiquetasVertices.toArray();
        Object[] VerticesJArr = etiquetasVertices.toArray();

        while (i < cantidadVertices) {
            int j = 0;
            while (j < cantidadVertices) {
                IVertice<T> elemVerticeI = vertices.get(VerticesIArr[i]);
                IVertice<T> elemVerticeJ = vertices.get(VerticesJArr[j]);

                if (!elemVerticeI.getEtiqueta().equals(elemVerticeJ.getEtiqueta())) {
                    IVertice<T> verticeI = elemVerticeI;
                    IVertice<T> verticeJ = elemVerticeJ;
                    Double costoAdyacencia = verticeI.obtenerCostoAdyacencia(verticeJ);
                    matrizCostos[i][j] = costoAdyacencia;
                }
                j++;
            }
            i++;
        }
        return matrizCostos;
    }

    /**
     * Este método imprime una matriz dada.
     * @param matriz La matriz que se imprimirá.
     * @param vertices El mapa de vértices que se utilizará para imprimir las etiquetas de la matriz.
     */
    public static void imprimirMatriz(Comparable[][] matriz, Map<Comparable, IVertice<?>> vertices) {
        Object[] etiquetas = vertices.keySet().toArray();
        System.out.print("  ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(etiquetas[i] + "  ");
        }
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(etiquetas[i] + " ");
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j].compareTo(Double.MAX_VALUE) == 0) {
                    System.out.print(" INF ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Este método imprime una matriz de una manera mejorada.
     * @param matriz La matriz que se imprimirá.
     * @param vertices El mapa de vértices que se utilizará para imprimir las etiquetas de la matriz.
     * @param titulo El título que se imprimirá antes de la matriz.
     */
    public static <T> void imprimirMatrizMejorado(Comparable[][] matriz, Map<Comparable, IVertice<T>> vertices, String titulo) {
        if (vertices != null && matriz.length == vertices.keySet().size()) {

            Comparable[] etiquetas = vertices.keySet().toArray(new Comparable[vertices.keySet().size()]);
            int etiquetaMasLarga = stringMasLargo(etiquetas);
            int datoMasLargo = 0;
            String infinito = "Inf";
            String nulo = "Nulo";
            int separacionEntreColumnas = 3;

            Comparable[] datos = new Comparable[matriz.length];

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] == null) {
                        datos[j] = nulo;
                    } else if (matriz[i][j].compareTo(Double.MAX_VALUE) == 0) {
                        datos[j] = infinito;
                    } else {
                        datos[j] = matriz[i][j];
                    }
                }
                if (stringMasLargo(datos) > datoMasLargo) {
                    datoMasLargo = stringMasLargo(datos);
                }
            }

            int largo = Math.max(etiquetaMasLarga, datoMasLargo) + separacionEntreColumnas;

            for (int i = 0; i < etiquetas.length; i++) {
                etiquetas[i] = rellenar(etiquetas[i].toString(), largo, ' ');
            }

            int tope = (largo) * (etiquetas.length + 1);

            String linea = rellenar("", tope, '-');
            String separador = rellenar("", largo, ' ');
            String sepTitulo = rellenar("", tope, '*');

            System.out.println(sepTitulo);
            System.out.println(devolverCentrado(titulo, tope));
            System.out.println(sepTitulo);
            System.out.println(linea);

            System.out.print(separador);
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(etiquetas[i]);
            }

            System.out.println();
            System.out.println(linea);

            for (int i = 0; i < matriz.length; i++) {
                System.out.print(etiquetas[i]);
                for (int j = 0; j < matriz.length; j++) {

                    if (matriz[i][j] == null) {
                        System.out.print(rellenar(nulo, largo, ' '));
                    } else if (matriz[i][j].compareTo(Double.MAX_VALUE) == 0) {
                        System.out.print(rellenar(infinito, largo, ' '));
                    } else {
                        System.out.print(rellenar(matriz[i][j].toString(), largo, ' '));
                    }
                }
                System.out.println();
                System.out.println(linea);
            }
        }
        System.out.println();
    }

    /**
     * Este método rellena un texto con un carácter de relleno hasta alcanzar un largo total.
     * @param textoARellenar El texto que se va a rellenar.
     * @param largoTotal El largo total que debe tener el texto después de rellenarlo.
     * @param relleno El carácter que se usará para rellenar el texto.
     * @return El texto rellenado hasta el largo total con el carácter de relleno.
     */
    public static String rellenar(String textoARellenar, int largoTotal, char relleno) {
        while (textoARellenar.length() < largoTotal) {
            textoARellenar += relleno;
        }
        return textoARellenar;
    }
    
    /**
     * Este método encuentra el largo del string más largo en un array de etiquetas.
     * @param etiquetas Un array de etiquetas donde se buscará el string más largo.
     * @return El largo del string más largo encontrado en el array de etiquetas.
     */
    public static int stringMasLargo(Comparable[] etiquetas) {
        int mayor = etiquetas[0].toString().length();
        for (int i = 1; i < etiquetas.length; i++) {
            if (etiquetas[i].toString().length() > mayor) {
                mayor = etiquetas[i].toString().length();
            }
        }
        return mayor;
    }
    
    /**
     * Este método centra un texto dentro de un espacio de un largo dado.
     * @param texto El texto que se va a centrar.
     * @param largo El largo del espacio en el que se centrará el texto.
     * @return El texto centrado dentro del espacio del largo dado.
     */
    public static String devolverCentrado(String texto, int largo) {
        boolean pos = false;
        while (texto.length() < largo) {
            if (pos == false) {
                texto += " ";
                pos = true;
            } else {
                texto = " " + texto;
                pos = false;
            }
        }
        return texto;
    }

    public static <T extends IGrafoDirigido<T>> T cargarGrafo(String nomArchVert, String nomArchAdy, boolean ignoreHeader, Class<T> claseDelGrafo) {
        return (T) cargarGrafo(nomArchVert, nomArchAdy, ignoreHeader, claseDelGrafo, TVertice.class);
    }
    
    public static <T, G extends IGrafoDirigido<T>, V extends IVertice<T>> G cargarGrafo(String nomArchVert, String nomArchAdy, boolean ignoreHeader, Class<G> claseDelGrafo, Class<V> claseDelVertice) {
        String[] vertices = ManejadorArchivosGenerico.leerArchivo(nomArchVert, ignoreHeader);
        String[] aristas = ManejadorArchivosGenerico.leerArchivo(nomArchAdy, ignoreHeader);
    
        List<IVertice<T>> verticesList = new ArrayList<IVertice<T>>(vertices.length);
        List<IArista> aristasList = new ArrayList<IArista>(aristas.length);
    
        for (String verticeString : vertices) {
            if ((verticeString != null) && (verticeString.trim() != "")) {
                try {
                    if (claseDelVertice != null) {
                        Constructor<V> constructor;
                        V vertice;
                        try {
                            // Try to get the variadic constructor
                            constructor = claseDelVertice.getConstructor(Object[].class);
                            vertice = constructor.newInstance(new Object[] { verticeString.split(",") });
                        } catch (NoSuchMethodException e) {
                            // If the variadic constructor doesn't exist, fall back to the current one
                            verticeString = verticeString.split(",")[0];
                            constructor = claseDelVertice.getConstructor(Comparable.class);
                            vertice = constructor.newInstance(verticeString);
                        }
                        verticesList.add(vertice);
                    } else {
                        verticesList.add(new TVertice<T>(verticeString));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(UtilGrafos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        for (String aristaString : aristas) {
            if ((aristaString != null) && (aristaString.trim() != "")) {
                String[] datos = aristaString.split(",");
                aristasList.add(new TArista(datos[0], datos[1], Double.parseDouble(datos[2])));
            }
        }
        
        try {
            claseDelGrafo.getConstructor(Collection.class, Collection.class);
            return (G) (claseDelGrafo.getConstructor(Collection.class, Collection.class).newInstance(verticesList, aristasList));
        } catch (Exception ex) {
            Logger.getLogger(UtilGrafos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
    }
}
