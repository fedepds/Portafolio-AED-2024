import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // vertices del grafo.-

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
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return 
     */
    @Override
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
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el vertice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return 
     */
  
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
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
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
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
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    @Override
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
     if (!existeVertice(unaEtiqueta)) {
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


    /**
     * Este método se utiliza para encontrar el centro del grafo.
     * El centro de un grafo es el vértice con la excentricidad mínima.
     * La excentricidad de un vértice es la distancia máxima desde el vértice a todos los demás vértices en el grafo.
     *
     * @return La etiqueta del vértice que es el centro del grafo.
     */
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
    /**
     * Este método implementa el algoritmo de Floyd-Warshall con predecesores.
     * El algoritmo de Floyd-Warshall se utiliza para encontrar los caminos más cortos entre todos los pares de vértices en un grafo ponderado.
     * Esta versión del algoritmo también mantiene un seguimiento de los predecesores de cada vértice en el camino más corto.
     *
     * @param predecesores Un array 2D para almacenar el predecesor de cada vértice en el camino más corto. Si es null, se crea un nuevo array.
     * @return Un array 2D que representa las distancias del camino más corto entre cada par de vértices.
     */
    public Double[][] floyd_predecesores(int[][] predecesores) {
        // Obtener la matriz de costos de los vértices
        Double[][] matrixFloyd = UtilGrafos.obtenerMatrizCostos(getVertices());

        // Si el array de predecesores es null, crear un nuevo array
        if(predecesores == null){
            predecesores = new int[matrixFloyd.length][matrixFloyd.length];
        }

        // Para cada vértice en el grafo
        for (int k = 0; k < vertices.size(); k++){
            for (int i = 0; i < vertices.size(); i++){
                for (int j = 0; j < vertices.size(); j++){
                    // Si el camino a través del vértice k es más corto, actualizar la matriz de costos y el array de predecesores
                    if(matrixFloyd[i][k] + matrixFloyd[k][j] < matrixFloyd[i][j]){
                        matrixFloyd[i][j] = matrixFloyd[i][k] + matrixFloyd[k][j];
                        predecesores[i][j] = k;
                    }
                }
            }
        }

        // Devolver la matriz de costos
        return matrixFloyd;
    }

    /**
     * Este método se utiliza para calcular la excentricidad de un vértice en el grafo.
     * La excentricidad de un vértice es la distancia máxima desde el vértice a todos los demás vértices en el grafo.
     *
     * @param etiquetaVertice La etiqueta del vértice cuya excentricidad se va a calcular.
     * @return La excentricidad del vértice. Si el vértice no existe en el grafo, devuelve null.
     */
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
    /**
     * Este método implementa el algoritmo de Warshall para calcular el cierre transitivo de un grafo dirigido.
     * El cierre transitivo de un grafo es una matriz que representa la accesibilidad de cada vértice a todos los demás vértices del grafo.
     * El método inicializa primero una matriz con la matriz de adyacencia del grafo.
     * A continuación, itera sobre la matriz y actualiza la información de accesibilidad en función del vértice actual.
     * Si hay un camino desde el vértice i hasta el vértice k y un camino desde el vértice k hasta el vértice j, entonces hay un camino desde el vértice i hasta el vértice j.
     * El método devuelve la matriz de cierre transitivo.
      * @return Una matriz booleana 2D que representa el cierre transitivo del gráfico.
     */
    @Override
    public boolean[][] warshall() {
        // Obtener la matriz de costos de los vértices
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(getVertices());

        // Inicializar la matriz de Warshall con la misma longitud que la matriz de costos
        boolean[][] matrizWarshall = new boolean[matriz.length][matriz.length];

        int i, j, k;

        // Para cada vértice en la matriz
        for(i = 0; i < matriz.length; i++){
            for(j = 0; j < matriz.length; j++){
                // Si el costo es diferente de infinito y los vértices son diferentes, establecer la matriz de Warshall en verdadero
                matrizWarshall[i][j] = (matriz[i][j] != Double.MAX_VALUE && i != j);
            }
        }

        // Para cada vértice en el grafo
        for (k = 0; k < vertices.size(); k++){
            for (i = 0; i < vertices.size(); i++){
                for (j = 0; j < vertices.size(); j++){
                    // Si los vértices son diferentes y la matriz de Warshall es falsa
                    if ((i != k) && (k != j) && (i != j)){
                        if(!matrizWarshall[i][j]){
                            // Si hay un camino desde el vértice i hasta el vértice k y desde el vértice k hasta el vértice j, establecer la matriz de Warshall en verdadero
                            matrizWarshall[i][j] = (matrizWarshall[i][k] & matrizWarshall[k][j]);
                        }
                    }
                }
            }
        }

        // Devolver la matriz de Warshall
        return matrizWarshall;
    }

    /**
     * Este método realiza una búsqueda en profundidad primero (BPF) en el grafo.
     * Primero, marca todos los vértices como no visitados.
     * Luego, crea una colección para almacenar los vértices visitados durante la BPF.
     * Itera sobre todos los vértices en el grafo. Si un vértice no ha sido visitado, realiza una BPF desde este vértice.
     * Finalmente, devuelve una colección de los vértices visitados, que representa el bosque abarcador del grafo obtenido de la BPF.
     *
     * @return Una colección de vértices que representa el bosque abarcador del grafo obtenido de la BPF.
     */
    @Override
    public Collection<TVertice> bpf() {
        // Marcar todos los vértices como no visitados
        desvisitarVertices();

        // Crear una colección para almacenar los vértices visitados
        Collection<TVertice> bosqueAbarcador = new LinkedHashSet<>();

        // Para cada vértice en el grafo
        for (TVertice vertice : getVertices().values()) {
            // Si el vértice no ha sido visitado
            if (!vertice.getVisitado()) {
                // Realizar una BPF desde este vértice
                vertice.bpf(bosqueAbarcador);
            }
        }

        // Devolver la colección de vértices visitados
        return bosqueAbarcador;
    }

    /**
     * Este método realiza una búsqueda en profundidad (BPF) en el grafo a partir de una etiqueta de vértice dada.
     * Primero, busca el vértice de origen utilizando la etiqueta proporcionada.
     * Luego, llama al método BPF con el vértice encontrado como punto de partida.
     *
     * @param etiquetaOrigen La etiqueta del vértice de origen para la BPF.
     * @return Una colección que representa el árbol de expansión del grafo obtenido de la BPF.
     */
    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        TVertice origen = buscarVertice(etiquetaOrigen);

        return bpf(origen);
    }

    /**
     * Este método realiza una búsqueda en profundidad (BPF) en el grafo a partir de un vértice dado.
     * Primero, marca todos los vértices como no visitados.
     * Luego, crea una colección para almacenar los vértices visitados durante la BPF.
     * Si el vértice dado existe en el grafo, comienza la BPF desde este vértice.
     * Luego, itera sobre todos los vértices en el grafo. Si un vértice no ha sido visitado, realiza una BPF desde este vértice.
     * Finalmente, crea un árbol de expansión a partir de los vértices visitados y devuelve este árbol.
     *
     * @param vertice El vértice de inicio para la BPF.
     * @return Una colección que representa el árbol de expansión del grafo obtenido de la BPF.
     */
    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        Collection <TVertice> verti = new LinkedHashSet<>();
        if(getVertices().containsValue(vertice)){
            vertice.bpf(verti);
            for(TVertice v : getVertices().values()){
                if(!v.getVisitado()){
                    v.bpf(verti);
                }
            }
        }
        Collection<TVertice> bosqueAbarcador = new LinkedHashSet<>();
        bosqueAbarcador.addAll(verti);
        return bosqueAbarcador;
    }

    /**
     * Este método se utiliza para marcar todos los vértices del grafo como no visitados.
     * Recorre todos los vértices del grafo y establece su estado como no visitado.
     */
    @Override
    public void desvisitarVertices() {
        for(TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * Este método se utiliza para encontrar todos los caminos desde el vértice de origen hasta el vértice de destino.
     * Primero, desmarca todos los vértices como visitados.
     * Luego, busca el vértice de origen y crea una nueva colección para almacenar todos los caminos.
     * Si el vértice de origen existe, crea un nuevo camino con el vértice de origen como punto de partida.
     * Luego, llama al método todosLosCaminos del vértice de origen, pasando el vértice de destino, el camino previo y la colección de todos los caminos.
     * Finalmente, devuelve la colección de todos los caminos. Si el vértice de origen no existe, devuelve null.
     *
     * @param etiquetaOrigen La etiqueta del vértice de origen.
     * @param etiquetaDestino La etiqueta del vértice de destino.
     * @return Una colección de todos los caminos desde el vértice de origen hasta el vértice de destino, o null si el vértice de origen no existe.
     */
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TVertice origen = buscarVertice(etiquetaOrigen);
        TCaminos todosLosCaminos = new TCaminos();
        if (origen != null) {
            TCamino caminoPrevio = new TCamino(origen);
            origen.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }
    /**
     * Este método realiza una ordenación topológica en el grafo.
     * La ordenación topológica es un ordenamiento lineal de todos sus vértices de manera que si el grafo tiene un arco dirigido de un vértice A a un vértice B, entonces A aparece antes que B en la ordenación.
     * Este método utiliza una búsqueda en profundidad (DFS) para realizar la ordenación topológica.
     * Crea una pila y un conjunto para realizar un seguimiento de los vértices visitados.
     * Itera sobre todos los vértices en el grafo, y si un vértice no ha sido visitado, llama al método DFS en él.
     * Los vértices se agregan a la pila en postorden, lo que significa que un vértice se agrega a la pila solo después de que se hayan visitado todos sus vecinos.
     *
     * @return Una pila de vértices que representa el orden topológico del grafo.
     */
    public Stack<TVertice> ordenacionTopologica() {
        Stack<TVertice> pila = new Stack<>();
        Set<Comparable> visitados = new HashSet<>();
        for (TVertice v : vertices.values()) {
            if (!visitados.contains(v.getEtiqueta())) {
                v.ordenacionTopologicaDFS(visitados, pila);
            }
        }
        return pila;
    }
    /**
     * Este método genera todas las posibles ordenaciones topológicas del grafo.
     * Una ordenación topológica es un ordenamiento lineal de sus vértices de manera que para cada arista dirigida (u, v) desde el vértice u al vértice v, u viene antes que v en la ordenación.
     * Este método utiliza una búsqueda en profundidad (DFS) para generar las ordenaciones topológicas.
     * Crea una lista para almacenar la ordenación actual y un conjunto para realizar un seguimiento de los vértices visitados.
     * Itera sobre todos los vértices en el grafo, y si un vértice no ha sido visitado, llama al método DFS en él.
     * Los vértices se agregan a la lista en postorden, lo que significa que un vértice se agrega a la lista solo después de que todos sus vecinos hayan sido visitados.
     *
     * @return Una lista de listas de vértices, donde cada lista representa una posible ordenación topológica del grafo.
     */
    public List<List<TVertice>> todasLasOrdenacionesTopologicas() {
        List<List<TVertice>> todasLasOrdenaciones = new ArrayList<>();
        List<TVertice> ordenacionActual = new ArrayList<>();
        Set<Comparable> visitados = new HashSet<>();
        for (TVertice v : vertices.values()) {
            if (!visitados.contains(v.getEtiqueta())) {
                v.todasLasOrdenacionesTopologicasDFS(visitados, ordenacionActual, todasLasOrdenaciones);
            }
        }
        return todasLasOrdenaciones;
    }


    /**
     * Este método verifica si el grafo contiene ciclos.
     * Utiliza la Búsqueda en Profundidad (DFS) para detectar ciclos en el grafo.
     * Crea dos mapas para realizar un seguimiento de los vértices visitados y los vértices que están actualmente en la pila de recursión.
     * Itera sobre todos los vértices en el grafo. Si un vértice no ha sido visitado, llama a la función dfsCiclo en él.
     * Si la función dfsCiclo devuelve true, significa que se ha encontrado un ciclo y la función devuelve true.
     * Si no se encuentran ciclos después de iterar sobre todos los vértices, la función devuelve false.
     *
     * @return true si el grafo contiene al menos un ciclo, false en caso contrario.
     */
    public boolean tieneCiclos() {
        Map<Comparable, Boolean> visitados = new HashMap<>();
        Map<Comparable, Boolean> enPila = new HashMap<>();

        // Para cada vértice en el grafo
        for (TVertice vertice : this.getVertices().values()) {
            // Si el vértice no ha sido visitado, llama a la función dfsCiclo
            if (!visitados.getOrDefault(vertice.getEtiqueta(), false)) {
                if (vertice.dfsCiclo(visitados, enPila, this.getVertices())) {
                    return true;
                }
            }
        }

        return false;
    }
    /**
     * Este método realiza una ordenación topológica en el grafo y devuelve el resultado como una LinkedList.
     * Una ordenación topológica es un ordenamiento lineal de sus vértices de manera que para cada arista dirigida (u, v) desde el vértice u al vértice v, u viene antes que v en la ordenación.
     * Este método utiliza la Búsqueda en Profundidad (DFS) para realizar la ordenación topológica.
     * Crea una LinkedList para almacenar el orden actual y un HashSet para realizar un seguimiento de los vértices visitados.
     * Itera sobre todos los vértices en el grafo, y si un vértice no ha sido visitado, llama al método DFS en él.
     * Los vértices se agregan a la LinkedList en postorden, lo que significa que un vértice se agrega a la LinkedList solo después de que todos sus vecinos hayan sido visitados.
     *
     * @return Una LinkedList de vértices que representa el orden topológico del grafo.
     */
    public LinkedList<TVertice> ordenacionTopologica_lista() {
        LinkedList<TVertice> lista = new LinkedList<>();
        Set<Comparable> visitados = new HashSet<>();
        for (TVertice v : vertices.values()) {
            if (!visitados.contains(v.getEtiqueta())) {
                v.ordenacionTopologicaDFS_Lista(visitados, lista);
            }
        }
        return lista;
    }



    /**
     * Este método se utiliza para imprimir las etiquetas de los vértices en el orden dado.
     * Itera sobre la LinkedList de vértices e imprime la etiqueta de cada vértice.
     *
     * @param orden Una LinkedList de vértices que representa el orden en el que se deben imprimir las etiquetas de los vértices.
     */
    public void listarVertices(LinkedList<TVertice> orden) {
        for (TVertice vertice : orden) {
            System.out.println(vertice.getEtiqueta());
        }
    }
    public boolean estanConectados(Comparable origen, Comparable destino){
        desvisitarVertices();
        TVertice verticeOrigen = getVertices().get(origen);
        TVertice verticeDestino = getVertices().get(destino);
        if(verticeOrigen == null | verticeDestino == null){
            return false;
        }
        boolean result = verticeOrigen.conectadoCon(verticeDestino);
        desvisitarVertices();
        return result && verticeDestino.conectadoCon(verticeOrigen);
    }






}
