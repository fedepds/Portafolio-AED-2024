import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class TGrafoDirigido<T> implements IGrafoDirigido<T> {

    protected final Map<Comparable, IVertice<T>> vertices; // Lista de vértices del grafo.

    // Constructor que inicializa el grafo con una colección de vértices y aristas.
    public TGrafoDirigido(Collection<IVertice<T>> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        for (IVertice<T> vertice : vertices) {
            insertarVertice(vertice);
        }
        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Método para eliminar una arista dada por un vértice origen y destino.
     * Si la adyacencia no existe, retorna falso.
     * Si las etiquetas son inválidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return Verdadero si la arista fue eliminada, falso en caso contrario.
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            IVertice<T> vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Método para eliminar un vértice en el grafo.
     * Si el vértice no existe, retorna falso.
     * Si la etiqueta es inválida, retorna falso.
     *
     * @param nombreVertice
     * @return Verdadero si el vértice fue eliminado, falso en caso contrario.
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Método para verificar la existencia de una arista.
     * Las etiquetas pasadas por parámetro deben ser válidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return Verdadero si existe la arista, falso en caso contrario.
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        IVertice<T> vertOrigen = buscarVertice(etiquetaOrigen);
        IVertice<T> vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Método para verificar la existencia de un vértice dentro del grafo.
     * La etiqueta especificada como parámetro debe ser válida.
     *
     * @param unaEtiqueta Etiqueta del vértice a buscar.
     * @return Verdadero si existe el vértice con la etiqueta indicada, falso en caso contrario.
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Método para buscar un vértice dentro del grafo.
     * La etiqueta especificada como parámetro debe ser válida.
     *
     * @param unaEtiqueta Etiqueta del vértice a buscar.
     * @return El vértice encontrado. Si no existe, retorna nulo.
     */
    public IVertice<T> buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Método encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vértice origen y destino. Para que la arista sea válida,
     * se deben cumplir los siguientes casos: 
     * 1) Las etiquetas pasadas por parámetros son válidas.
     * 2) Los vértices (origen y destino) existen dentro del grafo.
     * 3) No es posible ingresar una arista ya existente (mismo origen y mismo destino, aunque el costo sea diferente).
     * 4) El costo debe ser mayor que 0.
     *
     * @param arista La arista a insertar
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            IVertice<T> vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice<T> vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Método encargado de insertar un vértice en el grafo.
     *
     * No pueden ingresarse vértices con la misma etiqueta. La etiqueta
     * especificada como parámetro debe ser válida.
     *
     * @param vertice El vértice a ingresar.
     * @return True si se pudo insertar el vértice, false en caso contrario
     */
    @Override
    public boolean insertarVertice(IVertice<T> vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    /**
     * Método que devuelve las etiquetas de los vértices en orden.
     *
     * @return Array de etiquetas ordenadas
     */
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice<T>> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * Método que desmarca todos los vértices como visitados.
     */
    @Override
    public void desvisitarVertices() {
        for (IVertice<T> vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * Método que devuelve el mapa de vértices del grafo.
     *
     * @return Mapa de vértices
     */
    @Override
    public Map<Comparable, IVertice<T>> getVertices() {
        return vertices;
    }

    /**
     * Método que realiza una búsqueda en profundidad (BPF) a partir de un vértice dado.
     *
     * @param vertice El vértice de inicio para la BPF
     * @return Colección de vértices visitados durante la BPF
     */
    @Override
    public Collection<IVertice<T>> bpf(IVertice<T> vertice) {
        this.desvisitarVertices();
        Collection<IVertice<T>> visitados = new LinkedList<IVertice<T>>();
        
        if(this.existeVertice(vertice.getEtiqueta())) {
            IVertice<T> vert=this.buscarVertice(vertice.getEtiqueta());
            vert.bpf(visitados);
        }
        return visitados;
    }

    /**
     * Método que verifica si un camino tiene un ciclo.
     *
     * @param camino El camino a verificar
     * @return True si el camino tiene un ciclo, false en caso contrario
     */
    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Método no implementado aún.");
    }

    /**
     * Realiza una búsqueda en profundidad (BPF) en el grafo.
     * @return Colección de vértices visitados durante la BPF.
     */
    @Override
    public Collection<IVertice<T>> bpf() {
        Collection<IVertice<T>> listaBpf = new LinkedList<IVertice<T>>();
        this.desvisitarVertices();
        
        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (IVertice<T> vertV : vertices.values()) {
                if (!vertV.getVisitado()) {
                    vertV.bpf(listaBpf);
                }
            }
        }
        return listaBpf;
    }

    /**
     * Realiza una búsqueda en profundidad (BPF) en el grafo a partir de un vértice dado.
     * @param etiquetaOrigen Etiqueta del vértice de inicio para la BPF.
     * @return Colección de vértices visitados durante la BPF.
     */
    @Override
    public Collection<IVertice<T>> bpf(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<IVertice<T>> visitados= new LinkedList<IVertice<T>>();
        
        if(this.existeVertice(etiquetaOrigen))
        {
            IVertice<T> vertice = this.buscarVertice(etiquetaOrigen);
            vertice.bpf(visitados);
        }
        return visitados;
    }

    /**
     * Obtiene el centro del grafo.
     * @return Etiqueta del vértice que es el centro del grafo.
     */
    @Override
    public Comparable centroDelGrafo() {
        Iterator<IVertice<T>> it = vertices.values().iterator();
        Comparable[] excentricidades = new Comparable[vertices.size()];
        Comparable centro = Double.MAX_VALUE;
        Comparable etiqueta_centro = null;
        int i = 0;
        while(it.hasNext()){
            Comparable a = excentricidades[i];
            Comparable etiqueta_vertice = it.next().getEtiqueta();
            
            a = this.obtenerExcentricidad(etiqueta_vertice);
            if(a.compareTo(centro) == -1){
                centro = a;
                etiqueta_centro = etiqueta_vertice;
            }
        }
        return etiqueta_centro+" (" + centro.toString().trim()+")";
    }

    /**
     * Implementa el algoritmo de Floyd para encontrar el camino más corto entre todos los pares de vértices.
     * @return Matriz de costos mínimos entre cada par de vértices.
     */
    @Override
    public Double[][] floyd() {
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(vertices);
        for (int k = 0; k < matriz.length; k++) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if(i!=j && i!=k && k!=j){
                        if (matriz[i][k] + matriz[k][j] < matriz[i][j]) {
                            matriz[i][j] = matriz[i][k] + matriz[k][j];
                        }
                    }
                }
            }
        }
        
        return matriz;
    }

    /**
     * Obtiene la excentricidad de un vértice.
     * @param etiquetaVertice Etiqueta del vértice.
     * @return Excentricidad del vértice.
     */
    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matriz = this.floyd();
        Set<Comparable> etiquetasVertices = this.vertices.keySet();
        Comparable[] array = new Comparable[matriz.length];
        array = etiquetasVertices.toArray(array);
        int columna = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == etiquetaVertice){
                columna = i;
                break;
            }
        }
        Double ex = 0.0;
        for (int i =0; i<matriz.length; i++){
            if(matriz[i][columna]>ex && matriz[i][columna]<Double.MAX_VALUE && matriz[i][columna]>0.0){
                ex = matriz[i][columna];
            }
        }
        if (ex == 0.0){
            ex = Double.MAX_VALUE;
        }
        return ex;
    }

    /**
     * Implementa el algoritmo de Warshall para determinar la conectividad entre los vértices del grafo.
     * @return Matriz de conectividad.
     */
    @Override
    public boolean[][] warshall() {
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] war = new boolean[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                war[i][j] = false;

                if (i != j && matriz[i][j] != Double.MAX_VALUE) {
                    war[i][j] = true;
                }
            }
        }
        for (int k = 0; k < war.length; k++) {
            for (int i = 0; i < war.length; i++) {
                for (int j = 0; j < war.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!war[i][j]) {
                            war[i][j] = war[i][k] && war[k][j];
                        }
                    }
                }
            }
        }
        return war;
    }

    /**
     * Obtiene todos los caminos entre dos vértices.
     * @param etiquetaOrigen Etiqueta del vértice origen.
     * @param etiquetaDestino Etiqueta del vértice destino.
     * @return Colección de todos los caminos entre los dos vértices.
     */
    @Override
    public TCaminos<T> todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        IVertice<T> v = buscarVertice(etiquetaOrigen);
        IVertice<T> u = buscarVertice(etiquetaDestino);
        if ((v != null)&&(u != null)) {
            TCaminos<T> todosLosCaminos = new TCaminos<T>();
            TCamino<T> caminoPrevio = new TCamino<T>(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }

    /**
     * Verifica si existe un ciclo en el grafo a partir de un vértice dado.
     * @param etiquetaOrigen Etiqueta del vértice de inicio.
     * @return Verdadero si existe un ciclo, falso en caso contrario.
     */
    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
       desvisitarVertices();
        boolean res = false;
        
        for (IVertice<T> vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                LinkedList camino = new LinkedList();
                camino.add(vertV.getEtiqueta());
                res = vertV.tieneCiclo(camino);
                return true;
            }
        }
        return res;
    }

    /**
     * Verifica si existe un ciclo en el grafo.
     * @return Verdadero si existe un ciclo, falso en caso contrario.
     */
    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
        boolean res = false;
        
        for (IVertice<T> vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                LinkedList camino = new LinkedList();
                camino.add(vertV.getEtiqueta());
                res = vertV.tieneCiclo(camino);
                if(res){
                    return true;
                }
            }
        }
        return res;
    }

    /**
     * Realiza una búsqueda en amplitud (BEA) en el grafo.
     * @return Colección de vértices visitados durante la BEA.
     */
    @Override
    public Collection<IVertice<T>> bea() {
       if (this.getVertices().isEmpty()) {
            return null;
        } else {
            this.desvisitarVertices();
            for (IVertice<T> vertV : this.getVertices().values()) {
                if (!vertV.getVisitado()) {
                   Collection<IVertice<T>> verts = new LinkedList<IVertice<T>>();
                   vertV.bea(verts);
                   return verts;
                }
            }
        }
        return null;
    }
}
