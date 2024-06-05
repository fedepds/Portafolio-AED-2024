
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilGrafos {

    public static Double[][] obtenerMatrizCostos(Map<Comparable, TVertice> vertices) {
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
                TVertice elemVerticeI = vertices.get(VerticesIArr[i]);
                TVertice elemVerticeJ = vertices.get(VerticesJArr[j]);

                if (!elemVerticeI.getEtiqueta().equals(elemVerticeJ.getEtiqueta())) {
                    TVertice verticeI = (TVertice) elemVerticeI;
                    TVertice verticeJ = (TVertice) elemVerticeJ;
                    Double costoAdyacencia = verticeI.obtenerCostoAdyacencia(verticeJ);
                    matrizCostos[i][j] = costoAdyacencia;
                }
                j++;
            }
            i++;
        }
        return matrizCostos;
    }

    public static void imprimirMatriz(Comparable[][] matriz, Map<Comparable, TVertice> vertices) {
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

    public static void imprimirMatrizMejorado(Comparable[][] matriz, Map<Comparable, TVertice> vertices, String titulo) {
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

    public static String rellenar(String textoARellenar, int largoTotal, char relleno) {
        while (textoARellenar.length() < largoTotal) {
            textoARellenar += relleno;
        }
        return textoARellenar;
    }

    public static int stringMasLargo(Comparable[] etiquetas) {
        int mayor = etiquetas[0].toString().length();
        for (int i = 1; i < etiquetas.length; i++) {
            if (etiquetas[i].toString().length() > mayor) {
                mayor = etiquetas[i].toString().length();
            }
        }
        return mayor;
    }

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

  
    }

    
