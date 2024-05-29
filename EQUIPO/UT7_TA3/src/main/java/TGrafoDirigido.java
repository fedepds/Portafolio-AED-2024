
import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        // Inicializar la excentricidad mínima como el valor máximo posible
        Double excentricidadMinima = Double.MAX_VALUE;

        // Inicializar el centro del grafo como null
        Comparable centro = null;

        // Obtener las etiquetas de los vértices del grafo
        Object[] etiquetas = getEtiquetasOrdenado();

        // Para cada vértice, obtener la excentricidad
        for (Object etiqueta : etiquetas) {
            Comparable etiquetaVertice = (Comparable) etiqueta;
            Double excentricidad = obtenerExcentricidad(etiquetaVertice);

            // Si la excentricidad es menor que la excentricidad mínima, actualizar la excentricidad mínima y el centro del grafo
            if (excentricidad < excentricidadMinima) {
                excentricidadMinima = excentricidad;
                centro = etiquetaVertice;
            }
        }

        // Devolver el centro del grafo
        return centro;
    }

    /**
     * Este método implementa el algoritmo de Floyd-Warshall para encontrar los caminos más cortos entre todos los pares de vértices en el grafo.
     * El algoritmo funciona mejorando incrementalmente una estimación del camino más corto entre dos vértices, hasta que la estimación es óptima.
     *
     * @return Una matriz 2D que representa las distancias del camino más corto entre cada par de vértices.
     */
    @Override
    public Double[][] floyd() {
        // Obtener el número de vértices en el grafo
        int n = getVertices().size();

        // Inicializar la matriz de costos con los pesos de los bordes en el grafo
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(getVertices());

        // Inicializar la matriz de caminos con los mismos valores que la matriz de costos
        Double[][] matrizCaminos = new Double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrizCostos[i], 0, matrizCaminos[i], 0, n);
        }

        // Para cada vértice, considerar cada par de vértices sin él
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    for (int j = 0; j < n; j++) {
                        if ((j != k) && (j != i)) {
                            // Si el camino a través del vértice k es más corto, actualizar la matriz de caminos
                            if ((matrizCaminos[i][k] + matrizCaminos[k][j]) < matrizCaminos[i][j]) {
                                matrizCaminos[i][j] = matrizCaminos[i][k] + matrizCaminos[k][j];
                            }
                        }
                    }
                }
            }
        }

        // Devolver la matriz de caminos con las distancias del camino más corto
        return matrizCaminos;
    }

    @Override
    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        // Buscar el vértice en el grafo
        TVertice vertice = buscarVertice(etiquetaVertice);

        if (vertice != null) {
            // Obtener la matriz de costos del grafo
            Double[][] matrizCostos = floyd();

            // Obtener el índice del vértice en la matriz
            int indiceVertice = Arrays.asList(getEtiquetasOrdenado()).indexOf(etiquetaVertice);

            // Inicializar la excentricidad como el valor mínimo posible
            Double excentricidad = Double.MIN_VALUE;

            // Recorrer la fila correspondiente al vértice en la matriz de costos
            for (int j = 0; j < matrizCostos[indiceVertice].length; j++) {
                // Si el costo es mayor que la excentricidad actual y es diferente de infinito, actualizar la excentricidad
                if (matrizCostos[indiceVertice][j] > excentricidad && matrizCostos[indiceVertice][j] != Double.MAX_VALUE) {
                    excentricidad = matrizCostos[indiceVertice][j];
                }
            }

            // Devolver la excentricidad del vértice
            return excentricidad;
        }

        // Si el vértice no existe en el grafo, devolver null
        return null;
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
