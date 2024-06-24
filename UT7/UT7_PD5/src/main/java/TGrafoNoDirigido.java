import java.util.Collection;
import java.util.LinkedList;

public  class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {
    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    /**
     * Este método implementa el algoritmo de búsqueda en anchura (BFS) en un grafo a partir de un vértice específico.
     * Primero marca todos los vértices como no visitados. Luego, comienza el recorrido BFS desde el vértice con la etiqueta dada.
     * Si hay algún vértice que no se ha visitado después del primer recorrido BFS, continúa el recorrido BFS para cada vértice no visitado.
     *
     * @param etiquetaOrigen La etiqueta del vértice donde comienza el recorrido BFS.
     * @return Una colección de vértices que han sido visitados durante el recorrido BFS.
     */
    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        // Marca todos los vértices como no visitados
        desvisitarVertices();

        // Comienza el recorrido BFS desde el vértice con la etiqueta dada
        TVertice vertice = this.getVertices().get(etiquetaOrigen);
        Collection<TVertice> visitados = new LinkedList<>();
        vertice.bea(visitados);

        // Continúa el recorrido BFS para cada vértice no visitado
        for (TVertice v : this.getVertices().values()){
            if(!v.getVisitado()){
                v.bea(visitados);
            }
        }

        // Devuelve la colección de vértices visitados
        return visitados;
    }

    @Override
    public boolean esConexo() {
        return false;
    }

    @Override
    public boolean conectados(TVertice origen, TVertice destino) {
        return false;
    }

    /**
     * Este método implementa el algoritmo de búsqueda en anchura (BFS) en todo el grafo.
     * Primero marca todos los vértices como no visitados. Luego, comienza el recorrido BFS para cada vértice en el grafo.
     * Si un vértice no ha sido visitado, comienza un recorrido BFS desde ese vértice.
     *
     * @return Una colección de vértices que han sido visitados durante el recorrido BFS.
     */
    @Override
    public Collection<TVertice> bea(){
        // Marca todos los vértices como no visitados
        desvisitarVertices();

        // Inicializa la colección de vértices visitados
        Collection<TVertice> visitados = new LinkedList<>();

        // Comienza el recorrido BFS para cada vértice en el grafo
        for (TVertice v : this.getVertices().values()){
            // Si un vértice no ha sido visitado, comienza un recorrido BFS desde ese vértice
            if(!v.getVisitado()){
                v.bea(visitados);
            }
        }

        // Devuelve la colección de vértices visitados
        return visitados;
    }
    /**
     * Este método calcula el número de Bacon para un actor dado.
     * El número de Bacon de un actor es el número de grados de separación que tienen del actor Kevin Bacon, según lo define el juego "Six Degrees of Kevin Bacon".
     * El método primero recupera el vértice correspondiente al actor dado del grafo.
     * Si el actor no existe en el grafo, devuelve -1.
     * Luego, recupera el vértice correspondiente a Kevin Bacon y calcula el número de Bacon para todos los actores en el grafo.
     * Finalmente, devuelve el número de Bacon del actor dado.
     *
     * @param actor El nombre del actor para el cual calcular el número de Bacon.
     * @return El número de Bacon del actor, o -1 si el actor no existe en el grafo.
     */
    @Override
    public int numBacon(Comparable actor) {
        // Obtiene el vértice correspondiente al actor dado
        TVertice actorBuscado = getVertices().get(actor);

        // Si el actor no existe en el grafo, devuelve -1
        if (actorBuscado == null){
            return -1;
        }

        // Obtiene el vértice correspondiente a Kevin Bacon
        TVertice kevin = getVertices().get("Kevin_Bacon");

        // Calcula el número de Bacon para todos los actores en el grafo
        kevin.numBacon();

        // Devuelve el número de Bacon del actor dado
        return actorBuscado.getBacon();
    }

}
