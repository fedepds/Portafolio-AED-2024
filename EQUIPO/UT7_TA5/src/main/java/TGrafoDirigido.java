import java.util.*;

/**
 *
 * @author Ernesto
 */
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

    @Override
    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double[][] floyd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
