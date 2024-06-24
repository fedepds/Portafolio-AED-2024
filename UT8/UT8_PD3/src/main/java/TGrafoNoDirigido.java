import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoRedElectrica   {

    protected TAristas lasAristas = new TAristas() ;
    
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
        if(lasAristas != null && tempbool){ //Se modifico para que cuando se inserte una arista en un grafo no dirigido, tambien se inserte en "lasAristas".
            lasAristas.add(arista);
            lasAristas.add(arInv);
        }
        return tempbool;
    }
    
    public TAristas getLasAristas() {
        return lasAristas;
    }

    /**
     * Este método se utiliza para encontrar la mejor red eléctrica.
     * Utiliza el algoritmo de Prim para encontrar el árbol de expansión mínimo del grafo.
     * El algoritmo comienza seleccionando el primer vértice y luego añade iterativamente el borde de peso mínimo
     * que conecta los vértices ya seleccionados con los vértices que aún no están incluidos en el árbol.
     *
     * @return TAristas - el árbol de expansión mínimo del grafo representado como una lista de bordes.
     */
    @Override
    public TAristas mejorRedElectrica() {
        // Crear una lista de vértices del grafo
        LinkedList<Comparable> verticesAux = new LinkedList(getVertices().keySet());
        // Inicializar la lista de bordes para el árbol de expansión mínimo
        TAristas aristasAAM = new TAristas();
        // Inicializar la lista de vértices que ya están incluidos en el árbol
        LinkedList<Comparable> verticesAAM = new LinkedList<>();
        // Añadir el primer vértice al árbol
        verticesAAM.add(verticesAux.getFirst());
        // Eliminar el primer vértice de la lista de vértices que aún no están incluidos en el árbol
        verticesAux.removeFirst();
        // Mientras haya vértices que aún no están incluidos en el árbol
        while (!verticesAux.isEmpty()){
            // Encontrar el borde de peso mínimo que conecta los vértices ya seleccionados con los vértices que aún no están incluidos en el árbol
            TArista aristaAux = lasAristas.buscarMin(verticesAAM, verticesAux);
            // Añadir el borde encontrado al árbol
            aristasAAM.add(aristaAux);
            // Añadir el vértice de destino del borde encontrado a la lista de vértices que ya están incluidos en el árbol
            verticesAAM.add(aristaAux.getEtiquetaDestino());
            // Eliminar el vértice de destino del borde encontrado de la lista de vértices que aún no están incluidos en el árbol
            verticesAux.remove(aristaAux.getEtiquetaDestino());
        }
        // Devolver el árbol de expansión mínimo
        return aristasAAM;
    }

    /**
     * Este método se utiliza para encontrar la mejor red eléctrica utilizando un enfoque diferente.
     * Verifica si el grafo está conectado, si no lo está, devuelve null.
     * Crea un nuevo grafo no dirigido con los vértices del grafo original y sin aristas.
     * Clona las aristas del grafo original e inicializa una nueva lista de aristas para devolver.
     * Iterativamente encuentra la arista de peso mínimo de las aristas clonadas que conecta dos vértices que aún no están conectados en el nuevo grafo.
     * Añade la arista encontrada al nuevo grafo y a la lista de aristas para devolver.
     * Elimina la arista encontrada y su inversa de las aristas clonadas.
     * Repite el proceso hasta que el nuevo grafo esté conectado.
     *
     * @return TAristas - el árbol de expansión mínimo del grafo representado como una lista de aristas. Si el grafo no está conectado, devuelve null.
     */
    public TAristas mejorRedElectrica2() {
        // Verificar si el grafo está conectado, si no lo está, devolver null
        if(!esConexo())
            return null;
        // Crear un nuevo grafo no dirigido con los vértices del grafo original y sin aristas
        TGrafoNoDirigido grafoAAM = new TGrafoNoDirigido(new LinkedList(getVertices().values()), new LinkedList<>());
        // Clonar las aristas del grafo original
        TAristas aristasAux = (TAristas) getLasAristas().clone();
        // Inicializar una nueva lista de aristas para devolver
        TAristas aristasADevolver = new TAristas();
        do{
            // Encontrar la arista de peso mínimo de las aristas clonadas que conecta dos vértices que aún no están conectados en el nuevo grafo
            TArista aritasMinAux = aristasAux.buscarMin(getVertices().keySet(), getVertices().keySet());
            // Si los dos vértices conectados por la arista encontrada aún no están conectados en el nuevo grafo
            if(!grafoAAM.estanConectados(aritasMinAux.getEtiquetaOrigen(), aritasMinAux.getEtiquetaDestino())){
                // Añadir la arista encontrada al nuevo grafo
                grafoAAM.insertarArista(aritasMinAux);
                // Añadir la arista encontrada a la lista de aristas para devolver
                aristasADevolver.add(aritasMinAux);
            }
            // Eliminar la arista encontrada de las aristas clonadas
            aristasAux.remove(aritasMinAux);
            // Eliminar la inversa de la arista encontrada de las aristas clonadas
            aristasAux.remove(aristasAux.buscar(aritasMinAux.getEtiquetaDestino(), aritasMinAux.getEtiquetaOrigen()));
            // Repetir el proceso hasta que el nuevo grafo esté conectado
        }while (!grafoAAM.esConexo());
        // Devolver la lista de aristas
        return aristasADevolver;
    }
        
    public boolean estanConectados(Comparable origen, Comparable destino){
        desvisitarVertices();
        TVertice verticeOrigen = getVertices().get(origen);
        TVertice verticeDestino = getVertices().get(destino);
        if(verticeOrigen == null | verticeDestino == null){
            return false;
        }
        return verticeOrigen.conectadoCon(verticeDestino);
    }
    
        public boolean esConexo(){
        desvisitarVertices();
        LinkedList<TVertice> verticesAux = new LinkedList<>(getVertices().values());
        verticesAux.getFirst().bpf(new LinkedList());
        for (TVertice v : verticesAux){
            if(!v.getVisitado())
                return false;
        }
        return true;
    }

}
